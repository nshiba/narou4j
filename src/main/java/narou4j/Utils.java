package narou4j;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

public class Utils {

    public static List<Novel> response2Json(Response response) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String str = response.body().string();
            List<Novel> novels = mapper.readValue(str, new TypeReference<List<Novel>>(){});
            return novels;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
