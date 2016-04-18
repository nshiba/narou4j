package narou4j;

import narou4j.enums.RankingType;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {
        Narou narou = new Narou();
        List<NovelBody> list = narou.getNovelAll("n5779da");
        for (NovelBody body : list) {
            System.out.println(body.toString());
        }
    }
}
