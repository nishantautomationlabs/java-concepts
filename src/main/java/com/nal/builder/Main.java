package com.nal.builder;

import static com.nal.builder.Game.*;

/**
 * Created by Nishant on 01-11-2018.
 */
public class Main {

    public static void main(String[] args)
    {
        GameBuilder builder = new GameBuilder();
         Game game = builder.homeTeam("Bangalore")
                    .awayTeam("Chennai")
                    .currentYardLine(35)
                    .weather("weather")
                    .stadium("stadium")
                    .build();

        game.printGame();

        System.out.println("End");

    }
}
