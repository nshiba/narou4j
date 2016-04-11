package narou4j.enums;

public enum NovelType {
    SHORT("t"),
    SERIES_IN("r"),
    SERIES_END("er"),
    ALL_SERIES("re"),
    ALL_NOVEL("ter");

    private String id;

    private NovelType(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}
