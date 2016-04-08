package narou4j;

import narou4j.networks.NarouApiClient;
import okhttp3.Call;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

public class Narou {

    public List<Novel> getNovels() {
        NarouApiClient client = new NarouApiClient() {
            @Override
            public void onFailure(Call call, IOException e) {
            }
        };

        return Utils.response2Json(client.getAllNovel());
    }
}
