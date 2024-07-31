package org.roly.domain.service;

import java.util.Optional;
import org.roly.domain.model.Board;
import org.roly.domain.model.Cell;

public class GameService {

    public Optional<Cell> whoWon(Board board) {
        return isTheGameWonHorizontally(board);
    }

    private Optional<Cell> isTheGameWonHorizontally(Board board) {
        Cell currentCell;
        for (Cell[] row : board.getGrid()) {
            currentCell = row[0];
            for (Cell cell : row) {
                if (!cell.equals(currentCell)) {
                    currentCell = null;
                    break;
                }
            }
            if (currentCell != null) {
                return Optional.of(currentCell);
            }
        }
        return Optional.empty();
    }

    public Optional<Cell> determineWinner(Board board) {
        for (int i = 0; i < board.getGrid().length; i++) {
            Optional<Cell> possibleWinner = checkNeighbours(board, i);
            if (possibleWinner.isPresent()) {
                return possibleWinner;
            }
        }
        return Optional.empty();
    }

    private Optional<Cell> checkNeighbours(Board board, int position) {
        if (position == 0) {
            Cell cell = board.getGrid()[0][0];
            if ((cell.equals(board.getGrid()[0][1]) && cell.equals(board.getGrid()[0][2])) ||
                    (cell.equals(board.getGrid()[1][0]) && cell.equals(board.getGrid()[2][0])) ||
                    (cell.equals(board.getGrid()[1][1]) && cell.equals(board.getGrid()[2][2]))) {
                return Optional.of(cell);
            }
        } else if (position == 1) {
            Cell cell = board.getGrid()[1][1];
            if ((cell.equals(board.getGrid()[1][2]) && cell.equals(board.getGrid()[3][2])) ||
                    (cell.equals(board.getGrid()[1][0]) && cell.equals(board.getGrid()[1][2])) ||
                    (cell.equals(board.getGrid()[2][0]) && cell.equals(board.getGrid()[0][2]))) {
                return Optional.of(cell);
            }
        } else if (position == 2) {
            Cell cell = board.getGrid()[2][2];
            if ((cell.equals(board.getGrid()[2][0]) && cell.equals(board.getGrid()[2][1])) ||
                    (cell.equals(board.getGrid()[1][2]) && cell.equals(board.getGrid()[0][2]))) {
                return Optional.of(cell);
            }
        }
        return Optional.empty();
    }
}
