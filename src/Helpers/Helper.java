package Helpers;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Helper {
    public static void addColoredComponentToPanel(JComponent component, JPanel panel, Object options) {
        Random r = new Random();
        Color c=new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256),r.nextInt(256));
        component.setBackground(c);
        component.setBorder(BorderFactory.createLineBorder(Color.black));

        panel.add(component, options);
    }
}
