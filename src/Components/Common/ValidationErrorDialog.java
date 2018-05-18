package Components.Common;

import javax.swing.*;

public class ValidationErrorDialog extends ErrorDialog {
    public ValidationErrorDialog(String message) {
        super(message);
    }

    @Override
    void openMentionedDialog(JFrame frame) {
        JOptionPane.showMessageDialog(frame,
                message,
                "Validation Error",
                JOptionPane.ERROR_MESSAGE);
    }
}
