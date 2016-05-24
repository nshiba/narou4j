package narou4j;

import narou4j.entities.Novel;
import narou4j.entities.NovelBody;
import narou4j.entities.NovelRank;
import narou4j.enums.RankingType;
import narou4j.network.NarouApiClient;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Narou extends GetParameter4Narou {

    private NarouApiClient client;

    public Narou() {
        params.put("out", "json");
        setGzip(5);
    }

    /**
     * パラメータにセットされた項目で小説を検索し結果をListで返すメソッド．
     *
     * @return List Novel {@link Novel}
     */
    public List<Novel> getNovels() {
        client = new NarouApiClient();
        setAllParams();
        try {
            return Utils.response2Json4Novel(client.getNovels(params), isGzip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 小説のNコードを指定して取得します．
     *
     * @param ncode String
     * @return Novel {@link Novel}
     */
    public Novel getNovel(String ncode) {
        client = new NarouApiClient();
        params.put("ncode", ncode);
        setAllParams();

        List<Novel> novels = null;
        try {
            novels = Utils.response2Json4Novel(client.getNovels(params), isGzip);
            return novels.get(novels.size() -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 小説の目次のみを取得します
     *
     * @param ncode String 小説コード
     * @return NovelBody list {@link NovelBody}
     */
    public List<NovelBody> getNovelTable(String ncode) {
        client = new NarouApiClient();
        setAllParams();

        Response response = client.getNovelTable(ncode);

        String html = "";
        try {
            html = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (html.equals("")) {
            return null;
        }

        Document document = Jsoup.parse(html);
        Elements elements = document.select(".index_box").first().children();
        ArrayList<NovelBody> list = new ArrayList<>();
        for (Element element : elements) {

            NovelBody table = new NovelBody();

            if (element.className().equals("chapter_title")) {
                table.setChapter(true);
                table.setTitle(element.ownText());
                list.add(table);
            }

            if (element.className().equals("novel_sublist2")) {
                Element el = element.select(".subtitle a").first();
                table.setTitle(el.ownText());

                String attr = el.attr("href");
                String[] attrs = attr.split("/", 0);
                table.setNcode(attrs[1]);
                table.setPage(Integer.parseInt(attrs[2]));
                list.add(table);
            }
        }

        return list;
    }

    /**
     * 指定した小説の指定したページの本文を取得します
     *
     * @param ncode String 小説コード
     * @param page int ページ数
     * @return {@link NovelBody} 本文
     */
    public NovelBody getNovelBody(String ncode, int page) {
        if (page == 0) {
            return null;
        }

        client = new NarouApiClient();
        setAllParams();

        Response response = client.getNovelBody(ncode, page);

        String html = "";
        try {
            html = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (html.equals("")) {
            return null;
        }

        NovelBody result = new NovelBody();
        result.setNcode(ncode);
        result.setPage(page);

//        System.out.println("ncode: " + ncode + " page: " + String.valueOf(page));
//        System.out.println(html);
        Document document = Jsoup.parse(html);

        String title = document.select(".novel_subtitle").first().ownText();
        result.setTitle(title);

        Element element = document.getElementById("novel_honbun");

//        System.out.println(element.select("ruby").outerHtml());

        String body = element.html();
        String kaigyo = System.getProperty("line.separator");
        body = body.replaceAll(kaigyo, "");
        body = body
                .replaceAll("<ruby>", "")
                .replaceAll("</ruby>", "")
                .replaceAll("<rb>", "")
                .replaceAll("</rb>", "")
                .replaceAll("<rt>", "")
                .replaceAll("</rt>", "")
                .replaceAll("<rp>", "")
                .replaceAll("</rp>", "");
        body = body.replaceAll("<br>", kaigyo);
        result.setBody(body);
        return result;
    }

    /**
     * パラメータにセットされた項目で小説を検索し本文を含む全てを取得した小説リストを返します
     *
     * @return Novel list {@link Novel}
     */
    public List<Novel> getNovelsAll() {
        List<Novel> novels = getNovels();
        novels.remove(0);
        for (Novel novel : novels) {
            novel = getNovelAll(novel.getNcode());
        }

        return novels;
    }

    /**
     * 指定した小説のページの本文を含む全てを取得します
     *
     * @param ncode String 小説コード
     * @return Novel list {@link Novel}
     */
    public Novel getNovelAll(String ncode) {
        Novel novel = getNovel(ncode);
        ArrayList<NovelBody> list = new ArrayList<>(getNovelTable(ncode));
        for (NovelBody body : list) {
            if (!body.isChapter()) {
                body.setBody(getNovelBody(ncode, body.getPage()).getBody());
            }
        }
        novel.setBodies(list);

        return novel;
    }

    /**
     * 指定した小説の全てのページの本文を含む目次を取得します
     *
     * @param ncode String 小説コード
     * @return NovelBody list {@link NovelBody}
     */
    public List<NovelBody> getNovelBodyAll(String ncode) {
        ArrayList<NovelBody> list = new ArrayList<>(getNovelTable(ncode));
        for (NovelBody body : list) {
            if (!body.isChapter()) {
                body.setBody(getNovelBody(ncode, body.getPage()).getBody());
            }
        }

        return list;
    }
}