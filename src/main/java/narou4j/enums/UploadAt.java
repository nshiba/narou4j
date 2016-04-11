package narou4j.enums;

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
