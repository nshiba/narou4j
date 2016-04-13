package narou4j.enums;

/**
 * 警告タグ一覧 <br>
 * 指定するとキーワードに警告タグが含まれている小説のみを対象とします． <br> <br>
 *
 * R15 R15 <br>
 * BL ボーイズラブ <br>
 * GL ガールズラブ <br>
 * ZANKOKU 残酷な描写あり <br>
 */
public enum WarnigTag {
    R15("isr15"),
    BL("isbl"),
    GL("isgl"),
    ZANKOKU("iszankoku");

    private String id;

    private WarnigTag(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}
