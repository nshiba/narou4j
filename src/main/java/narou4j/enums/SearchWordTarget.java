package narou4j.enums;

public enum SearchWordTarget {
    TITLE(0),
    SYNOPSIS(1),
    KEYWORD(2),
    WRITER(3);

    private final int id;

    private SearchWordTarget(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
