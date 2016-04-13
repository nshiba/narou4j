package narou4j.enums;

/**
 * 小説タイプ <br>
 *  <br>
 * SHORT 短編 <br>
 * SERIES_IN 連載中 <br>
 * SERIES_END 完結済連載小説 <br>
 * ALL_SERIES すべての連載小説(連載中および完結済) <br>
 * ALL_NOVEL 短編と完結済連載小説 <br>
 */
public enum NovelType {
    SHORT("t"),
    SERIES_IN("r"),
    SERIES_END("er"),
    ALL_SERIES("re"),
    ALL_NOVEL("ter");

    private String id;

    private NovelType(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}
