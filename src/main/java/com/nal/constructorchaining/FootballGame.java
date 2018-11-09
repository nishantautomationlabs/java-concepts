package com.nal.constructorchaining;

/**
 * Created by Nishant on 02-11-2018.
 */
public class FootballGame {

    private String homeTeam;
    private String awayTeam;
    private int currentYardLine;

    public FootballGame() {
        this("Bangalore","Chennai", 35);
    }

    public FootballGame(String awayTeam) {
        this("Bangalore", awayTeam, 35);
    }


    public FootballGame(String homeTeam, String awayTeam, int currentYardLine) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.currentYardLine = currentYardLine;
    }
}
