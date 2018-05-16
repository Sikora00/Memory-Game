package Components.Game;

import Components.HomeWindow.HomeView;
import Entities.Ranking;
import Entities.Score;
import Entities.User;
import Events.GameFinished.GameFinishedListener;
import Events.GameFinished.GameFinishedListeners;
import Services.RankingService;
import ValueObjects.TimerValue;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame extends JFrame implements GameFinishedListener {
    int pairs;
    GamePanel gamePanel;

    public GameFrame(int pairs) {
        super("Memory Game");
        this.pairs = pairs;
        createAndShowGUI();
    }

    private void createAndShowGUI() {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.gamePanel = new GamePanel(pairs * 2);
        JScrollPane scrollPane = new JScrollPane(gamePanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        setContentPane(scrollPane);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                HomeView.createAndShowGUI();
            }
        });

        GameFinishedListeners.addListener(gamePanel);
        GameFinishedListeners.addListener(this);


        pack();
        setVisible(true);
    }

    @Override
    public void onGameFinished() {
        String username = JOptionPane.showInputDialog("Your Name");
        if (username != null) {
            Ranking ranking = RankingService.readRankingFromStorage();
            ranking.addScore(new Score(new User(username), new TimerValue(this.gamePanel.getTimerLabel().getText()).getSeconds(), pairs));
            RankingService.replaceOldRanking(ranking);
        }
        dispose();
        HomeView.createAndShowGUI();
    }
}
