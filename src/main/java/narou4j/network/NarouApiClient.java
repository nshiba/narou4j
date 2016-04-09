package narou4j.network;

import okhttp3.*;

import java.io.IOException;
import java.util.Map;

public class NarouApiClient {

    private OkHttpClient client = new OkHttpClient();

    public Response getNovels(Map<String, String> params) {
        HttpUrl.Builder builder = NarouUrlBuilder.buildApiUrl();
        for (String key : params.keySet()) {
            builder.addQueryParameter(key, params.get(key));
        }

        return enqueue(builder);
    }

    private Response enqueue(HttpUrl.Builder builder) {
        Request request = new Request.Builder()
                .url(builder.build())
                .get().build();

        Call call = client.newCall(request);
        try {
            return call.execute();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
