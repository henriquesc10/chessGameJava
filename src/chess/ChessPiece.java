package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {

    private Color color;
    private int moveCount;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public Color getColor() {
        return color;
    }

    public void increasedMoveCount() {
        moveCount++;
    }

    public void decreasedMoveCount() {
        moveCount--;
    }

    public ChessPosition getChessPosition() {
        return ChessPosition.fromPosition(position);
    }

    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece chessPiece = (ChessPiece) getBoard().piece(position);
        return chessPiece != null && chessPiece.getColor() != color;
    }
}
