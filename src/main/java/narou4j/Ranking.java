package narou4j;

import narou4j.entities.NovelRank;
import narou4j.enums.RankingType;
import narou4j.network.NarouApiClient;

import java.io.IOException;
import java.util.Calendar;
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
        try {
            String typeString = Utils.getRankingType2String(type, new Date());
            params.put("rtype", typeString);
            return Utils.response2Json4Ranking(client.getRanking(params), isGzip);
        } catch (IOException e) {
            Calendar cal = Calendar.getInstance();
            e.printStackTrace();
            cal.setTime(new Date());
            switch (type) {
                case DAILY: {
                    cal.add(Calendar.DAY_OF_MONTH, -1);
                    break;
                }
                case WEEKLY: {
                    cal.add(Calendar.DAY_OF_MONTH, -7);
                    break;
                }
                case MONTHLY: {
                    cal.add(Calendar.MONTH, -1);
                    break;
                }
                case QUARTET: {
                    cal.add(Calendar.MONTH, -3);
                }
            }

            String typeString = Utils.getRankingType2String(type, cal.getTime());
            params.put("rtype", typeString);
            try {
                return Utils.response2Json4Ranking(client.getRanking(params), isGzip);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return null;
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
        try {
            return Utils.response2Json4Ranking(client.getRanking(params), isGzip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 指定された小説コードの過去のランクイン情報を取得します
     *
     * @param ncode String 小説コード
     * @return NovelRank list 過去の各ランクイン情報のリスト {@link NovelRank}
     */
    public List<NovelRank> getRankinDetail(String ncode) {
        client = new NarouApiClient();
        params.put("ncode", ncode);
        try {
            return Utils.response2Json4Ranking(client.getRankinDetail(params), isGzip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
