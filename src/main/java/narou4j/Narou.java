package narou4j;

import narou4j.network.NarouApiClient;

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
        params.put("of", getOfParam());
        params.put("genre", getGenre());
        params.put("notgenre", getNotGenre());
        params.put("userid", getUserIds());
        params.put("ncode", getNcodes());
        return Utils.response2Json4Novel(client.getNovels(params), isGzip);
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
        List<Novel> novels = Utils.response2Json4Novel(client.getNovels(params), isGzip);
        return novels.get(novels.size() -1);
    }
}
