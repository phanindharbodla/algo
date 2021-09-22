package game.chess;

public class Board {

    private boolean isRunning = true;
    private Square[][] cells = new Square[8][8];

    public Board() {
        // set default piece positions for white and black
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                cells[i][j] = new Square(((i + j) % 2 == 0) ? Square.SquareType.Black : Square.SquareType.White, i, j);
        for (int i = 0; i < 8; i++) { // draw pawns
            cells[i][1].UpdatePiece(new Pawn(Player.PlayerType.White));
            cells[i][6].UpdatePiece(new Pawn(Player.PlayerType.Black));
        }
        cells[0][0].UpdatePiece(new Rook(Player.PlayerType.White));
        cells[7][0].UpdatePiece(new Rook(Player.PlayerType.White));
        cells[2][0].UpdatePiece(new Bishop(Player.PlayerType.White));
        cells[5][0].UpdatePiece(new Bishop(Player.PlayerType.White));
        cells[1][0].UpdatePiece(new Knight(Player.PlayerType.White));
        cells[6][0].UpdatePiece(new Knight(Player.PlayerType.White));
        cells[3][0].UpdatePiece(new Queen(Player.PlayerType.White));
        cells[4][0].UpdatePiece(new King(Player.PlayerType.White));

        cells[0][7].UpdatePiece(new Rook(Player.PlayerType.Black));
        cells[7][7].UpdatePiece(new Rook(Player.PlayerType.Black));
        cells[2][7].UpdatePiece(new Bishop(Player.PlayerType.Black));
        cells[5][7].UpdatePiece(new Bishop(Player.PlayerType.Black));
        cells[1][7].UpdatePiece(new Knight(Player.PlayerType.Black));
        cells[6][7].UpdatePiece(new Knight(Player.PlayerType.Black));
        cells[3][7].UpdatePiece(new Queen(Player.PlayerType.Black));
        cells[4][7].UpdatePiece(new King(Player.PlayerType.Black));


    }

    public boolean notEnded() {
        return isRunning;
    }

    public void move(Square from, Square to) {
        System.out.println();
        System.out.println("Move " + from.toString() + " to " + to.toString());
    }

    public Square getCell(int a, int b) {
        return cells[a][b];
    }
}
