package narou4j;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import narou4j.networks.CallBack;
import narou4j.networks.NarouApiClient;
import okhttp3.Call;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

public class Narou {
    ObjectMapper mapper = new ObjectMapper();

    public List<Novel> getNovels() {
//        NarouApiClient client = new NarouApiClient((call, e) -> e.printStackTrace());

        NarouApiClient client = new NarouApiClient(new CallBack() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
        });

        try {
            Response response = client.getAllNovel();
            String str = response.body().string();
            System.out.println(str);
            List<Novel> novels = mapper.readValue(str, new TypeReference<List<Novel>>(){});
            return novels;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
