package Components.Game;

import Components.HomeWindow.HomeView;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame extends JFrame {
    int pairs;

    public GameFrame(int pairs) {
        super("Memory Game");
        this.pairs = pairs;
        createAndShowGUI();
    }

    private void createAndShowGUI() {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        GamePanel panel = new GamePanel(pairs * 2);
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        setContentPane(scrollPane);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                HomeView.createAndShowGUI();
            }
        });


        pack();
        setVisible(true);
    }
}
