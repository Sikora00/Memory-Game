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

public class GamePanel extends JPanel implements GameFinishedListener, CardOpenedListener {
    private int cardsNumber;
    private int openedCards = 0;
    private Timer timer;
    private Card firstCard;
    private List<Card> cards;
    private JLabel timerComponent;

    GamePanel(int cardsNumber) {
        super();
        CardOpenedListeners.addListener(this);
        this.cardsNumber = cardsNumber;
        this.addComponents();
    }

    private void addComponents() {
        JPanel content = new JPanel(new GridBagLayout());
        this.addTimerComponent(content);
        final JPanel cards = new JPanel(new GridLayout(0, 6));
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;

        this.cards = CardsFactory.createCardsPairs(cardsNumber / 2);
        for (Card card : this.cards) {
            this.addCard(card, cards);
        }

        addComponentToPanel(cards, content, c);

        add(content);
    }

    private void addTimerComponent(JPanel panel) {
        JLabel timerComponent = new JLabel(new TimerValue().toString());
        timerComponent.setFont(new Font(Fonts.MAIN_FONT, Font.BOLD, 30));
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 0;
        c.ipady = 80;
        timerComponent.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.timerComponent = timerComponent;
        createTimer(timerComponent);

        addComponentToPanel(timerComponent, panel, c);
    }

    private void createTimer(JLabel timerComponent) {
        int delay = 1000; //milliseconds
        ActionListener taskPerformer = (ActionEvent evt) -> {
            TimerValue value = new TimerValue(timerComponent.getText());
            value.addOneSecond();
            timerComponent.setText(value.toString());

        };
        timer = new Timer(delay, taskPerformer);
        timer.start();
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

        if (firstCard.getId() != card.getId()) {
            Timer timer = new Timer(2000, (ActionEvent arg0) -> {
                firstCard.closeCard();
                card.closeCard();
                openedCards = openedCards - 2;
                firstCard = null;
                setOpeningCardsEnable(true);
            });
            timer.setRepeats(false);
            timer.start();
            setOpeningCardsEnable(false);
        } else {
            firstCard = null;
        }

        if (openedCards == cardsNumber) {
            GameFinishedListeners.onGameFinished();
        }
    }

    private void setOpeningCardsEnable(boolean openingCardsEnable) {
        for (Card card : cards) {
            card.setOpeningEnable(openingCardsEnable);
        }
    }

    public JLabel getTimerComponent() {
        return timerComponent;
    }
}
