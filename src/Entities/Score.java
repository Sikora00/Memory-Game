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
}
