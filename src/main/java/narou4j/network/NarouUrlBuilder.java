package narou4j.network;

import okhttp3.HttpUrl;

public class NarouUrlBuilder {
    private static final String SCHEME = "http";
    private static final String HOST = "api.syosetu.com";
    private static final String ROOT = "novelapi";
    private static final String API = "api";

    private static HttpUrl.Builder buildRootUrl() {
        return new HttpUrl.Builder()
                .scheme(SCHEME)
                .host(HOST)
                .addPathSegment(ROOT);
    }

    /**
     * http://api.syosetu.com/novelapi/api/
     * @return {@link okhttp3.HttpUrl.Builder}
     */
    static HttpUrl.Builder buildApiUrl() {
        return buildRootUrl().addPathSegment(API);
    }
}
