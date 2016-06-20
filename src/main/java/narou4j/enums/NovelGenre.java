package narou4j.enums;

import java.util.HashMap;

/**
 * 小説のジャンル <br> <br>
 *
 * 101: 異世界[恋愛] LOVE_DIFF_WORLD <br>
 * 102: 現実世界[恋愛] LOVE_REAL_WORLD <br>
 * 201: ハイファンタジー[ファンタジー] FANTASY_HIGH <br>
 * 202: ローファンタジー[ファンタジー] FANTASY_LOW <br>
 * 301: 純文学[文学] LITERAL_PURE <br>
 * 302: ヒューマンドラマ[文学] LITERAL_DRAMA <br>
 * 303: 歴史[文学] LITERAL_HISTORY <br>
 * 304: 推理[文学] LITERAL_DETECTIVE <br>
 * 305: ホラー[文学] LITERAL_HORROR <br>
 * 306: アクション[文学] LITERAL_ACTION <br>
 * 307: コメディ[文学] LITERAL_COMEDY <br>
 * 401: VRゲーム [SF] SF_VR <br>
 * 402: 宇宙 [SF] SF_SPACE <br>
 * 403: 空想科学 [SF] SF_SCIENCE <br>
 * 404: パニック [SF] SF_PANIC <br>
 * 9901: 童話 [その他] OTHER_FAIRYTALE <br>
 * 9902: 詩 [その他] OTHER_POEM <br>
 * 9903: エッセイ [その他] OTHER_ESSAY <br>
 * 9904: リプレイ [その他] OTHER_REPLAY <br>
 * 9999: その他 [その他] OTHER <br>
 * 9801: ノンジャンル [ノンジャンル] NONGENRE <br>
 */
public enum NovelGenre {
    LOVE_DIFF_WORLD(101, "異世界[恋愛]"),
    LOVE_REAL_WORLD(102, "現実世界[恋愛]"),
    FANTASY_HIGH(201, "ハイファンタジー[ファンタジー]"),
    FANTASY_LOW(202, "ローファンタジー[ファンタジー]"),
    LITERAL_PURE(301, "純文学[文学]"),
    LITERAL_DRAMA(302, "ヒューマンドラマ[文学]"),
    LITERAL_HISTORY(303, "歴史[文学]"),
    LITERAL_DETECTIVE(304, "推理[文学]"),
    LITERAL_HORROR(305, "ホラー[文学]"),
    LITERAL_ACTION(306, "アクション[文学]"),
    LITERAL_COMEDY(307, "コメディ[文学]"),
    SF_VR(401, "VRゲーム[SF]"),
    SF_SPACE(402, "宇宙[SF]"),
    SF_SCIENCE(403, "空想科学[SF]"),
    SF_PANIC(404, "パニック[SF]"),
    OTHER_FAIRYTALE(9901, "童話[その他]"),
    OTHER_POEM(9902, "詩[その他]"),
    OTHER_ESSAY(9903, "エッセイ[その他]"),
    OTHER_REPLAY(9904, "リプレイ[その他]"),
    OTHER(9999, "その他[その他]"),
    NONGENRE(9801, "ノンジャンル[ノンジャンル]");

    private int id;
    private String text;
    private HashMap<Integer, String> values = new HashMap<>();

    private NovelGenre(int id, String text) {
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

    public static NovelGenre valueOf(int id) {
        for (NovelGenre genre : values()) {
            if (genre.getId() == id) {
                return genre;
            }
        }

        throw new IllegalArgumentException("no such enum object for the id: " + id);
    }
}
