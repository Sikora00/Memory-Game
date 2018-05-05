package Windows.NewGameWindow;


import Windows.Game.GameWindow;

import javax.swing.*;

public class NewGameWindow implements Runnable{
    JFrame frame;
    JFrame parent;
    public NewGameWindow(JFrame frame) {
        this.parent = frame;
//        NewGameWindow.createAndShowGUI();
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("New Game");
        this.frame = frame;
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        int pairs = 0;
        while (pairs == 0){
            NewGameDialog insertPairsDialog = new NewGameDialog(frame);
            if(insertPairsDialog.isClosed()) {
                break;
            }
            pairs = insertPairsDialog.getPairs();
        }

        if(pairs != 0) {
            new GameWindow(pairs);
            this.parent.dispose();
        }

        frame.dispose();
    }

    public void run()
    {
        createAndShowGUI();
    }
}
