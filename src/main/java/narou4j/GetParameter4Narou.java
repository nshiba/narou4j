package narou4j;

import narou4j.enums.*;
import narou4j.exception.NarouDuplicateException;
import narou4j.exception.NarouOutOfRangeException;

import java.util.*;

public class GetParameter4Narou {
    Map<String, String> params = new HashMap<>();
    boolean isGzip = true;

    private Set<OfParam> ofParamSet = new HashSet<>();
    private Set<NovelBigGenre> novelBigGenreSet = new TreeSet<>();
    private Set<NovelBigGenre> notNovelBigGenreSet = new TreeSet<>();
    private Set<NovelGenre> novelGenreSet = new TreeSet<>();
    private Set<NovelGenre> notNovelGenreSet = new TreeSet<>();
    private Set<Integer> userIdSet = new TreeSet<>();
    private Set<String> ncodeSet = new TreeSet<>();

    boolean isSetEmpty(Set set) {
        return set.size() <= 0;
    }

    void setAllParams() {
        if (!isSetEmpty(ofParamSet)) {
            params.put("of", getOfParam());
        }
        if (!isSetEmpty(novelBigGenreSet)) {
            params.put("biggenre", getBigGenre());
        }
        if (!isSetEmpty(notNovelBigGenreSet)) {
            params.put("notbiggenre", getNotBigGenre());
        }
        if (!isSetEmpty(novelGenreSet)) {
            params.put("genre", getGenre());
        }
        if (!isSetEmpty(notNovelGenreSet)) {
            params.put("notgenre", getNotGenre());
        }
        if (!isSetEmpty(userIdSet)) {
            params.put("userid", getUserIds());
        }
        if (!isSetEmpty(ncodeSet)) {
            params.put("ncode", getNcodes());
        }
    }

    /**
     * 出力結果をgzipに圧縮します．
     * デフォルトは 5
     * 転送量上限を減らすためにも推奨
     *
     * @param rate 圧縮レベルは1 ~ 5
     */
    public void setGzip(int rate) {
        if (rate < 1 || rate > 5) {
            throw new NarouOutOfRangeException("out of gzip Compression level (1 ~ 5)");
        }

        params.put("gzip", String.valueOf(rate));
        isGzip = true;
    }

    /**
     * 出力結果をgzipに圧縮して返すためのパラメータ
     * デフォルトは 5 になっているので解除するメソッド
     */
    public void notGzip() {
        params.remove("gzip");
        isGzip = false;
    }

    /**
     * 出力する項目を個別に指定します．
     * 複数指定できます．
     * 指定できる項目は {@link OfParam} を参照
     *
     * @param param OfParam {@link OfParam}
     */
    public void setOfParams(OfParam param) {
        ofParamSet.add(param);
    }

    /**
     * 出力する項目を複数同時に指定します．
     *
     * @param params OfParam[] {@link OfParam}
     */
    public void setOfParams(OfParam[] params) {
        for (OfParam param : params) {
            ofParamSet.add(param);
        }
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
        return builder.toString();
    }

    /**
     * 小説の最大出力数を指定できます．
     * 指定しない場合は20件です．
     *
     * @param lim int (1 ~ 500)
     */
    public void setLim(int lim) {
        if (lim < 1 || lim > 500) {
            throw new NarouOutOfRangeException("out of output limit (1 ~ 500)");
        }

        params.put("lim", String.valueOf(lim));
    }

    /**
     * 表示開始位置の指定です．<br>
     * たとえば全部で10作品あるとして，3作品目以降の小説情報を取得したい場合は3と指定してください．
     *
     * @param st int 1 ~ 2000
     */
    public void setSt(int st) {
        if (st < 1 || st > 2000) {
            throw new NarouOutOfRangeException("out of st number (1 ~ 2000)");
        }

        params.put("st", String.valueOf(st));
    }

    /**
     * 出力順序を指定します．<br>
     * 指定しない場合は新着順となります．
     *
     * @param order OutputOrder {@link OutputOrder}
     */
    public void setOrder(OutputOrder order) {
        params.put("order", order.getId());
    }

    /**
     * 検索単語を指定します．<br>
     * 半角または全角スペースで区切り，複数指定するとAND検索になります．<br>
     * 検索は部分一致です．
     *
     * @param word String
     */
    public void setSearchWord(String word) {
        params.put("word", word);
    }

    /**
     * 除外単語を指定します．<br>
     * 半角または全角スペースで区切り，複数指定すると単語を増やせます．<br>
     * 除外は部分一致です．
     *
     * @param word String
     */
    public void setNotWord(String word) {
        params.put("notword", word);
    }

    /**
     * {@link GetParameter4Narou#setSearchWord(String)} と {@link GetParameter4Narou#setNotWord(String)} で指定した単語の抽出対象{@link SearchWordTarget}を指定します．<br>
     * 指定しない場合は全項目が抽出対象となります．
     *
     * @param target SearchWordTarget {@link SearchWordTarget}
     */
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

    /**
     * 取得する小説の大ジャンル{@link NovelBigGenre}を指定します．<br>
     * 複数指定できます．
     *
     * @param novelBigGenre NovelGenre {@link NovelBigGenre}
     */
    public void setBigGenre(NovelBigGenre novelBigGenre) {
        novelBigGenreSet.add(novelBigGenre);
    }

    /**
     * 取得する小説の大ジャンル{@link NovelBigGenre}を複数同時に指定します．<br>
     *
     * @param genres NovelBigGenre[] {@link NovelBigGenre}
     */
    public void setBigGenre(NovelBigGenre[] genres) {
        for (NovelBigGenre genre : genres) {
            novelBigGenreSet.add(genre);
        }
    }

    String getBigGenre() {
        return bigGenre2String(novelBigGenreSet);
    }

    /**
     * 取得する小説から除く大ジャンル{@link NovelBigGenre}を指定します．<br>
     * 複数指定できます．
     *
     * @param genre NovelBigGenre {@link NovelBigGenre}
     */
    public void setNotBigGenre(NovelBigGenre genre) {
        notNovelBigGenreSet.add(genre);
    }

    /**
     * 取得する小説から除く大ジャンル{@link NovelBigGenre}を複数同時に指定します．<br>
     *
     * @param genres NovelBigGenre[] {@link NovelBigGenre}
     */
    public void setNotBigGenre(NovelBigGenre[] genres) {
        for (NovelBigGenre genre : genres) {
            notNovelBigGenreSet.add(genre);
        }
    }

    String getNotBigGenre() {
        return bigGenre2String(notNovelBigGenreSet);
    }

    /**
     * 取得する小説のジャンル{@link NovelGenre}を指定します．<br>
     * 複数指定できます．
     *
     * @param novelGenre NovelGenre {@link NovelGenre}
     */
    public void setGenre(NovelGenre novelGenre) {
        novelGenreSet.add(novelGenre);
    }

    /**
     * 取得する小説のジャンル{@link NovelGenre}を複数同時に指定します．<br>
     *
     * @param genres NovelGenre[] {@link NovelGenre}
     */
    public void setGenre(NovelGenre[] genres) {
        for (NovelGenre genre : genres) {
            novelGenreSet.add(genre);
        }
    }

    String getGenre() {
        return genre2String(novelGenreSet);
    }

    /**
     * 取得する小説から除くジャンル{@link NovelGenre}を指定します．<br>
     * 複数指定できます．
     *
     * @param genre NovelGenre {@link NovelGenre}
     */
    public void setNotGenre(NovelGenre genre) {
        notNovelGenreSet.add(genre);
    }

    /**
     * 取得する小説から除くジャンル{@link NovelGenre}を複数同時に指定します．<br>
     *
     * @param genres NovelGenre[] {@link NovelGenre}
     */
    public void setNotGenre(NovelGenre[] genres) {
        for (NovelGenre genre : genres) {
            notNovelGenreSet.add(genre);
        }
    }

    String getNotGenre() {
        return genre2String(notNovelGenreSet);
    }

    /**
     * 作者のユーザIDを指定します．<br>
     * 複数指定できます．複数指定するとユーザIDのOR検索ができます．
     *
     * @param id int user id
     */
    public void setUserId(int id) {
        userIdSet.add(id);
    }

    /**
     * 作者のユーザIDを複数同時に指定します．<br>
     * 複数指定するとユーザIDのOR検索ができます．
     *
     * @param ids int[] user ids
     */
    public void setUserId(int[] ids) {
        for (int id : ids) {
            userIdSet.add(id);
        }
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
        return builder.toString();
    }

    /**
     * 登録必須キーワード「R15」に関する指定をします. <br>
     * true を指定すると「R15」の作品だけ抽出し，
     * false を指定すると「R15」の作品だけ除外します．
     * @param isR15 boolean
     */
    public void setR15(boolean isR15) {
        if (isR15) {
            params.put("isr15", String.valueOf(1));
        }
        else {
            params.put("notr15", String.valueOf(1));
        }
    }

    /**
     * 登録必須キーワード「ボーイズラブ」に関する指定をします. <br>
     * true を指定すると「ボーイズラブ」の作品だけ抽出し，
     * false を指定すると「ボーイズラブ」の作品だけ除外します．
     * @param isBl boolean
     */
    public void setBl(boolean isBl) {
        if (isBl) {
            params.put("isbl", String.valueOf(1));
        }
        else {
            params.put("notbl", String.valueOf(1));
        }
    }

    /**
     * 登録必須キーワード「ガールズラブ」に関する指定をします. <br>
     * true を指定すると「ガールズラブ」の作品だけ抽出し，
     * false を指定すると「ガールズラブ」の作品だけ除外します．
     * @param isGl boolean
     */
    public void setGl(boolean isGl) {
        if (isGl) {
            params.put("isgl", String.valueOf(1));
        }
        else {
            params.put("notgl", String.valueOf(1));
        }
    }

    /**
     * 登録必須キーワード「残酷な描写あり」に関する指定をします. <br>
     * true を指定すると「残酷な描写あり」の作品だけ抽出し，
     * false を指定すると「残酷な描写あり」の作品だけ除外します．
     * @param isZankoku boolean
     */
    public void setZankoku(boolean isZankoku) {
        if (isZankoku) {
            params.put("iszankoku", String.valueOf(1));
        }
        else {
            params.put("notzankoku", String.valueOf(1));
        }
    }

    /**
     * 登録必須キーワード「異世界転生」に関する指定をします. <br>
     * true を指定すると「異世界転生」の作品だけ抽出し，
     * false を指定すると「異世界転生」の作品だけ除外します．
     * @param isTensei boolean
     */
    public void setTensei(boolean isTensei) {
        if (isTensei) {
            params.put("istensei", String.valueOf(1));
        }
        else {
            params.put("nottensei", String.valueOf(1));
        }
    }

    /**
     * 登録必須キーワード「異世界転生」または「異世界転移」に関する指定をします. <br>
     * true を指定すると「異世界転生」または「異世界転移」の作品だけ抽出します．
     * @param isTt boolean
     */
    public void setTt(boolean isTt) {
        if (isTt) {
            params.put("istt", String.valueOf(1));
        }
    }

    /**
     * 登録必須キーワード「異世界転移」に関する指定をします. <br>
     * true を指定すると「異世界転移」の作品だけ抽出し，
     * false を指定すると「異世界転移」の作品だけ除外します．
     * @param isTenni boolean
     */
    public void setTenni(boolean isTenni) {
        if (isTenni) {
            params.put("istenni", String.valueOf(1));
        }
        else {
            params.put("nottenni", String.valueOf(1));
        }
    }

    /**
     * 小説の文字数を指定します．<br>
     * ※文字数と読了時間(minlen、maxlen、length)は併用不可です．<br>
     * 同時に指定すると先に指定したパラメータが優先されます．
     *
     * @param length int
     */
    public void setCharacterLength(int length) {
        if (params.containsKey("time")) {
            throw new NarouDuplicateException("character length is not used in conjunction with the reading time. ");
        }
        params.put("length", String.valueOf(length));
    }

    /**
     * 小説の文字数の最大文字数と最小文字数を指定します．<br>
     * ※文字数と読了時間(minlen、maxlen、length)は併用不可です．<br>
     * 同時に指定すると先に指定したパラメータが優先されます．
     *
     * @param min int (0を指定すると最大以下の文字数で検索します．)
     * @param max int (0を指定すると最小以上の文字数で検索します．)
     */
    public void setCharacterLength(int min, int max) {
        if (params.containsKey("time")) {
            throw new NarouDuplicateException("character length is not used in conjunction with the reading time. ");
        }

        params.put("length", range2String(String.valueOf(min), String.valueOf(max)));
    }

    /**
     * 小説の読了時間を指定します．<br>
     * ※文字数と読了時間(minlen、maxlen、length)は併用不可です．<br>
     * 同時に指定すると先に指定したパラメータが優先されます．
     *
     * @param length int
     */
    public void setReadTime(int length) {
        if (params.containsKey("length")) {
            throw new NarouDuplicateException("reading time is not used in conjunction with the character length. ");
        }
        params.put("time", String.valueOf(length));
    }

    /**
     * 小説の読了時間を指定します．<br>
     * ※文字数と読了時間(minlen、maxlen、length)は併用不可です．<br>
     * 同時に指定すると先に指定したパラメータが優先されます．
     *
     * @param min int (0を指定すると最大以下の文字数で検索します．)
     * @param max int (0を指定すると最小以上の文字数で検索します．)
     */
    public void setReadTime(int min, int max) {
        if (params.containsKey("length")) {
            throw new NarouDuplicateException("reading time is not used in conjunction with the character length. ");
        }

        params.put("time", range2String(String.valueOf(min), String.valueOf(max)));
    }

    /**
     * 小説の会話率を%単位で指定します．<br>
     *
     * @param rate int
     */
    public void setConversationRate(int rate) {
        params.put("kaiwaritu", String.valueOf(rate));
    }

    /**
     * 小説の会話率を%単位で範囲指定します．
     *
     * @param min int (0を指定するとmax以下で検索します．)
     * @param max int (0を指定するとmin以上で検索します．)
     */
    public void setConversationRate(int min, int max) {
        params.put("kaiwaritu", range2String(String.valueOf(min), String.valueOf(max)));
    }

    /**
     * 小説に掲載されている挿絵の数を指定します．<br>
     *
     * @param num int
     */
    public void setArtworks(int num) {
        params.put("sasie", String.valueOf(num));
    }

    /**
     * 小説に掲載されている挿絵の数を範囲指定します．<br>
     *
     * @param min int (0を指定するとmax以下で検索します．)
     * @param max int (0を指定するとmin以上で検索します．)
     */
    public void setArtworks(int min, int max) {
        params.put("sasie", range2String(String.valueOf(min), String.valueOf(max)));
    }

    /**
     * 小説のNコードを指定します．<br>
     * 複数指定できます．複数指定した場合はOR検索します．
     *
     * @param ncode String
     */
    public void setNCode(String ncode) {
        ncodeSet.add(ncode);
    }

    /**
     * 小説のNコードを複数同時に指定します．<br>
     * 複数指定した場合はOR検索します.
     *
     * @param ncodes String list Nコード
     */
    public void setNCode(String[] ncodes) {
        for (String ncode : ncodes) {
            ncodeSet.add(ncode);
        }
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
        return builder.toString();
    }

    /**
     * 小説タイプ{@link NovelType}を指定します．<br>
     *
     * @param type NovelType {@link NovelType}
     */
    public void setNovelType(NovelType type) {
        params.put("type", type.getId());
    }

    /**
     * 連載停止中作品に関する指定ができます．<br>
     * true で長期連載停止中を除きます．<br>
     * false で長期連載停止中のみ取得します．<br>
     *
     * @param isExclude boolen
     */
    public void setExcludeStop(boolean isExclude) {
        if (isExclude) {
            params.put("stop", "1");
        }
        else {
            params.put("stop", "2");
        }
    }

    /**
     * ピックアップ条件に当てはまる小説を指定します．<br>
     * true で最終掲載日(general_lastup)から60日以内でなおかつ「短編または完結済または10万文字以上の連載中」<br>
     * false で上記ピックアップ条件を満たさない作品
     *
     * @param isPickup boolean
     */
    public void setPickup(boolean isPickup) {
        if (isPickup) {
            params.put("ispickup", "1");
        }
        else {
            params.put("ispickup", "0");
        }
    }

    /**
     * 最終掲載日で検索します．<br>
     * 詳細は{@link UploadAt}を参照<br>
     *
     * @param at UploadAt {@link UploadAt}
     */
    public void setLastUploadAt(UploadAt at) {
        params.put("lastup", at.getId());
    }

    /**
     * 最終掲載日を指定します．
     *
     * @param date Date
     */
    public void setLastUploadAt(Date date) {
        long unixtime = date.getTime() / 1000L;
        params.put("lastup", String.valueOf(unixtime));
    }

    /**
     * 最終掲載日で期間指定で検索します．<br>
     *
     * @param min Date
     * @param max Date
     */
    public void setLastUploadAt(Date min, Date max) {
        long minUnixtime = min.getTime() / 1000L;
        long maxUnixtime = max.getTime() / 1000L;

        if (min == null && max != null) {
            params.put("lastup", range2String("0", String.valueOf(maxUnixtime)));
        }
        else if (min != null && max == null) {
            params.put("lastup", range2String(String.valueOf(minUnixtime), "0"));
        }
        else {
            params.put("lastup", range2String(String.valueOf(minUnixtime), String.valueOf(maxUnixtime)));
        }
    }



    private String bigGenre2String(Set<NovelBigGenre> set) {
        StringBuilder builder = new StringBuilder();

        int i = 1;
        for (NovelBigGenre novelGenre : set) {
            builder.append(novelGenre.getId());
            if (i != set.size()) {
                builder.append("-");
            }

            i++;
        }
        return builder.toString();
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
