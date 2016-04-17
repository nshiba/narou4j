package narou4j.enums;

/**
 * ランキングの項目 <br> <br>
 *
 * DAILY 日間ランキング <br>
 * WEEKLY 週間ランキング <br>
 * MONTHLY 月間ランキング <br>
 * QUARTET 四半期ランキング <br>
 */
public enum RankingType {
    DAILY("-d"),
    WEEKLY("-w"),
    MONTHLY("-m"),
    QUARTET("-q");

    private String id;

    private RankingType(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}
