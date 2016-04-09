package narou4j;

import narou4j.enums.*;
import narou4j.exception.NarouDuplicateException;
import narou4j.exception.NarouOutOfRangeException;

import java.io.IOException;
import java.util.*;

public class GetParameter {
    Map<String, String> params = new HashMap<>();
    private Set<OfParam> ofParamSet = new HashSet<>();
    private Set<Genre> genreSet = new TreeSet<>();
    private Set<Genre> notGenreSet = new TreeSet<>();
    private Set<Integer> userIdSet = new TreeSet<>();

    public void setGzip(int rate) {
        if (rate < 1 || rate > 5) {
            throw new NarouOutOfRangeException("out of gzip Compression level (1 ~ 5)");
        }

        params.put("gzip", String.valueOf(rate));
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

    public void setGenre(Genre genre) {
        genreSet.add(genre);
    }

    String getGenre() {
        return genre2String(genreSet);
    }

    public void setNotGenre(Genre genre) {
        notGenreSet.add(genre);
    }

    String getNotGenre() {
        return genre2String(notGenreSet);
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
        if (params.containsKey("length")) {
            System.out.println("remove length");
            params.remove("length");
        }
        params.put("length", String.valueOf(length));
    }

    public void setCharacterLength(int min, int max) {
        if (params.containsKey("time")) {
            throw new NarouDuplicateException("character length is not used in conjunction with the reading time. ");
        }
        if (params.containsKey("length")) {
            System.out.println("remove length");
            params.remove("length");
        }

        System.out.println(time2String(min, max));
        params.put("length", time2String(min, max));
    }

    public void setReadTime(int length) {
        if (params.containsKey("length")) {
            throw new NarouDuplicateException("reading time is not used in conjunction with the character length. ");
        }
        if (params.containsKey("time")) {
            System.out.println("remove time");
            params.remove("time");
        }
        params.put("time", String.valueOf(length));
    }

    public void setReadTime(int min, int max) {
        if (params.containsKey("length")) {
            throw new NarouDuplicateException("reading time is not used in conjunction with the character length. ");
        }
        if (params.containsKey("time")) {
            System.out.println("remove time");
            params.remove("time");
        }

        System.out.println(time2String(min, max));
        params.put("time", time2String(min, max));
    }



    private String genre2String(Set<Genre> set) {
        StringBuilder builder = new StringBuilder();

        int i = 1;
        for (Genre genre : set) {
            builder.append(genre.getId());
            if (i != set.size()) {
                builder.append("-");
            }

            i++;
        }
        System.out.println(builder.toString());
        return builder.toString();
    }

    private String time2String(int min, int max) {
        StringBuilder builder = new StringBuilder();
        if (min <= 0) {
            builder.append("-")
                    .append(String.valueOf(max));
        }
        else if (max <= 0) {
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
