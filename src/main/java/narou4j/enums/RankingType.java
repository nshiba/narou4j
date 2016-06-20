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

    public static RankingType getOutputOrder(String id) {
        for (RankingType type : values()) {
            if (id.equals(type.getId())) {
                return type;
            }
        }

        throw new IllegalArgumentException("no such enum object for the id: " + id);
    }
}
