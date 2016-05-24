package narou4j.enums;

/**
 * 小説の大ジャンル <br> <br>
 *
 * 1: 恋愛 LOVE <br>
 * 2: ファンタジー FANTASY <br>
 * 3: 文学 LITERATURE <br>
 * 4: SF SF <br>
 * 99: その他 OTHER <br>
 * 98: ノンジャンル NONGENRE <br>
 */
public enum NovelBigGenre {
    LOVE(1),
    FANTASY(2),
    LITERATURE(3),
    SF(4),
    OTHER(99),
    NONGENRE(98);

    private int id;

    private NovelBigGenre(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static NovelBigGenre valueOf(int id) {
        for (NovelBigGenre genre : values()) {
            if (genre.getId() == id) {
                return genre;
            }
        }

        throw new IllegalArgumentException("no such enum object for the id: " + id);
    }
}
