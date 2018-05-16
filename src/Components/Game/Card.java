package Components.Game;

import Configs.Paths;
import Events.CardOpened.CardOpenedListeners;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
        BufferedImage closedCardImage = null;
        try {
            closedCardImage = ImageIO.read(new File(Paths.PATH_TO_ROOT_AFTER_BUILD + "img/card-background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image backGroundImage = closedCardImage.getScaledInstance(200, 300, Image.SCALE_DEFAULT);


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
