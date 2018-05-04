package Entities;

import Interfaces.Serializable;

public class Score implements Serializable<Score> {
    private User user;
    private int timeInSeconds;
    private int pairs;

    public Score(User user, int timeInSeconds, int pairs) {
        this.user = user;
        this.timeInSeconds = timeInSeconds;
        this.pairs = pairs;
    }

    public Object[] toArray() {
        Object[] result = {new Integer(500), user.getName(), new Integer(pairs), Integer.toString(timeInSeconds)};
        return result;
    }
}
