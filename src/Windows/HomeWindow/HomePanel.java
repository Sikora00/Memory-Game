package Windows.HomeWindow;

import Configs.Fonts;
import Configs.Palette;
import Windows.NewGameWindow.NewGameWindow;
import Windows.RankingView.RankingWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class HomePanel extends JPanel {
    private final int FONT_SIZE = 30;
    private Container pane;
    private JFrame frame;

    HomePanel(JFrame frame) {
        this.frame = frame;
        this.pane = frame.getContentPane();
        this.addComponentsToPane();
    }


    private void addComponentsToPane() {
        JPanel gridPanel = new JPanel(new GridLayout(8, 1));

        addTitleRow(gridPanel);
        addStudentRow(gridPanel);
        addNewGameButton(gridPanel);
        addRankingButton(gridPanel);
        addExitButton(gridPanel);

        pane.add(gridPanel);
    }

    private void addComponentToPanel(JComponent component, JPanel panel) {
        JPanel row = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 20));
        row.add(component);
        panel.add(row);
    }

    private void addExitButton(JPanel panel) {
        JButton button = this.createButton("Exit");
        button.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        this.addComponentToPanel(button, panel);
    }

    private void addNewGameButton(JPanel gridPanel) {
        JButton button = this.createButton("NewGame");
        button.setForeground(Color.WHITE);
        button.setBackground(Palette.MAIN_COLOR);
        button.addActionListener((ActionEvent e) -> javax.swing.SwingUtilities.invokeLater(new NewGameWindow(frame)));
        this.addComponentToPanel(button, gridPanel);
    }

    private void addRankingButton(JPanel gridPanel) {
        JButton button = this.createButton("Hight Scores");
        button.addActionListener((ActionEvent e) -> {
            javax.swing.SwingUtilities.invokeLater(new RankingWindow());
            this.frame.dispose();
        });
        this.addComponentToPanel(button, gridPanel);
    }

    private void addStudentRow(JPanel panel) {
        JLabel label = new JLabel("s17265");
        label.setFont(new Font(Fonts.MAIN_FONT, Font.PLAIN, FONT_SIZE));
        this.addComponentToPanel(label, panel);
    }

    private void addTitleRow(JPanel panel) {
        JLabel label = new JLabel("Memory The Game");
        label.setFont(new Font(Fonts.MAIN_FONT, Font.BOLD, FONT_SIZE));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.addComponentToPanel(label, panel);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font(Fonts.MAIN_FONT, Font.PLAIN, FONT_SIZE));
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(280, 60));
        return button;
    }
}
