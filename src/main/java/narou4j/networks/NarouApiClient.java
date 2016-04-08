package narou4j.networks;

import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class NarouApiClient {
    private OkHttpClient client = new OkHttpClient();
    private Map<String, String> params = new HashMap<String, String>();
    private CallBack callBack;

    public NarouApiClient(CallBack callBack) {
        this.callBack = callBack;
    }

    public Response getAllNovel() {
        HttpUrl.Builder builder = NarouUrlBuilder.buildApiUrl();
        builder.addQueryParameter("out", "json");
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
            callBack.onFailure(call, e);
            return null;
        }
    }
}
