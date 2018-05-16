package Components.Ranking;

import Components.HomeWindow.HomeView;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RankingFrame extends JFrame{

    public RankingFrame() {
        super("Ranking");
        createAndShowGUI();
    }
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private void createAndShowGUI() {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        RankingPanel panel = new RankingPanel();
        setContentPane(panel);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                HomeView.createAndShowGUI();
            }
        });


        pack();
        setVisible(true);
    }
}
