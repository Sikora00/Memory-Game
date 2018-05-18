package Components.Ranking;

import Services.RankingService;

import javax.swing.*;
import java.awt.*;

public class RankingTable extends JTable {
    public RankingTable() {
        super(RankingService.readRankingFromStorage().toArray(), new String[]{"Score", "User", "Pairs", "Time"});
        setPreferredScrollableViewportSize(new Dimension(500, 500));
        setFillsViewportHeight(true);
    }
}
