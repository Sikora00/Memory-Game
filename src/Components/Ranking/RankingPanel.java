package Components.Ranking;

import Configs.Fonts;
import Helpers.Helper;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

class RankingPanel extends JPanel {

    RankingPanel() {
        super();
        addComponents();
    }

    private void addComponents() {
        JPanel content = new JPanel(new BorderLayout());
        addTitleRow(content);
        addTable(content);
        add(content);
    }

    private void addTitleRow(JPanel panel) {
        JLabel titleLabel = new JLabel("High Scores", SwingConstants.CENTER);
        titleLabel.setFont(new Font(Fonts.MAIN_FONT, Font.BOLD, 30));
        titleLabel.setBorder(new EmptyBorder(10,0,10,0));
        panel.add(titleLabel, BorderLayout.PAGE_START);
    }

    private void addTable(JPanel panel) {
        JScrollPane scrollPane = new JScrollPane(new RankingTable());
        panel.add(scrollPane, BorderLayout.CENTER);
    }
}