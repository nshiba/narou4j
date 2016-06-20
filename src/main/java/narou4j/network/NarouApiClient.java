package narou4j.network;

import narou4j.Narou;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;

public class NarouApiClient {

    private OkHttpClient client = new OkHttpClient();

    /**
     * 小説を指定されたパラメータで取得する．
     *
     * @param params 指定するパラメータのHashMap
     * @return HTTP通信のレスポンス {@link Response}
     */
    public Response getNovels(Map<String, String> params) throws IOException {
        HttpUrl.Builder builder = NarouUrlBuilder.buildApiUrl();
        for (String key : params.keySet()) {
            builder.addQueryParameter(key, params.get(key));
        }

        return enqueue(builder);
    }

    /**
     * ランキングを指定されたパラメータで取得する．
     *
     * @param params 指定するパラメータのHashMap
     * @return HTTP通信のレスポンス {@link Response}
     */
    public Response getRanking(Map<String, String> params) throws IOException {
        HttpUrl.Builder builder = NarouUrlBuilder.buildRankingUrl();
        for (String key : params.keySet()) {
            builder.addQueryParameter(key, params.get(key));
        }

        return enqueue(builder);
    }

    /**
     * ランキングを指定されたパラメータで取得する．
     *
     * @param params 指定するパラメータのHashMap
     * @return HTTP通信のレスポンス {@link Response}
     */
    public Response getRankinDetail(Map<String, String> params) throws IOException {
        HttpUrl.Builder builder = NarouUrlBuilder.buildRankinDetail();
        for (String key : params.keySet()) {
            builder.addQueryParameter(key, params.get(key));
        }

        return enqueue(builder);
    }

    /**
     * 小説の目次ページを取得
     *
     * @param ncode String 小説コード
     * @return HTTP通信のレスポンス {@link Response}
     */
    public Response getNovelTable(String ncode) throws IOException {
        return enqueue(NarouUrlBuilder.buildNovelTableUrl(ncode));
    }

    /**
     * 指定した小説の指定したページの本文を取得する
     *
     * @param ncode String 小説コード
     * @param page int ページ番号
     * @return Response HTTP通信のレスポンス {@link Response}
     */
    public Response getNovelBody(String ncode, int page) throws IOException {
        return enqueue(NarouUrlBuilder.buildNovelTableUrl(ncode).addPathSegment(String.valueOf(page)));
    }

    private Response enqueue(HttpUrl.Builder builder) throws IOException {
        Request request = new Request.Builder()
                .url(builder.build())
                .get().build();

        Call call = client.newCall(request);
        return call.execute();
    }
}
