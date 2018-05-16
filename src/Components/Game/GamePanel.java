package Components.Game;

import Configs.Fonts;
import Events.CardOpened.CardOpenedListener;
import Events.CardOpened.CardOpenedListeners;
import Events.GameFinished.GameFinishedListener;
import Events.GameFinished.GameFinishedListeners;
import Factories.CardsFactory;
import ValueObjects.TimerValue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GamePanel extends JPanel implements GameFinishedListener, CardOpenedListener{
    private int cardsNumber;
    private int openedCards = 0;
    private Timer timer;
    private Card firstCard;

    GamePanel(int cardsPairs) {
        super();
        CardOpenedListeners.addListener(this);
        this.cardsNumber = cardsPairs;
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

        List<Card> cardsComponents = CardsFactory.createCardsPairs(cardsPairs);
        for (Card card : cardsComponents) {
            this.addCard(card, cards);
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
        timer = new Timer(delay, taskPerformer);
        timer.start();

        addComponentToPanel(label, panel, c);
    }

    private void addCard(Card card, JPanel panel) {
        this.addComponentToPanel(card, panel, null);
    }

    private void addComponentToPanel(JComponent component, JPanel panel, GridBagConstraints options) {
        panel.add(component, options);
    }

    @Override
    public void onGameFinished() {
        timer.stop();
    }

    @Override
    public void onCardOpened(Card card) {
        openedCards++;
        if (firstCard == null) {
            firstCard = card;
            return;
        }


        if (openedCards == cardsNumber) {
            GameFinishedListeners.onGameFinished();
        }
    }
}
