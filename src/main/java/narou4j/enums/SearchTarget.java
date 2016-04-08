package narou4j.enums;

public enum  SearchTarget {
    TITLE(0),
    SYNOPSIS(1),
    KEYWORD(2),
    WRITER(3);

    private final int id;

    private SearchTarget(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
