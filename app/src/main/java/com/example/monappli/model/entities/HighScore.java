package com.example.monappli.model.entities;

public class HighScore extends BaseEntity {
    private String playerName;
    private Integer score;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public HighScore(String playerName, Integer score) {
        this.playerName = playerName;
        this.score = score;
    }
}
