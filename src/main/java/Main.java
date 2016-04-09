import narou4j.Narou;
import narou4j.Novel;
import narou4j.enums.Genre;
import narou4j.enums.OutputOrder;
import narou4j.enums.SearchWordTarget;
import narou4j.enums.WarnigTag;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Narou narou = new Narou();

        narou.setNotWord("ファンタジー");
        narou.setSearchTarget(SearchWordTarget.KEYWORD);

//        narou.setOfParams(OfParam.TITLE);
//        narou.setOfParams(OfParam.GENRE);
//        narou.setOfParams(OfParam.STORY);

//        narou.setGenre(Genre.POEM);
//        narou.setGenre(Genre.LITERATURE);

//        narou.setNotGenre(Genre.FANTASY);

        narou.setOrder(OutputOrder.TOTAL_POINT);

        narou.setLim(5);

        narou.setWarnigTag(WarnigTag.BL);
        narou.setWarnigTag(WarnigTag.ZANKOKU);

//        narou.setUserId(288399);
//        narou.setUserId(345745);

//        narou.setGzip(5);

        List<Novel> novels = narou.getNovels();
        for (Novel novel : novels) {
            System.out.println(novel.toString());
        }
        System.out.println(novels.size());
    }
}
