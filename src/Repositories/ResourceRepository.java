package Repositories;

import Configs.Paths;
import Services.ExceptionHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ResourceRepository {
    public static Image getCardBackgroundImage() {
        BufferedImage closedCardImage = null;
        try {
            closedCardImage = ImageIO.read(new File(Paths.PATH_TO_ROOT_AFTER_BUILD + "img/card-background.jpg"));
        } catch (IOException e) {
            ExceptionHandler.handle(e);
        }
        return closedCardImage.getScaledInstance(200, 300, Image.SCALE_DEFAULT);
    }


    public static File[] getAllCardsFiles() {
        final File dir = new File(Paths.CARDS_IMAGES_DIR);
        return dir.listFiles();
    }

    public static Image[] getAllCardsImages() {
        File[] files = ResourceRepository.getAllCardsFiles();
        Image[] result = new Image[files.length];
        int i = 0;
        for (File file : ResourceRepository.getAllCardsFiles()) {
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

    public static File getRankingStorage() {
        return  new File(Paths.PATH_TO_ROOT_AFTER_BUILD + "storage/ranking.txt");
    }
}
