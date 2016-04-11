package narou4j;

import narou4j.enums.*;
import narou4j.exception.NarouDuplicateException;
import narou4j.exception.NarouOutOfRangeException;

import java.util.*;

public class GetParameter {
    Map<String, String> params = new HashMap<>();
    boolean isGzip = true;

    private Set<OfParam> ofParamSet = new HashSet<>();
    private Set<NovelGenre> novelGenreSet = new TreeSet<>();
    private Set<NovelGenre> notNovelGenreSet = new TreeSet<>();
    private Set<Integer> userIdSet = new TreeSet<>();
    private Set<String> ncodeSet = new TreeSet<>();

    public void setGzip(int rate) {
        if (rate < 1 || rate > 5) {
            throw new NarouOutOfRangeException("out of gzip Compression level (1 ~ 5)");
        }

        params.put("gzip", String.valueOf(rate));
        isGzip = true;
    }

    public void removeGzip() {
        params.remove("gzip");
        isGzip = false;
    }

    public void setOfParams(OfParam param) {
        ofParamSet.add(param);
    }

    String getOfParam() {
        StringBuilder builder = new StringBuilder();

        int i = 1;
        for (OfParam param : ofParamSet) {
            builder.append(param.getId());
            if (i != ofParamSet.size()) {
                builder.append("-");
            }

            i++;
        }
        System.out.println(builder.toString());
        return builder.toString();
    }

    public void setLim(int lim) {
        if (lim < 1 || lim > 5) {
            throw new NarouOutOfRangeException("out of output limit (1 ~ 500)");
        }

        params.put("lim", String.valueOf(lim));
    }

    public void setSt(int st) {
        if (st < 1 || st > 5) {
            throw new NarouOutOfRangeException("out of st number (1 ~ 2000)");
        }

        params.put("st", String.valueOf(st));
    }

    public void setOrder(OutputOrder order) {
        params.put("order", order.getId());
    }

    public void setSearchWord(String word) {
        params.put("word", word);
    }

    public void setNotWord(String word) {
        params.put("notword", word);
    }

    public void setSearchTarget(SearchWordTarget target) {
        switch (target) {
            case TITLE: {
                params.put("title", String.valueOf(1));
                break;
            }
            case SYNOPSIS: {
                params.put("ex", String.valueOf(1));
                break;
            }
            case KEYWORD: {
                params.put("keyword", String.valueOf(1));
                break;
            }
            case WRITER: {
                params.put("wname", String.valueOf(1));
                break;
            }
        }
    }

    public void setGenre(NovelGenre novelGenre) {
        novelGenreSet.add(novelGenre);
    }

    String getGenre() {
        return genre2String(novelGenreSet);
    }

    public void setNotGenre(NovelGenre novelGenre) {
        notNovelGenreSet.add(novelGenre);
    }

    String getNotGenre() {
        return genre2String(notNovelGenreSet);
    }

    public void setUserId(int id) {
        userIdSet.add(id);
    }

    String getUserIds() {
        StringBuilder builder = new StringBuilder();

        int i = 1;
        for (int userId : userIdSet) {
            builder.append(userId);
            if (i != userIdSet.size()) {
                builder.append("-");
            }

            i++;
        }
        System.out.println(builder.toString());
        return builder.toString();
    }

    public void setWarnigTag(WarnigTag tag) {
        params.put(tag.getId(), String.valueOf(1));
    }

    public void setCharacterLength(int length) {
        if (params.containsKey("time")) {
            throw new NarouDuplicateException("character length is not used in conjunction with the reading time. ");
        }
        params.put("length", String.valueOf(length));
    }

    public void setCharacterLength(int min, int max) {
        if (params.containsKey("time")) {
            throw new NarouDuplicateException("character length is not used in conjunction with the reading time. ");
        }

        System.out.println(range2String(String.valueOf(min), String.valueOf(max)));
        params.put("length", range2String(String.valueOf(min), String.valueOf(max)));
    }

    public void setReadTime(int length) {
        if (params.containsKey("length")) {
            throw new NarouDuplicateException("reading time is not used in conjunction with the character length. ");
        }
        params.put("time", String.valueOf(length));
    }

    public void setReadTime(int min, int max) {
        if (params.containsKey("length")) {
            throw new NarouDuplicateException("reading time is not used in conjunction with the character length. ");
        }

        System.out.println(range2String(String.valueOf(min), String.valueOf(max)));
        params.put("time", range2String(String.valueOf(min), String.valueOf(max)));
    }

    public void setConversationRate(int rate) {
        params.put("kaiwaritu", String.valueOf(rate));
    }

    public void setConversationRate(int min, int max) {
        System.out.println(range2String(String.valueOf(min), String.valueOf(max)));
        params.put("kaiwaritu", range2String(String.valueOf(min), String.valueOf(max)));
    }

    public void setArtworks(int num) {
        params.put("sasie", String.valueOf(num));
    }

    public void setArtworks(int min, int max) {
        System.out.println(range2String(String.valueOf(min), String.valueOf(max)));
        params.put("sasie", range2String(String.valueOf(min), String.valueOf(max)));
    }

    public void setNCode(String ncode) {
        ncodeSet.add(ncode);
    }

    String getNcodes() {
        StringBuilder builder = new StringBuilder();

        int i = 1;
        for (String ncode : ncodeSet) {
            builder.append(ncode);
            if (i != ncodeSet.size()) {
                builder.append("-");
            }

            i++;
        }
        System.out.println(builder.toString());
        return builder.toString();
    }

    public void setNovelType(NovelType type) {
        params.put("type", type.getId());
    }

    public void setExcludeStop(boolean isExclude) {
        if (isExclude) {
            params.put("stop", "1");
        }
        else {
            params.put("stop", "2");
        }
    }

    public void setPickup(boolean isPickup) {
        if (isPickup) {
            params.put("ispickup", "1");
        }
        else {
            params.put("ispickup", "2");
        }
    }

    public void setLastUploadAt(UploadAt at) {
        params.put("lastup", at.getId());
    }

    public void setLastUploadAt(Date min, Date max) {
        long minUnixtime = min.getTime() / 1000L;
        long maxUnixtime = max.getTime() / 1000L;
    }



    private String genre2String(Set<NovelGenre> set) {
        StringBuilder builder = new StringBuilder();

        int i = 1;
        for (NovelGenre novelGenre : set) {
            builder.append(novelGenre.getId());
            if (i != set.size()) {
                builder.append("-");
            }

            i++;
        }
        System.out.println(builder.toString());
        return builder.toString();
    }

    private String range2String(String min, String max) {
        StringBuilder builder = new StringBuilder();
        if (min.equals("0")) {
            builder.append("-")
                    .append(String.valueOf(max));
        }
        else if (max.equals("0")) {
            builder.append(String.valueOf(min))
                    .append("-");
        }
        else {
            builder.append(String.valueOf(min))
                    .append("-")
                    .append(String.valueOf(max));
        }

        return builder.toString();
    }
}
