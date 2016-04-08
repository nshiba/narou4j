import narou4j.Narou;
import narou4j.Novel;

import java.util.List;

import static narou4j.enums.SearchTarget.*;

public class Main {

    public static void main(String[] args) {
        Narou narou = new Narou();
        narou.setNotWord("ファンタジー");
        narou.setSearchTarget(KEYWORD);

        List<Novel> novels = narou.getNovels();
        for (Novel novel : novels) {
            System.out.println(novel.toString());
        }
        System.out.println(novels.size());
    }
}
