package narou4j.enums;

/**
 * 単語を検索する対象をします． <br>
 * 未指定の場合は全てを対象とします． <br> <br>
 *
 * TITLE タイトル <br>
 * SYNOPSIS あらすじ <br>
 * KEYWORD キーワード <br>
 * WRITER 作者名 <br>
 */
public enum SearchWordTarget {
    TITLE(0),
    SYNOPSIS(1),
    KEYWORD(2),
    WRITER(3);

    private final int id;

    private SearchWordTarget(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static SearchWordTarget getSearchWordTarget(String id) {
        for (SearchWordTarget target : values()) {
            if (id.equals(target.getId())) {
                return target;
            }
        }

        throw new IllegalArgumentException("no such enum object for the id: " + id);
    }
}
