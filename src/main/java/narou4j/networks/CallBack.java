package narou4j.networks;

import okhttp3.Call;
import okhttp3.Response;

import java.io.IOException;

public interface CallBack {
    void onFailure(Call call, IOException e);
}