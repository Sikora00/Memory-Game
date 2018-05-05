package Windows.Game;

import Windows.HomeWindow.HomeView;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow implements Runnable{
    public GameWindow() {
//        createAndShowGUI();
    }
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {

        JFrame frame = new JFrame("Ranking");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        GamePanel panel = new GamePanel();
        frame.setContentPane(panel);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                HomeView.createAndShowGUI();
            }
        });


        frame.pack();
        frame.setVisible(true);
    }

    public void run()
    {
        createAndShowGUI();
    }
}
