package narou4j.enums;

/**
 * 小説の出力順序の指定 </br> </br>
 *
 * BOOKMARK_COUNT ブックマーク数の多い順 </br>
 * REVIEW_COUNT レビュー数の多い順 </br>
 * TOTAL_POINT 総合評価の高い順 </br>
 * TOTAL_POINT_ASC 総合評価の低い順 </br>
 * IMPRESSION_COUNT 感想の多い順 </br>
 * HYOKA_COUNT 評価者数の多い順 </br>
 * HYOKA_COUNT_ASC 評価者数の少ない順 </br>
 * WEEKLY_UU 週間ユニークユーザの多い順 </br>
 * CHARACTER_LENGTH_DESC 小説本文の文字数が多い順 </br>
 * CHARACTER_LENGTH_ASC 小説本文の文字数が少ない順 </br>
 * NCODE_DESC Nコードが新しい順 </br>
 * OLD 古い順 </br>
 */
public enum OutputOrder {
    BOOKMARK_COUNT("favnovelcnt"),
    REVIEW_COUNT("reviewcnt"),
    TOTAL_POINT("hyoka"),
    TOTAL_POINT_ASC("hyokaasc"),
    IMPRESSION_COUNT("impressioncnt"),
    HYOKA_COUNT("hyokacnt"),
    HYOKA_COUNT_ASC("hyokacntasc"),
    WEEKLY_UU("weekly"),
    CHARACTER_LENGTH_DESC("lengthdesc"),
    CHARACTER_LENGTH_ASC("lengthasc"),
    NCODE_DESC("ncodedesc"),
    OLD("old");

    private String id;

    private OutputOrder(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}
