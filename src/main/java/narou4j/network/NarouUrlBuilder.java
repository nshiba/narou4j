package narou4j.network;

import okhttp3.HttpUrl;

public class NarouUrlBuilder {
    private static final String SCHEME = "http";
    private static final String HOST = "api.syosetu.com";
    private static final String NOVEL = "novelapi";
    private static final String API = "api";
    private static final String RANK = "rank";
    private static final String RANKING = "rankget";
    private static final String RANKIN_DETAIL = "rankin";

    private static HttpUrl.Builder buildRootUrl() {
        return new HttpUrl.Builder()
                .scheme(SCHEME)
                .host(HOST);
    }

    /**
     * http://api.syosetu.com/novelapi/api/
     * @return {@link okhttp3.HttpUrl.Builder}
     */
    static HttpUrl.Builder buildApiUrl() {
        return buildRootUrl().addPathSegment(NOVEL).addPathSegment(API);
    }

    /**
     * http://api.syosetu.com/rank/rankget/
     * @return {@link okhttp3.HttpUrl.Builder}
     */
    static HttpUrl.Builder buildRankingUrl() {
        return buildRootUrl().addPathSegment(RANK).addPathSegment(RANKING);
    }

    /**
     * http://api.syosetu.com/rank/rankin/
     * @return {@link okhttp3.HttpUrl.Builder}
     */
    static HttpUrl.Builder buildRankinDetail() {
        return buildRootUrl().addPathSegment(RANK).addPathSegment(RANKIN_DETAIL);
    }
}
