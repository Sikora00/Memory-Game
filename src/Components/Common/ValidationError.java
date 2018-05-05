package Components.Common;

import javax.swing.*;

public class ValidationError {
    public ValidationError(JFrame frame, String message) {
        JOptionPane.showMessageDialog(frame,
                message,
                "Validation Error",
                JOptionPane.ERROR_MESSAGE);
    }
}
