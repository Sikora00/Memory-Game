package Components.Common;

import javax.swing.*;

public class ErrorDialog extends Dialog{
    String message;
    public ErrorDialog(String message) {
        this.message = message;
    }

    @Override
    void openMentionedDialog(JFrame frame) {
        JOptionPane.showMessageDialog(frame,
                message,
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }
}
