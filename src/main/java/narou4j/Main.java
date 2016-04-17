package narou4j;

import narou4j.enums.RankingType;

import java.util.Calendar;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {
        Ranking ranking = new Ranking();
        for (NovelRank rank : ranking.getRanking(RankingType.MONTHLY)) {
            System.out.println(rank.toString());
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));

        System.out.println("-------------------------------------");
        calendar.set(2016, Calendar.APRIL,10);
        for (NovelRank rank : ranking.getRanking(RankingType.WEEKLY, calendar.getTime())) {
            System.out.println(rank.toString());
        }
        System.out.println("-------------------------------------");
        calendar = Calendar.getInstance();
        calendar.set(2016, Calendar.JANUARY,20);
        for (NovelRank rank : ranking.getRanking(RankingType.MONTHLY, calendar.getTime())) {
            System.out.println(rank.toString());
        }
        System.out.println("-------------------------------------");
        calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.DECEMBER,20);
        for (NovelRank rank : ranking.getRanking(RankingType.QUARTET, calendar.getTime())) {
            System.out.println(rank.toString());
        }

//        Narou narou = new Narou();
//        for (Novel novel : narou.getNovels()) {
//            System.out.println(novel.toString());
//        }
    }
}
