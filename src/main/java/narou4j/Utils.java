package narou4j;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;

import java.io.*;
import java.util.List;
import java.util.zip.GZIPInputStream;

class Utils {

    static List<Novel> response2Json(Response response, boolean isGzip) {
        ObjectMapper mapper = new ObjectMapper();
        String str = null;

        if (isGzip) {
            try {
                try (BufferedReader br = new BufferedReader(
                        new InputStreamReader(new GZIPInputStream(response.body().byteStream())))) {

                    StringBuilder builder = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        builder.append(line);
                    }

                    str = builder.toString();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                str = response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        List<Novel> novels = null;
        try {
            novels = mapper.readValue(str, new TypeReference<List<Novel>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return novels;
    }
}
