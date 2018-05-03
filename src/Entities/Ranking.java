package Entities;

import Interfaces.Serializable;

import java.util.ArrayList;
import java.util.List;

public class Ranking implements Serializable<Ranking> {
    List<Score> scores = new ArrayList<>();

    public void addScore(Score score) {
        this.scores.add(score);
    }
}
