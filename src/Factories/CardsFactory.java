package Factories;

import Components.Game.Card;
import Repositories.ResourceRepository;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

public class CardsFactory {
    public static List<Card> createCardsPairs(int pairs) {
        Random random = new Random();
        List<Image> availableImages = new LinkedList<>(Arrays.asList(ResourceRepository.getAllCardsImages()));
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
        }

        Collections.shuffle(result);
        return result;
    }
}
