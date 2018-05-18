package Repositories;

import Configs.Paths;
import Services.ExceptionHandler;
import Services.Serializer;

import javax.imageio.ImageIO;
import java.awt.*;
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
}
