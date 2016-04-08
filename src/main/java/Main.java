import narou4j.Narou;
import narou4j.Novel;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Narou narou = new Narou();
        List<Novel> novels = narou.getNovels();
        System.out.println(novels.get(1).toString());
    }
}
