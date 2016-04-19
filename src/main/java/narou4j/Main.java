package narou4j;

import narou4j.enums.RankingType;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Ranking ranking = new Ranking();
        System.out.println("rankin -------------------------------------------------------------");
        List<NovelRank> novelRanks = ranking.getRankinDetail("n9669bk");
        for (NovelRank rank : novelRanks) {
            System.out.println(rank.toString());
        }

        System.out.println("ranking list -------------------------------------------------------------");
        novelRanks = ranking.getRanking(RankingType.MONTHLY);
        for (NovelRank rank : novelRanks) {
            System.out.println(rank.toString());
        }
    }
}
