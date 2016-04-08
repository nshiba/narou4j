package narou4j.networks;

import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class NarouApiClient {
    private OkHttpClient client = new OkHttpClient();
    private Map<String, String> params = new HashMap<String, String>();
    private HttpUrl.Builder builder = NarouUrlBuilder.buildApiUrl();

    public NarouApiClient() {
        builder.addQueryParameter("out", "json");
    }

    public Response getAllNovel() {
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
            onFailure(call, e);
            return null;
        }
    }

    public abstract void onFailure(Call call, IOException e);
}
