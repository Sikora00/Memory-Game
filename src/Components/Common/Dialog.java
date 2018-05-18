package Components.Common;

import javax.swing.*;

public abstract class Dialog {
    JFrame frame;
    public Dialog(JFrame frame) {
        this.setFrame(frame);
    }

    public Dialog(){}

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void open() {
        if(frame != null) {
            openMentionedDialog(frame);
        } else {
            JFrame tmpFrame = new JFrame();
            openMentionedDialog(tmpFrame);
            tmpFrame.dispose();
        }
    }

    abstract void openMentionedDialog(JFrame frame);
}
