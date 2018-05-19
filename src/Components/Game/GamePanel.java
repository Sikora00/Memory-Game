package Components.Game;

import Configs.Fonts;
import Events.CardOpened.CardOpenedListener;
import Events.CardOpened.CardOpenedListeners;
import Events.GameFinished.GameFinishedListener;
import Events.GameFinished.GameFinishedListeners;
import Factories.CardsFactory;
import ValueObjects.TimerValue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
        JPanel content = new JPanel(new BorderLayout());
        addTimerComponent(content);
        addCardsComponent(content);
        add(content);
    }

    private void addCardsComponent(JPanel panel) {
        final JPanel cards = new JPanel(new GridLayout(0, 6));

        this.cards = CardsFactory.createCardsPairs(cardsNumber / 2);
        for (Card card : this.cards) {
            this.addCard(card, cards);
        }
        panel.add(cards, BorderLayout.CENTER);
    }

    private void addTimerComponent(JPanel panel) {
        JLabel timerComponent = new JLabel(new TimerValue().toString(), SwingConstants.CENTER);
        timerComponent.setFont(new Font(Fonts.MAIN_FONT, Font.BOLD, 30));
        timerComponent.setBorder(new EmptyBorder(20, 0, 10, 0));

        this.timerComponent = timerComponent;

        createTimer(timerComponent);

        panel.add(timerComponent, BorderLayout.PAGE_START);
    }

    private void createTimer(JLabel timerComponent) {
        int delay = 1000;
        ActionListener taskPerformer = (ActionEvent evt) -> {
            TimerValue value = new TimerValue(timerComponent.getText());
            value.addOneSecond();
            timerComponent.setText(value.toString());

        };
        timer = new Timer(delay, taskPerformer);
        timer.start();
    }

    private void addCard(Card card, JPanel panel) {
        panel.add(card);
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
