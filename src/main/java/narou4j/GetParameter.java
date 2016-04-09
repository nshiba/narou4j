package narou4j;

import narou4j.enums.Genre;
import narou4j.enums.OfParam;
import narou4j.enums.OutputOrder;
import narou4j.enums.SearchWordTarget;

import java.util.*;

public class GetParameter {
    protected Map<String, String> params = new HashMap<>();
    private Set<OfParam> ofParamSet = new HashSet<>();
    private Set<Genre> genreSet = new TreeSet<>();
    private Set<Genre> notGenreSet = new TreeSet<>();

    public void setGzip(int rate) {
        if (rate < 1 || rate > 5) {
            throw new IndexOutOfBoundsException("out of gzip Compression level (1 ~ 5)");
        }

        params.put("gzip", String.valueOf(rate));
    }

    public void setOfParams(OfParam param) {
        ofParamSet.add(param);
    }

    public String getOfParam() {
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
            throw new IndexOutOfBoundsException("out of output limit (1 ~ 500)");
        }

        params.put("lim", String.valueOf(lim));
    }

    public void setSt(int st) {
        if (st < 1 || st > 5) {
            throw new IndexOutOfBoundsException("out of st number (1 ~ 2000)");
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

    public String getGenre() {
        StringBuilder builder = new StringBuilder();

        int i = 1;
        for (Genre genre : genreSet) {
            builder.append(genre.getId());
            if (i != genreSet.size()) {
                builder.append("-");
            }

            i++;
        }
        System.out.println(builder.toString());
        return builder.toString();
    }

    public void setNotGenre(Genre genre) {
        notGenreSet.add(genre);
    }

    public String getNotGenre() {
        StringBuilder builder = new StringBuilder();

        int i = 1;
        for (Genre genre : notGenreSet) {
            builder.append(genre.getId());
            if (i != notGenreSet.size()) {
                builder.append("-");
            }

            i++;
        }
        System.out.println(builder.toString());
        return builder.toString();
    }
}
