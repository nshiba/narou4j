package narou4j.enums;

/**
 * 出力項目の指定に関するパラメータ一覧． <br>
 * 指定したパラメータが結果として返ってくる． <br>
 * 指定しない場合はすべて出力 <br> <br>
 *
 * TITLE 小説名 <br>
 * NCODE 小説固有コード <br>
 * USERID 作者のユーザID <br>
 * WRITER 作者名 <br>
 * STORY 小説のあらすじ <br>
 * GENRE 小説のジャンル {@link NovelGenre} <br>
 * KEYWORD キーワード <br>
 * GENERAL_FIRSTUP 初回掲載日 <br>
 * GENERAL_LASTUP 最終掲載日 <br>
 * NOVELTYPE 連載の場合は1、短編の場合は2 <br>
 * END 短編，完結小説0，連載中は1 <br>
 * GENERAL_ALL_NO 全掲載話数，短編の場合は1 <br>
 * LENGTH 小説文字数．スペースと改行はカウント数から除く <br>
 * TIME 小説読了時間 <br>
 * STOP 長期連載中は1，それ以外は0． <br>
 * PC_OR_K 投稿した端末．1はケータイのみ、2はPCのみ、3はPCとケータイ <br>
 * GLOBAL_POINT 総合得点 <br>
 * FAV_NOVEL_COUNT ブックマーク数 <br>
 * REVIEW_COUNT レビュー数 <br>
 * ALL_POINT 評価点 <br>
 * ALL_HYOKA_COUNT 評価者数 <br>
 * SASIE_COUNT 挿絵数 <br>
 * KAIWARITU 会話率 <br>
 * NOVEL_UPDATE_AT 小説の更新日時 <br>
 * UPDATED_AT 最終更新日時 (API側のシステム用でこちらは関係無いらしい) <br>
 */
public enum OfParam {
    TITLE("t"),
    NCODE("n"),
    USERID("u"),
    WRITER("w"),
    STORY("s"),
    GENRE("g"),
    KEYWORD("k"),
    GENERAL_FIRSTUP("gf"),
    GENERAL_LASTUP("gl"),
    NOVELTYPE("nt"),
    END("e"),
    GENERAL_ALL_NO("ga"),
    LENGTH("l"),
    TIME("ti"),
    STOP("i"),
    PC_OR_K("p"),
    GLOBAL_POINT("gp"),
    FAV_NOVEL_COUNT("f"),
    REVIEW_COUNT("r"),
    ALL_POINT("a"),
    ALL_HYOKA_COUNT("ah"),
    SASIE_COUNT("sa"),
    KAIWARITU("ka"),
    NOVEL_UPDATE_AT("nu"),
    UPDATED_AT("ua");

    private String id;

    private OfParam(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}
