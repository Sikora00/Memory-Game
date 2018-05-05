package Components.Game;

import Configs.Paths;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Card extends JPanel {
    Card() {
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
                Card.this.removeAll();
                Card.this.invalidate();

                BufferedImage myPicture = null;
                try {
                    myPicture = ImageIO.read(new File(Paths.PATH_TO_ROOT_AFTER_BUILD + "img/cards/af9acfb1-cce2-4408-9f01-2ecd87117317.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Image backGroundImage = myPicture.getScaledInstance(200, 300, Image.SCALE_DEFAULT);
                JLabel picLabel = new JLabel(new ImageIcon(backGroundImage));
                Card.this.add(picLabel);
                Card.this.revalidate();
                Card.this.repaint();
            }
        });
    }
}
