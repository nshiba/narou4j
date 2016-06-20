package narou4j.network;

import okhttp3.HttpUrl;

public class NarouUrlBuilder {
    private static final String SCHEME = "http";
    private static final String API_HOST = "api.syosetu.com";
    private static final String NCODE_HOST = "ncode.syosetu.com";
    private static final String NOVEL = "novelapi";
    private static final String API = "api";
    private static final String RANK = "rank";
    private static final String RANKING = "rankget";
    private static final String RANKIN_DETAIL = "rankin";

    private static HttpUrl.Builder buildRootApiUrl() {
        return new HttpUrl.Builder()
                .scheme(SCHEME)
                .host(API_HOST);
    }

    private static HttpUrl.Builder buildRootNcodeUrl() {
        return new HttpUrl.Builder()
                .scheme(SCHEME)
                .host(NCODE_HOST);
    }

    /**
     * http://api.syosetu.com/novelapi/api/
     * @return {@link okhttp3.HttpUrl.Builder}
     */
    static HttpUrl.Builder buildApiUrl() {
        return buildRootApiUrl().addPathSegment(NOVEL).addPathSegment(API);
    }

    /**
     * http://api.syosetu.com/rank/rankget/
     * @return {@link okhttp3.HttpUrl.Builder}
     */
    static HttpUrl.Builder buildRankingUrl() {
        return buildRootApiUrl().addPathSegment(RANK).addPathSegment(RANKING);
    }

    /**
     * http://api.syosetu.com/rank/rankin/
     * @return {@link okhttp3.HttpUrl.Builder}
     */
    static HttpUrl.Builder buildRankinDetail() {
        return buildRootApiUrl().addPathSegment(RANK).addPathSegment(RANKIN_DETAIL);
    }

    /**
     * http://ncode.syosetu.com/ncode/
     * @param ncode String 小説コード
     * @return {@link okhttp3.HttpUrl.Builder}
     */
    static HttpUrl.Builder buildNovelTableUrl(String ncode) {
        return buildRootNcodeUrl().addPathSegment(ncode);
    }
}
