package narou4j;

import narou4j.enums.OutputOrder;
import narou4j.enums.RankingType;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Ranking ranking = new Ranking();
//        System.out.println("rankin -------------------------------------------------------------");
//        List<NovelRank> novelRanks = ranking.getRankinDetail("n9669bk");
//        for (NovelRank rank : novelRanks) {
//            System.out.println(rank.toString());
//        }
//
//        System.out.println("ranking list -------------------------------------------------------------");
//        novelRanks = ranking.getRanking(RankingType.MONTHLY);
//        for (NovelRank rank : novelRanks) {
//            System.out.println(rank.toString());
//        }

//        Narou narou = new Narou();
//        narou.setOrder(OutputOrder.TOTAL_POINT);
//        List<Novel> novels = narou.getNovels();
//        for (Novel novel : novels) {
//            System.out.println(novel.toString());
//        }

        Narou narou = new Narou();
        Novel novel = narou.getNovelAll("n5779da");
        System.out.println(novel.toString());
    }
}
