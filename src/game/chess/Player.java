package game.chess;

import java.util.Random;

public class Player {

    PlayerType colour;

    Board game;
    Random rand = new Random();

    public Player(Board game, PlayerType colour) {
        this.colour = colour;
        this.game = game;
    }

    public void move() {
        Object t = game.getCell(rand.nextInt(8), rand.nextInt(8));
        game.move(game.getCell(rand.nextInt(8), rand.nextInt(8)), game.getCell(rand.nextInt(8), rand.nextInt(8)));
        //make move
    }


    public enum PlayerType {Black, White}
}
