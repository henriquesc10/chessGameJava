package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position) {
        ChessPiece chessPiece = (ChessPiece) getBoard().piece(position);
        return chessPiece == null || chessPiece.getColor() != getColor();
    }

    private boolean testRookCastling(Position position) {
        ChessPiece chessPiece = (ChessPiece) getBoard().piece(position);
        return chessPiece != null && chessPiece instanceof Rook && chessPiece.getColor() == getColor() && chessPiece.getMoveCount() == 0;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        //above
        p.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }
        //below
        p.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }
        //left
        p.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }
        //right
        p.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }
        //nw
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }
        //ne
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }
        //sw
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }
        //se
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            matrix[p.getRow()][p.getColumn()] = true;
        }
        //special move castling
        if (getMoveCount() == 0 && !chessMatch.getCheck()) {
            // special move castling kingside rook
            Position positionCastlingKingside = new Position(position.getRow(), position.getColumn() + 3);
            if (testRookCastling(positionCastlingKingside)) {
                Position positionTest01 = new Position(position.getRow(), position.getColumn() + 1);
                Position positionTest02 = new Position(position.getRow(), position.getColumn() + 2);
                if (getBoard().piece(positionTest01) == null && getBoard().piece(positionTest02) == null) {
                    matrix[position.getRow()][position.getColumn() + 2] = true;
                }
            }
            // special move castling queenside rook
            Position positionCastlingQueenside = new Position(position.getRow(), position.getColumn() - 4);
            if (testRookCastling(positionCastlingQueenside)) {
                Position positionTest01 = new Position(position.getRow(), position.getColumn() - 1);
                Position positionTest02 = new Position(position.getRow(), position.getColumn() - 2);
                Position positionTest03 = new Position(position.getRow(), position.getColumn() - 3);
                if (getBoard().piece(positionTest01) == null && getBoard().piece(positionTest02) == null && getBoard().piece(positionTest03) == null) {
                    matrix[position.getRow()][position.getColumn() - 2] = true;
                }
            }
        }
        return matrix;
    }
}