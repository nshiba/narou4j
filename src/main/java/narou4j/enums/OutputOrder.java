package narou4j.enums;

public enum OutputOrder {
    BOOKMARK_COUNT("favnovelcnt"),
    REVIEW_COUNT("reviewcnt"),
    TOTAL_POINT("hyoka"),
    TOTAL_POINT_ASC("hyokaasc"),
    IMPRESSION_COUNT("impressioncnt"),
    HYOKA_COUNT("hyokacnt"),
    HYOKA_COUNT_ASC("hyokacntasc"),
    WEEKLY_UU("weekly"),
    CHARACTER_LENGTH_DESC("lengthdesc"),
    CHARACTER_LENGTH_ASC("lengthasc"),
    NCODE_DESC("ncodedesc"),
    OLD("old");

    private String id;

    private OutputOrder(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}
