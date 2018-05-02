package HomeWindow;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {

    public HomePanel(Container pane) {
        HomePanel.addComponentsToPane(pane);
    }

    public static void addComponentsToPane(Container pane) {
//        JPanel mainPanel = new JPanel(new GridLayout(0, 1));
        JPanel gridPanel = new JPanel(new GridLayout(0, 1));

        JLabel title = new JLabel("Memory The Game");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        JPanel titleRow = new JPanel(new FlowLayout());
        titleRow.add(title);
        gridPanel.add(titleRow);

        JLabel studentLabel = new JLabel("s17265");
        title.setFont(new Font("Tahoma", Font.PLAIN, 20));
        pane.add(new JPanel().add(studentLabel));
        gridPanel.add(studentLabel);
        JPanel studentTextFieldPanel = new JPanel();
        studentTextFieldPanel.add(studentLabel);
        gridPanel.add(studentTextFieldPanel);

        addAButton("New game", gridPanel);
        addAButton("Hight Scores", gridPanel);
        addAButton("Exit", gridPanel);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(gridPanel, BorderLayout.NORTH);

        pane.add(mainPanel);

    }

    private static void addAButton(String text, JPanel panel) {
        JButton button = new JButton(text);
        HomePanel.addComponentToPanel(button, panel);
    }

    private static void addComponentToPanel(JComponent component, JPanel panel) {
        component.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel row = new JPanel();
        row.add(component);
        panel.add(row);
    }
}
