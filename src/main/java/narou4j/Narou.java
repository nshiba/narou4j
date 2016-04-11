package narou4j;

import narou4j.network.NarouApiClient;

import java.util.List;

public class Narou extends GetParameter {

    private NarouApiClient client;

    public Narou() {
        params.put("out", "json");
    }

    public List<Novel> getNovels() {
        client = new NarouApiClient();
        params.put("of", getOfParam());
        params.put("genre", getGenre());
        params.put("notgenre", getNotGenre());
        params.put("userid", getUserIds());
        params.put("ncode", getNcodes());
        return Utils.response2Json(client.getNovels(params));
    }
}
