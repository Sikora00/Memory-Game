package Components.Game;

import Configs.Fonts;
import ValueObjects.TimerValue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
    private int cardsNumber;

    GamePanel(int cardsNumber) {
        super();
        this.cardsNumber = cardsNumber;
        JPanel content = new JPanel(new GridBagLayout());

        this.addTimer(content);

        int cols = 0;
        for (int i = 6; i > 0; i--) {
            if (this.cardsNumber % i == 0) {
                cols = i;
                break;
            }
        }

        final JPanel cards = new JPanel(new GridLayout(0, cols));
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;

        for (int i = 1; i <= this.cardsNumber; i++) {
            this.addCard(cards);
        }

        addComponentToPanel(cards, content, c);

        add(content);
    }

    private void addTimer(JPanel panel) {
        JLabel label = new JLabel(new TimerValue().toString());
        label.setFont(new Font(Fonts.MAIN_FONT, Font.BOLD, 30));
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 0;
        c.ipady = 80;
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        int delay = 1000; //milliseconds
        ActionListener taskPerformer = (ActionEvent evt) -> {
            TimerValue value = new TimerValue(label.getText());
            value.addOneSecond();
            label.setText(value.toString());

        };
        new Timer(delay, taskPerformer).start();

        addComponentToPanel(label, panel, c);
    }

    private void addCard(JPanel panel) {
        Card card = new Card();
        this.addComponentToPanel(card, panel, null);
    }

    private void addComponentToPanel(JComponent component, JPanel panel, GridBagConstraints options) {
        panel.add(component, options);
    }
}
