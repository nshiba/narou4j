package narou4j;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import narou4j.enums.RankingType;

@JsonIgnoreProperties(ignoreUnknown=true)
public class NovelRank implements Serializable {
    private RankingType rankingType;
    private String ncode;
    private Date date;
    private String rtype;
    private int pt;
    private int rank;

    private SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

    public RankingType getRankingType() {
        return rankingType;
    }

    public void setRankingType(RankingType rankingType) {
        this.rankingType = rankingType;
    }

    public String getNcode() {
        return ncode;
    }

    public void setNcode(String ncode) {
        this.ncode = ncode;
    }

    public Date getDate() {
        return date;
    }

    public String getDateString() {
        return format.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDate(String date) {
        try {
            this.date = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getRtype() {
        return rtype;
    }

    public void setRtype(String rtype) {
        this.rtype = rtype;
        String[] rtypeSplit = rtype.split("-");

        switch (rtypeSplit[1]) {
            case "d": {
                rankingType = RankingType.DAILY;
                break;
            }
            case "w": {
                rankingType = RankingType.WEEKLY;
                break;
            }
            case "m": {
                rankingType = RankingType.MONTHLY;
                break;
            }
            case "q": {
                rankingType = RankingType.QUARTET;
                break;
            }
        }

        try {
            date = format.parse(rtypeSplit[0]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
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
                "rankingType=" + rankingType +
                ", ncode='" + ncode + '\'' +
                ", date=" + date +
                ", rtype='" + rtype + '\'' +
                ", pt=" + pt +
                ", rank=" + rank +
                '}';
    }
}
