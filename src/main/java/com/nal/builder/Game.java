package com.nal.builder;

/**
 * Created by Nishant on 01-11-2018.
 */
public class Game {

    private String homeTeam;
    private String awayTeam;
    private int currentYardLine;
    private String weather;
    private String stadium;

    static final class GameBuilder {

        private String homeTeam;
        private String awayTeam;
        private int currentYardLine;
        private String weather;
        private String stadium;

        public GameBuilder homeTeam(String homeTeam) {
            this.homeTeam = homeTeam;
            return this;
        }

        public GameBuilder awayTeam(String awayTeam) {
            this.awayTeam = awayTeam;
            return this;
        }

        public GameBuilder currentYardLine(int currentYardLine) {
            this.currentYardLine = currentYardLine;
            return this;
        }

        public GameBuilder weather(String weather) {
            this.weather = weather;
            return this;
        }

        public GameBuilder stadium(String stadium) {
            this.stadium = stadium;
            return this;
        }

        public Game build()
        {
            if(homeTeam == null)
                throw new IllegalStateException("No Home Team");
            if(awayTeam == null)
                throw new IllegalStateException("No Away Team");
            if(currentYardLine == 0)
                throw new IllegalStateException("Current yardLine cannot be 0");
            if(weather == null)
                throw new IllegalStateException("No weather");
            if(stadium == null)
                throw new IllegalStateException("No stadium");
            return new Game(this);
        }
    }

    private Game(GameBuilder builder) //Private constructor, not accessible by using Game class directly
    {
        homeTeam = builder.homeTeam;
        awayTeam = builder.awayTeam;
        currentYardLine = builder.currentYardLine;
        weather = builder.weather;
        stadium = builder.stadium;
    }

    public void printGame()
    {
        System.out.println(homeTeam);
        System.out.println(awayTeam);
        System.out.println(currentYardLine);
        System.out.println(weather);
        System.out.println(stadium);
    }
}
