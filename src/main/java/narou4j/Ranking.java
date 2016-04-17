package narou4j;

import narou4j.enums.RankingType;
import narou4j.network.NarouApiClient;

import java.util.Date;
import java.util.List;

public class Ranking extends GetParameter4Ranking {

    private NarouApiClient client;

    public Ranking() {
        params.put("out", "json");
        setGzip(5);
    }

    /**
     * 指定されたランキングタイプ{@link RankingType}({@link NovelRank})で最新のランキングを取得します．
     *
     * @param type RankingType
     * @return NovelRank list
     */
    public List<NovelRank> getRanking(RankingType type) {
        client = new NarouApiClient();
        params.put("rtype", Utils.getRankingType2String(type, new Date()));
        return Utils.response2Json4Ranking(client.getRanking(params), isGzip);
    }

    /**
     * 指定されたランキングタイプ{@link RankingType}({@link NovelRank})で指定日時時点のランキングを取得します．
     *
     * @param type RankingType
     * @param date Date
     * @return NovelRank list
     */
    public List<NovelRank> getRanking(RankingType type, Date date) {
        client = new NarouApiClient();
        params.put("rtype", Utils.getRankingType2String(type, date));
        return Utils.response2Json4Ranking(client.getRanking(params), isGzip);
    }
}
