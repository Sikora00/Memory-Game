package Events.CardOpened;

import Components.Game.Card;

import java.util.ArrayList;
import java.util.List;

public class CardOpenedListeners {
    private static List<CardOpenedListener> listeners = new ArrayList<CardOpenedListener>();

    public static void addListener(CardOpenedListener toAdd) {
        listeners.add(toAdd);
    }

    public static void onCardOpened(Card card) {

        for (CardOpenedListener listener : listeners)
            listener.onCardOpened(card);
    }
}