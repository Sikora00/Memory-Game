package Components.Ranking;

import Repositories.RankingRepository;

import javax.swing.*;
import java.awt.*;

public class RankingTable extends JTable {
    public RankingTable() {
        super(RankingRepository.getRanking().toArray(), new String[]{"Score", "User", "Pairs", "Time"});
        setPreferredScrollableViewportSize(new Dimension(500, 500));
        setFillsViewportHeight(true);
    }
}
