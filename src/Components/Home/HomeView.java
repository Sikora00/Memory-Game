package Components.Home;

import javax.swing.*;

public class HomeView implements Runnable{

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Memory The Game");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        new HomePanel(frame);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public void run()
    {
        createAndShowGUI();
    }
}
