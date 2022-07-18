package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {

    public Queen(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "Q";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position position = new Position(0, 0);

        // above
        position.setValues(this.position.getRow() - 1, this.position.getColumn());
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            matrix[position.getRow()][position.getColumn()] = true;
            position.setRow(position.getRow() - 1);
        }
        if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
            matrix[position.getRow()][position.getColumn()] = true;
        }

        // left
        position.setValues(this.position.getRow(), this.position.getColumn() - 1);
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            matrix[position.getRow()][position.getColumn()] = true;
            position.setColumn(position.getColumn() - 1);
        }
        if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
            matrix[position.getRow()][position.getColumn()] = true;
        }

        // right
        position.setValues(this.position.getRow(), this.position.getColumn() + 1);
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            matrix[position.getRow()][position.getColumn()] = true;
            position.setColumn(position.getColumn() + 1);
        }
        if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
            matrix[position.getRow()][position.getColumn()] = true;
        }

        // below
        position.setValues(this.position.getRow() + 1, this.position.getColumn());
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            matrix[position.getRow()][position.getColumn()] = true;
            position.setRow(position.getRow() + 1);
        }
        if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
            matrix[position.getRow()][position.getColumn()] = true;
        }

        // nw
        position.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            matrix[position.getRow()][position.getColumn()] = true;
            position.setValues(position.getRow() - 1, position.getColumn() - 1);
        }
        if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
            matrix[position.getRow()][position.getColumn()] = true;
        }

        // ne
        position.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            matrix[position.getRow()][position.getColumn()] = true;
            position.setValues(position.getRow() - 1, position.getColumn() + 1);
        }
        if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
            matrix[position.getRow()][position.getColumn()] = true;
        }

        // se
        position.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            matrix[position.getRow()][position.getColumn()] = true;
            position.setValues(position.getRow() + 1, position.getColumn() + 1);
        }
        if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
            matrix[position.getRow()][position.getColumn()] = true;
        }

        // sw
        position.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            matrix[position.getRow()][position.getColumn()] = true;
            position.setValues(position.getRow() + 1, position.getColumn() - 1);
        }
        if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
            matrix[position.getRow()][position.getColumn()] = true;
        }

        return matrix;
    }
}
