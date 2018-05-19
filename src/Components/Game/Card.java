package Components.Game;

import Events.CardOpened.CardOpenedListeners;
import Repositories.ResourceRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Card extends JPanel {
    private int id;
    private Image image;
    private boolean isOpeningEnable = true;

    public Card(int id, Image image) {
        this.id = id;
        this.image = image;
        this.closeCard();
    }

    private void setBackGround(JLabel label) {
        Card.this.removeAll();
        Card.this.invalidate();
        Card.this.add(label);
        Card.this.revalidate();
        Card.this.repaint();
    }

    public int getId() {
        return id;
    }

    public void closeCard() {

        Image backGroundImage = ResourceRepository.getCardBackgroundImage();


        JLabel picLabel = new JLabel(new ImageIcon(backGroundImage));
        picLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                if(!isOpeningEnable) {
                    return;
                }
                Card.this.setBackGround(new JLabel(new ImageIcon(Card.this.image)));
                CardOpenedListeners.onCardOpened(Card.this);
            }
        });
        this.setBackGround(picLabel);
    }

    public void setOpeningEnable(boolean openingEnable) {
        isOpeningEnable = openingEnable;
    }
}
