package Windows.NewGameWindow;

import javax.swing.*;

public class ValidationError {
    ValidationError(JFrame frame) {
        JOptionPane.showMessageDialog(frame,
                "Enter the right even number ",
                "Validation Error",
                JOptionPane.ERROR_MESSAGE);
    }
}
