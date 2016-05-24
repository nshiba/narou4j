package narou4j.enums;

/**
 * 小説のジャンル <br> <br>
 *
 * 101: 異世界[恋愛] LOVE_DIFF_WORLD <br>
 * 102: 現実世界[恋愛] LOVE_REAL_WORLD <br>
 * 201: ハイファンタジー[ファンタジー] FANTASY_HIGH <br>
 * 202: ハイファンタジー[ファンタジー] FANTASY_LOW <br>
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
    LOVE_DIFF_WORLD(101),
    LOVE_REAL_WORLD(102),
    FANTASY_HIGH(201),
    FANTASY_LOW(202),
    LITERAL_PURE(301),
    LITERAL_DRAMA(302),
    LITERAL_HISTORY(303),
    LITERAL_DETECTIVE(304),
    LITERAL_HORROR(305),
    LITERAL_ACTION(306),
    LITERAL_COMEDY(307),
    SF_VR(401),
    SF_SPACE(402),
    SF_SCIENCE(403),
    SF_PANIC(404),
    OTHER_FAIRYTALE(9901),
    OTHER_POEM(9902),
    OTHER_ESSAY(9903),
    OTHER_REPLAY(9904),
    OTHER(9999),
    NONGENRE(9801);

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
