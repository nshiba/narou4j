package narou4j.enums;

import java.util.HashMap;
import java.util.StringTokenizer;

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
    LOVE(1, "恋愛"),
    FANTASY(2, "ファンタジー"),
    LITERATURE(3, "文学"),
    SF(4, "SF"),
    OTHER(99, "その他"),
    NONGENRE(98, "ノンジャンル");

    private int id;
    private String text;
    private HashMap<Integer, String> values = new HashMap<>();

    private NovelBigGenre(int id, String text) {
        this.id = id;
        this.text = text;
        values.put(id, text);
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public HashMap<Integer, String> getValues() {
        return values;
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
