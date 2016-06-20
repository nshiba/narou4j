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

    public static void main(String[] args) {
        Narou narou = new Narou();
        List<Novel> novels = null;
        try {
            novels = narou.getNovels();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (novels == null) {
            System.out.println("novels is null");
            return;
        }

        for (Novel novel : novels) {
            System.out.println("Novel {");
            System.out.println("    " + "allCount = " + novel.getAllcount());
            System.out.println("    " + "ncode = " + novel.getNcode());
            System.out.println("    " + "title = " + novel.getTitle());
            System.out.println("}");
        }
    }

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
    public List<Novel> getNovels() throws IOException {
        client = new NarouApiClient();
        setAllParams();
        return Utils.response2Json4Novel(client.getNovels(params), isGzip);
    }

    /**
     * 小説のNコードを指定して取得します．
     *
     * @param ncode String
     * @return Novel {@link Novel}
     */
    public Novel getNovel(String ncode) throws IOException {
        client = new NarouApiClient();
        params.put("ncode", ncode);
        setAllParams();

        List<Novel> novels = Utils.response2Json4Novel(client.getNovels(params), isGzip);
        return novels.get(novels.size() -1);
    }

    /**
     * 小説の目次のみを取得します
     *
     * @param ncode String 小説コード
     * @return NovelBody list {@link NovelBody}
     */
    public List<NovelBody> getNovelTable(String ncode) throws IOException {
        client = new NarouApiClient();
        setAllParams();

        Response response = client.getNovelTable(ncode);

        String html = response.body().string();

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
    public NovelBody getNovelBody(String ncode, int page) throws IOException {
        if (page == 0) {
            return null;
        }

        client = new NarouApiClient();
        setAllParams();

        Response response = client.getNovelBody(ncode, page);

        String html = response.body().string();

        if (html.equals("")) {
            return null;
        }

        NovelBody result = new NovelBody();
        result.setNcode(ncode);
        result.setPage(page);

        Document document = Jsoup.parse(html);

        // subtitle取得
        String title = document.select(".novel_subtitle").first().ownText();
        result.setTitle(title);

        // 本文取得
        Element element = document.getElementById("novel_honbun");

        // 整形
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
    public List<Novel> getNovelsAll() throws IOException {
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
    public Novel getNovelAll(String ncode) throws IOException {
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
    public List<NovelBody> getNovelBodyAll(String ncode) throws IOException {
        ArrayList<NovelBody> list = new ArrayList<>(getNovelTable(ncode));
        for (NovelBody body : list) {
            if (!body.isChapter()) {
                body.setBody(getNovelBody(ncode, body.getPage()).getBody());
            }
        }

        return list;
    }
}