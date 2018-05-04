package Windows.RankingView;

import Entities.Ranking;
import Entities.Score;
import Entities.User;

import javax.swing.*;

public class RankingView implements Runnable{

    public RankingView() {
        createAndShowGUI();
    }
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {

        JFrame frame = new JFrame("Ranking");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        RankingPanel panel = new RankingPanel();
        frame.setContentPane(panel);

        frame.pack();
        frame.setVisible(true);
    }

    public void run()
    {
        createAndShowGUI();
    }
}
