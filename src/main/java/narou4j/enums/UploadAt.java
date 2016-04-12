package narou4j.enums;

/**
 * 最終掲載日時に指定できる掲載日一覧です．<br>
 * その他にUNIXTIMESTAMPでも指定できます．<br><br>
 *
 * THIS_WEEK 今週(日曜日の午前0時はじまり)<br>
 * LAST_WEEK 先週<br>
 * SEVEN_DAY 過去7日間(7日前の午前0時はじまり)<br>
 * THIS_MONTH 今月<br>
 * LAST_MONTH 先月<br>
 */
public enum UploadAt {
    THIS_WEEK("thisweek"),
    LAST_WEEK("lastweek"),
    SEVEN_DAY("sevenday"),
    THIS_MONTH("thismonth"),
    LAST_MONTH("lastmonth");

    private String id;

    private UploadAt(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}
