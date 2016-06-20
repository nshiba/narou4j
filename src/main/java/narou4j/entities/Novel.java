package narou4j.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import narou4j.enums.NovelGenre;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Novel implements Serializable{
    private int allcount;
    private String title;
    private String ncode;
    @JsonProperty("userid")
    private String userId;
    private String writer;
    private String story;
    private NovelGenre genre;
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
    private int isr15;
    private int isbl;
    private int isgl;
    private int iszankoku;
    private int istensei;
    private int istenni;
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
    private int conversationRate;
    @JsonProperty("novelupdated_at")
    private String nobelUpdatedAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    private List<NovelBody> bodies;

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");

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

    public NovelGenre getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = NovelGenre.valueOf(genre);
    }

    public void setGenre(NovelGenre genre) {
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
        return this.firstUploadDate;
    }

    public void setFirstUploadDate(String firstUploadDate) {
        this.firstUploadDate = firstUploadDate;
    }

    public void setFirstUploadDate(Date firstUploadDate) {
        this.firstUploadDate = format.format(firstUploadDate);
    }

    public String getLastUploadDate() {
        return this.lastUploadDate;
    }

    public void setLastUploadDate(String lastUploadDate) {
        this.lastUploadDate = lastUploadDate;
    }

    public void setLastUploadDate(Date lastUploadDate) {
        this.lastUploadDate = format.format(lastUploadDate);
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

    public int getIsr15() {
        return isr15;
    }

    public void setIsr15(int isr15) {
        this.isr15 = isr15;
    }

    public int getIsbl() {
        return isbl;
    }

    public void setIsbl(int isbl) {
        this.isbl = isbl;
    }

    public int getIsgl() {
        return isgl;
    }

    public void setIsgl(int isgl) {
        this.isgl = isgl;
    }

    public int getIszankoku() {
        return iszankoku;
    }

    public void setIszankoku(int iszankoku) {
        this.iszankoku = iszankoku;
    }

    public int getIstensei() {
        return istensei;
    }

    public void setIstensei(int istensei) {
        this.istensei = istensei;
    }

    public int getIstenni() {
        return istenni;
    }

    public void setIstenni(int istenni) {
        this.istenni = istenni;
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

    public int getConversationRate() {
        return conversationRate;
    }

    public void setConversationRate(int conversationRate) {
        this.conversationRate = conversationRate;
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

    public List<NovelBody> getBodies() {
        return bodies;
    }

    public void setBodies(List<NovelBody> bodies) {
        this.bodies = bodies;
    }

    @Override
    public String toString() {
        return "Novel{" +
                "allcount=" + allcount +
                ", title='" + title + '\'' +
                ", ncode='" + ncode + '\'' +
                ", userId='" + userId + '\'' +
                ", writer='" + writer + '\'' +
                ", story='" + story + '\'' +
                ", genre=" + genre +
                ", gensaku=" + gensaku +
                ", keyword='" + keyword + '\'' +
                ", firstUploadDate='" + firstUploadDate + '\'' +
                ", lastUploadDate='" + lastUploadDate + '\'' +
                ", novelType=" + novelType + '\'' +
                ", isNovelContinue=" + isNovelContinue + '\'' +
                ", allNumberOfNovel=" + allNumberOfNovel + '\'' +
                ", numberOfChar=" + numberOfChar + '\'' +
                ", time=" + time + '\'' +
                ", isr15=" + isr15 + '\'' +
                ", isbl=" + isbl + '\'' +
                ", isgl=" + isgl + '\'' +
                ", iszankoku=" + iszankoku + '\'' +
                ", istensei=" + istensei + '\'' +
                ", istenni=" + istenni + '\'' +
                ", uploadType=" + uploadType + '\'' +
                ", globalPoint=" + globalPoint + '\'' +
                ", favCount=" + favCount + '\'' +
                ", reviewCount=" + reviewCount + '\'' +
                ", allPoint=" + allPoint + '\'' +
                ", allHyokaCount=" + allHyokaCount + '\'' +
                ", sasieCount=" + sasieCount + '\'' +
                ", conversationRate=" + conversationRate + '\'' +
                ", nobelUpdatedAt='" + nobelUpdatedAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", bodies=" + bodies + '\'' +
                '}';
    }
}
