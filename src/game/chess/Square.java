package game.chess;

public class Square {
    public SquareType squareType;
    private Piece piece;
    private int X;
    private int Y;

    public Square(SquareType t, int x, int y) {
        this.squareType = t;
        this.X = x;
        this.Y = y;
    }

    public void UpdatePiece(Piece piece) {
        this.piece = piece;
    }

    @Override
    public String toString() {
        return X + " " + Y;
    }

    public enum SquareType {Black, White}
}
