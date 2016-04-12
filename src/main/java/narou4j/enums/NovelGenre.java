package narou4j.enums;

import narou4j.Novel;

/**
 * 小説のジャンル </br> </br>
 *
 * 1: 文学 LITERATURE </br>
 * 2: 恋愛 LOVE </br>
 * 3: 歴史 HISTORY </br>
 * 4: 推理 DETECTIVE </br>
 * 5: ファンタジー FANTASY </br>
 * 6: SF SF </br>
 * 7: ホラー HORROR </br>
 * 8: コメディー COMEDY </br>
 * 9: 冒険 ADVENTURE </br>
 * 10: 学園 ACADEMY </br>
 * 11: 戦記 MILITARY_HISTORY
 * 12: 童話 FAIRYTALE </br>
 * 13: 詩 POEM </br>
 * 14: エッセイ ESSAY </br>
 * 16: リプレイ REPLAY </br>
 * 15: その他 OTHER </br>
 */
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

    public static NovelGenre valueOf(int id) {
        for (NovelGenre genre : values()) {
            if (genre.getId() == id) {
                return genre;
            }
        }

        throw new IllegalArgumentException("no such enum object for the id: " + id);
    }
}
