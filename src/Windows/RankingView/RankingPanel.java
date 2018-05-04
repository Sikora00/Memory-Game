package Windows.RankingView;

import Configs.Fonts;
import Services.RankingService;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

class RankingPanel extends JPanel {

    RankingPanel() {
        super(new GridLayout(1, 3));
        addComponentToPanel(new JLabel(), this, null);

        JPanel content = new JPanel(new GridBagLayout());
        addComponentToPanel(new JLabel(), content, null);
        this.addTitleRow(content);
        String[] columnNames = {
                "Score",
                "User",
                "Pairs",
                "Time"};

        Object[][] data = new Object[0][];
        try {
            data = RankingService.readRankingFromStorage().toArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 500));
        table.setFillsViewportHeight(true);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.VERTICAL;
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridwidth = 10;

        JScrollPane scrollPane = new JScrollPane(table);

        addComponentToPanel(scrollPane, content, c);

        JPanel tmp = new JPanel();
        tmp.add(content);
        add(tmp);
        addComponentToPanel(new JLabel(), this, null);
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

    private void addComponentToPanel(JComponent component, JPanel panel, GridBagConstraints options) {
        panel.add(component, options);
    }
}