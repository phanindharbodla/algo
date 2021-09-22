package game.chess;

import game.chess.Player.PlayerType;

public class GameDemo {
    public static void main(String args[]) {
        Board game = new Board();
        Player white = new Player(game, PlayerType.White);
        Player black = new Player(game, PlayerType.Black);

        int n = 5;
        while (game.notEnded() && n-- != 0) {
            white.move();
            black.move();
        }
    }
}
