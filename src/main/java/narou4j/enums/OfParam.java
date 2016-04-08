package narou4j.enums;

public enum OfParam {
    TITLE("t"),
    NCODE("n"),
    USERID("u"),
    WRITER("w"),
    STORY("s"),
    GENRE("g"),
    KEYWORD("k"),
    GENERAL_FIRSTUP("gf"),
    GENERAL_LASTUP("gl"),
    NOVELTYPE("nt"),
    END("e"),
    GENERAL_ALL_NO("ga"),
    LENGTH("l"),
    TIME("ti"),
    STOP("i"),
    PC_OR_K("p"),
    GLOBAL_POINT("gp"),
    FAV_NOVEL_COUNT("f"),
    REVIEW_COUT("r"),
    ALL_POINT("a"),
    ALL_HYOKA_COUNT("ah"),
    SASIE_COUNT("sa"),
    KAIWARITU("ka"),
    NOVEL_UPDATE_AT("nu"),
    UPDATED_AT("ua");

    private String id;

    private OfParam(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}
