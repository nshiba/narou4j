package narou4j;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Novel implements Serializable{
    private int allcount;
    private String title;
    private String ncode;
    @JsonProperty("userid")
    private String userId;
    private String writer;
    private String story;
    private int genre;
    private int gensaku;
    private String keyword;
    @JsonProperty("general_firstup")
    private String firstUploadDate;
    @JsonProperty("general_lastup")
    private String lastUploadDate;
    @JsonProperty("novel_type")
    private int novelType;
    @JsonProperty("end")
    private int isNovelContinue;
    @JsonProperty("general_all_no")
    private int allNumberOfNovel;
    @JsonProperty("length")
    private int numberOfChar;
    private int time;
    @JsonProperty("pc_or_k")
    private int uploadType;
    @JsonProperty("global_point")
    private int globalPoint;
    @JsonProperty("fav_novel_cnt")
    private int favCount;
    @JsonProperty("review_cnt")
    private int reviewCount;
    @JsonProperty("all_point")
    private int allPoint;
    @JsonProperty("all_hyoka_cnt")
    private int allHyokaCount;
    @JsonProperty("sasie_cnt")
    private int sasieCount;
    private int kaiwaritu;
    @JsonProperty("novelupdated_at")
    private String nobelUpdatedAt;
    @JsonProperty("updated_at")
    private String updatedAt;

    public int getAllcount() {
        return allcount;
    }

    public void setAllcount(int allcount) {
        this.allcount = allcount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNcode() {
        return ncode;
    }

    public void setNcode(String ncode) {
        this.ncode = ncode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public int getGensaku() {
        return gensaku;
    }

    public void setGensaku(int gensaku) {
        this.gensaku = gensaku;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getFirstUploadDate() {
        return firstUploadDate;
    }

    public void setFirstUploadDate(String firstUploadDate) {
        this.firstUploadDate = firstUploadDate;
    }

    public String getLastUploadDate() {
        return lastUploadDate;
    }

    public void setLastUploadDate(String lastUploadDate) {
        this.lastUploadDate = lastUploadDate;
    }

    public int getNovelType() {
        return novelType;
    }

    public void setNovelType(int novelType) {
        this.novelType = novelType;
    }

    public int getIsNovelContinue() {
        return isNovelContinue;
    }

    public void setIsNovelContinue(int isNovelContinue) {
        this.isNovelContinue = isNovelContinue;
    }

    public int getAllNumberOfNovel() {
        return allNumberOfNovel;
    }

    public void setAllNumberOfNovel(int allNumberOfNovel) {
        this.allNumberOfNovel = allNumberOfNovel;
    }

    public int getNumberOfChar() {
        return numberOfChar;
    }

    public void setNumberOfChar(int numberOfChar) {
        this.numberOfChar = numberOfChar;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getUploadType() {
        return uploadType;
    }

    public void setUploadType(int uploadType) {
        this.uploadType = uploadType;
    }

    public int getGlobalPoint() {
        return globalPoint;
    }

    public void setGlobalPoint(int globalPoint) {
        this.globalPoint = globalPoint;
    }

    public int getFavCount() {
        return favCount;
    }

    public void setFavCount(int favCount) {
        this.favCount = favCount;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public int getAllPoint() {
        return allPoint;
    }

    public void setAllPoint(int allPoint) {
        this.allPoint = allPoint;
    }

    public int getAllHyokaCount() {
        return allHyokaCount;
    }

    public void setAllHyokaCount(int allHyokaCount) {
        this.allHyokaCount = allHyokaCount;
    }

    public int getSasieCount() {
        return sasieCount;
    }

    public void setSasieCount(int sasieCount) {
        this.sasieCount = sasieCount;
    }

    public int getKaiwaritu() {
        return kaiwaritu;
    }

    public void setKaiwaritu(int kaiwaritu) {
        this.kaiwaritu = kaiwaritu;
    }

    public String getNobelUpdatedAt() {
        return nobelUpdatedAt;
    }

    public void setNobelUpdatedAt(String nobelUpdatedAt) {
        this.nobelUpdatedAt = nobelUpdatedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Novel{" + "\n" +
                "allcount=" + allcount + "\n" +
                ", title='" + title + '\'' + "\n" +
                ", ncode='" + ncode + '\'' + "\n" +
                ", userId='" + userId + '\'' + "\n" +
                ", writer='" + writer + '\'' + "\n" +
                ", story='" + story + '\'' + "\n" +
                ", genre=" + genre + "\n" +
                ", gensaku=" + gensaku + "\n" +
                ", keyword='" + keyword + '\'' + "\n" +
                ", firstUploadDate='" + firstUploadDate + '\'' + "\n" +
                ", lastUploadDate='" + lastUploadDate + '\'' + "\n" +
                ", novelType=" + novelType + "\n" +
                ", isNovelContinue=" + isNovelContinue + "\n" +
                ", allNumberOfNovel=" + allNumberOfNovel + "\n" +
                ", numberOfChar=" + numberOfChar + "\n" +
                ", time=" + time + "\n" +
                ", uploadType=" + uploadType + "\n" +
                ", globalPoint=" + globalPoint + "\n" +
                ", favCount=" + favCount + "\n" +
                ", reviewCount=" + reviewCount + "\n" +
                ", allPoint=" + allPoint + "\n" +
                ", allHyokaCount=" + allHyokaCount + "\n" +
                ", sasieCount=" + sasieCount + "\n" +
                ", kaiwaritu=" + kaiwaritu + "\n" +
                ", nobelUpdatedAt='" + nobelUpdatedAt + '\'' + "\n" +
                ", updatedAt='" + updatedAt + '\'' + "\n" +
                '}';
    }
}
