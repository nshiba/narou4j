package narou4j.enums;

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
