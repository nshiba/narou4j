package narou4j;

public class NovelBody {
    private String ncode;
    private String title;
    private int page;
    private String body;
    private boolean isChapter = false;

    public String getNcode() {
        return ncode;
    }

    public void setNcode(String ncode) {
        this.ncode = ncode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isChapter() {
        return isChapter;
    }

    public void setChapter(boolean chapter) {
        isChapter = chapter;
    }

    @Override
    public String toString() {
        return "NovelBody{" +
                "ncode='" + ncode + '\'' +
                ", title='" + title + '\'' +
                ", page=" + page +
                ", body='" + body + '\'' +
                ", isChapter=" + isChapter +
                '}';
    }
}
