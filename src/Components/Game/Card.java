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
    public Card(int id, Image image) {
        this.id = id;
        this.image = image;
        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File(Paths.PATH_TO_ROOT_AFTER_BUILD + "img/card-background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image backGroundImage = myPicture.getScaledInstance(200, 300, Image.SCALE_DEFAULT);
        JLabel picLabel = new JLabel(new ImageIcon(backGroundImage));
        add(picLabel);
        picLabel.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent event)
            {
                Card.this.setBackGround(Card.this.image);
                CardOpenedListeners.onCardOpened(Card.this);
            }
        });
    }

    private void setBackGround(Image image) {
        Card.this.removeAll();
        Card.this.invalidate();
        JLabel picLabel = new JLabel(new ImageIcon(image));
        Card.this.add(picLabel);
        Card.this.revalidate();
        Card.this.repaint();    }
}
