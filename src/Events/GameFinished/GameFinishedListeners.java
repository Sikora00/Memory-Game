package Events.GameFinished;

import java.util.ArrayList;
import java.util.List;

public class GameFinishedListeners {
    private static List<GameFinishedListener> listeners = new ArrayList<GameFinishedListener>();

    public static void addListener(GameFinishedListener toAdd) {
        listeners.add(toAdd);
    }

    public static void onGameFinished() {

        for (GameFinishedListener listener : listeners) {
            listener.onGameFinished();
        }
        GameFinishedListeners.listeners.clear();
    }
}