import narou4j.Narou;
import narou4j.Novel;
import narou4j.enums.OfParam;
import narou4j.enums.OutputOrder;
import narou4j.enums.SearchTarget;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Narou narou = new Narou();
        narou.setNotWord("ファンタジー");
        narou.setSearchTarget(SearchTarget.KEYWORD);

//        narou.setOfParams(OfParam.TITLE);
//        narou.setOfParams(OfParam.GENRE);
//        narou.setOfParams(OfParam.STORY);

        narou.setOrder(OutputOrder.TOTAL_POINT);

//        narou.setGzip(5);

        List<Novel> novels = narou.getNovels();
        for (Novel novel : novels) {
            System.out.println(novel.toString());
        }
        System.out.println(novels.size());
    }
}
