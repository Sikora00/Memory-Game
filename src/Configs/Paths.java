package Configs;

import Services.Serializer;

import java.io.File;

public class Paths {
    public static File getCardBackgroundImage() {
        return new File(Serializer.class.getResource("/img/card-background.jpg").getFile());
    }
    public static final String PATH_TO_ROOT_AFTER_BUILD = "";
    public static final String CARD_BACKGROUND_IMAGE = Paths.PATH_TO_ROOT_AFTER_BUILD + "/img/card-background.jpg";
    public static final String CARDS_IMAGES_DIR = Paths.PATH_TO_ROOT_AFTER_BUILD + "img/cards/";
}
