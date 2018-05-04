package Windows.NewGameWindow;

import javax.swing.*;

class NewGameDialog {
    JFrame frame;
    String pairsInputValue;
    NewGameDialog(JFrame frame) {
        this.pairsInputValue = JOptionPane.showInputDialog(frame, "Pick number of pairs");
    }

    public int getPairs() {
        try {
            return convertStringInputAndValidate();
        } catch (IllegalArgumentException e) {
            new ValidationError(frame);
        }
        return 0;
    }


    private int convertStringInputAndValidate() throws IllegalArgumentException {
        if(pairsInputValue != null && !pairsInputValue.isEmpty()) {
            try {
                int n = Integer.parseInt(pairsInputValue);
                if (n > 0 && n%2 == 0) {
                    return n;
                }
            } catch (NumberFormatException e) {
            }
        }
        throw new IllegalArgumentException();
    }

}
