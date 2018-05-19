package Components.Home;

import javax.swing.*;

public class HomeView implements Runnable{


    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Memory The Game");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        new HomePanel(frame);

        frame.pack();
        frame.setVisible(true);
    }

    public void run()
    {
        createAndShowGUI();
    }
}
