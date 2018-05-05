package Components.NewGame;


import Components.Game.GameFrame;

import javax.swing.*;

public class NewGameFrame extends JFrame{
    private JFrame parent;
    public NewGameFrame(JFrame frame) {
        super("New Game");
        this.parent = frame;
        this.createAndShowGUI();
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private void createAndShowGUI() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        int pairs = 0;
        while (pairs == 0){
            NewGameDialog insertPairsDialog = new NewGameDialog(this);
            if(insertPairsDialog.isClosed()) {
                break;
            }
            pairs = insertPairsDialog.getPairs();
        }

        if(pairs != 0) {
            new GameFrame(pairs);
            this.parent.dispose();
        }

        dispose();
    }
}
