package narou4j.enums;

public enum NovelGenre {
    LITERATURE(1),
    LOVE(2),
    HISTORY(3),
    DETECTIVE(4),
    FANTASY(5),
    SF(6),
    HORROR(7),
    COMEDY(8),
    ADVENTURE(9),
    ACADEMY(10),
    MILITARY_HISTORY(11),
    FAIRYTALE(12),
    POEM(13),
    ESSAY(14),
    REPLAY(16),
    OTHER(15);

    private int id;

    private NovelGenre(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
