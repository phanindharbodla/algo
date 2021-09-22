package game.chess;

import game.chess.Player.PlayerType;

public abstract class Piece {
    PieceType pieceType;
    PlayerType playerType;

    public Piece(PlayerType t, PieceType pt) {
        this.playerType = t;
        this.pieceType = pt;
    }

    public abstract void Move();

    public enum PieceType {King, Queen, Rook, Bishop, Knight, Pawn, Null}
}
