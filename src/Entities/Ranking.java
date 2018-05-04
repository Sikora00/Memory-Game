package Entities;

import Interfaces.Serializable;

import java.util.ArrayList;
import java.util.List;

public class Ranking implements Serializable<Ranking> {
    private List<Score> scores = new ArrayList<>();

    public void addScore(Score score) {
        this.scores.add(score);
    }

    public List<Score> getScores() {
        return scores;
    }

    public Object[][] toArray() {
        Object[][] result = new Object[scores.size()][];
        int i = 0;
        for (Score score : scores) {
            result[i] = score.toArray();
            i++;
        }

        return result;
    }
}
