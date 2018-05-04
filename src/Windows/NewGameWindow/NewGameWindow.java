package Windows.NewGameWindow;


import javax.swing.*;

public class NewGameWindow implements Runnable{
    JFrame frame;
    public NewGameWindow() {
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
            pairs = insertPairsDialog.getPairs();
        }

        frame.dispose();
    }

    public void run()
    {
        createAndShowGUI();
    }
}
