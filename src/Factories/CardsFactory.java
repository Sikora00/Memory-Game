package Factories;

import Components.Game.Card;
import Configs.Paths;
import Repositories.ResourceRepository;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class CardsFactory {
    public static List<Card> createCardsPairs(int pairs) {
        Random random = new Random();
        List<Image> availableImages = new LinkedList<>(Arrays.asList(CardsFactory.getAllCardsImages()));
        List<Card> result = new ArrayList<Card>();

        for (int pairId = 1; pairId <= pairs; pairId++) {
            Image image;
            if (availableImages.size() > 0) {
                int index = random.nextInt(availableImages.size());
                image = availableImages.get(index);
                availableImages.remove(index);
            } else {
                BufferedImage bi = new BufferedImage(200, 300,
                        BufferedImage.TYPE_INT_ARGB);

                Graphics2D g2d = bi.createGraphics();
                g2d.setColor(new Color(random.nextFloat(), random.nextFloat(), random.nextFloat()));
                g2d.fillRect(0, 0, 200, 300);
                image = bi.getScaledInstance(200, 300, Image.SCALE_DEFAULT);
            }
            result.add(new Card(pairId, image));
            result.add(new Card(pairId, image));
            pairId++;
        }

        Collections.shuffle(result);
        return result;
    }


    private static Image[] getAllCardsImages() {
        File[] files = ResourceRepository.getAllCardsFiles();
        Image[] result = new Image[files.length];
        int i = 0;
        for (File file : files) {
            try {
                BufferedImage bufferedImage = ImageIO.read(file);
                Image image = bufferedImage.getScaledInstance(200, 300, Image.SCALE_DEFAULT);
                result[i] = image;
            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;
        }

        return result;
    }
}
