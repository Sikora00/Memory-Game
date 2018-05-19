package Components.Ranking;

import Configs.Fonts;

import javax.swing.*;
import java.awt.*;

class RankingPanel extends JPanel {

    RankingPanel() {
        super(new GridLayout(1, 3));
        addComponents();
    }

    private void addComponents() {
        // Left Column
        addEmptyComponentToPane(this);
        // Center Column
        JPanel flowLayout = new JPanel();
        addContent(flowLayout);
        add(flowLayout);
        // Right Column
        addEmptyComponentToPane(this);
    }

    private void addTitleRow(JPanel panel) {
        JLabel label = new JLabel("High Scores");
        label.setFont(new Font(Fonts.MAIN_FONT, Font.BOLD, 30));
        GridBagConstraints c = new GridBagConstraints();
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        addComponentToPanel(label, panel, c);
    }

    private void addEmptyComponentToPane(JPanel panel) {
        addComponentToPanel(new JLabel(), panel, null);
    }

    private void addContent(JPanel panel) {
        JPanel content = new JPanel(new GridBagLayout());
        this.addTitleRow(content);
        addTable(content);
        panel.add(content);
    }

    private void addTable(JPanel panel) {
        JScrollPane scrollPane = new JScrollPane(new RankingTable());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.VERTICAL;
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridwidth = 10;
        addComponentToPanel(scrollPane, panel, c);
    }


    private void addComponentToPanel(JComponent component, JPanel panel, GridBagConstraints options) {
        panel.add(component, options);
    }
}