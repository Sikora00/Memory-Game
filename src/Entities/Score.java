package Entities;

import Interfaces.Serializable;

public class Score implements Serializable<Score>, Comparable<Score> {
    private User user;
    private int timeInSeconds;
    private int pairs;
    private int points;

    public Score(User user, int timeInSeconds, int pairs) {
        this.user = user;
        this.timeInSeconds = timeInSeconds;
        this.pairs = pairs;
        this.points = (int)(((float) pairs / (float)timeInSeconds) * 100);
    }

    public Object[] toArray() {
        Object[] result = {new Integer(points), user.getName(), new Integer(pairs), Integer.toString(timeInSeconds)};
        return result;
    }

    @Override
    public int compareTo(Score o) {
        return o.points - this.points;
    }
}
