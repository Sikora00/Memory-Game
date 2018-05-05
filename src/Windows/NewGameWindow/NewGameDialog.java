package Windows.NewGameWindow;

import javax.swing.*;

class NewGameDialog {
    private JFrame frame;
    private String pairsInputValue;
    private boolean isClosed = false;

    NewGameDialog(JFrame frame) {
        this.pairsInputValue = JOptionPane.showInputDialog(frame, "Pick number of pairs");
        if(this.pairsInputValue == null) {
            isClosed = true;
        }
    }

    public int getPairs() {
        try {
            return convertStringInputAndValidate();
        } catch (IllegalArgumentException e) {
            new ValidationError(frame);
        }
        return 0;
    }

    public boolean isClosed() {
        return isClosed;
    }

    private int convertStringInputAndValidate() throws IllegalArgumentException {
        if (pairsInputValue != null && !pairsInputValue.isEmpty()) {
            try {
                int n = Integer.parseInt(pairsInputValue);
                if (n > 0 && n % 2 == 0) {
                    return n;
                }
            } catch (NumberFormatException e) {
            }
        }
        throw new IllegalArgumentException();
    }

}
