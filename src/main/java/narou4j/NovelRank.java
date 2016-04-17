package narou4j;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class NovelRank implements Serializable {
    @JsonProperty("userid")
    private String rankingType;
    private String ncode;
    private int pt;
    private int rank;

    public String getRankingType() {
        return rankingType;
    }

    public void setRankingType(String rankingType) {
        this.rankingType = rankingType;
    }

    public String getNcode() {
        return ncode;
    }

    public void setNcode(String ncode) {
        this.ncode = ncode;
    }

    public int getPt() {
        return pt;
    }

    public void setPt(int pt) {
        this.pt = pt;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "NovelRank{" +
                "rankingType='" + rankingType + '\'' +
                ", ncode='" + ncode + '\'' +
                ", pt=" + pt +
                ", rank=" + rank +
                '}';
    }
}
