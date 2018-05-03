import Entities.Ranking;
import Entities.Score;
import Entities.User;
import Services.RankingService;
import Windows.HomeWindow.HomeView;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        Ranking ranking = new Ranking();
        ranking.addScore(new Score(new User("Maciek"), 3600, 24));
        RankingService.replaceOldRanking(ranking);
//        javax.swing.SwingUtilities.invokeLater(new HomeView());
    }
}
