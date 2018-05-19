package Repositories;

import Configs.Paths;
import Services.ExceptionHandler;
<<<<<<< HEAD
import Services.Serializer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ResourceRepository {
    public static Image getCardBackgroundImage() {
        try {
            return ImageIO.read(Serializer.class.getResourceAsStream("/img/card-background.jpg"));
        } catch (IOException e) {
            ExceptionHandler.handle(e);
        }

        return null;
    }

    public static File getAllCardImagesDir() {
        return new File(Serializer.class.getResource("/img/cards").getFile());
    }

    public static File[] getAllCardsFiles() {
        final File dir = ResourceRepository.getAllCardImagesDir();
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
