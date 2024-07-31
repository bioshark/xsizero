package org.roly.domain.service;

import java.util.Optional;
import java.util.Scanner;
import org.roly.domain.model.Board;
import org.roly.domain.model.Cell;
import org.roly.domain.model.Cell.State;

public class GameService {

    public Optional<Cell> determineWinner(Board board) {
        for (int i = 0; i < board.getGrid().length; i++) {
            Optional<Cell> possibleWinner = checkNeighbours(board, i);
            if (possibleWinner.isPresent()) {
                return possibleWinner;
            }
        }
        return Optional.empty();
    }

    public void play() {
        Board board = new Board();
        System.out.println(board);
        Optional<Cell> possibleWinner = Optional.empty();
        while (determineWinner(board).isEmpty()) {
            String inputForX = readInput(State.X);
            board.addCell(new Cell(State.X), Integer.parseInt(inputForX) / 10, Integer.parseInt(inputForX) % 10);
            System.out.println(board);
            possibleWinner = determineWinner(board);
            if (possibleWinner.isPresent()) {
                break;
            }
            String inputForO = readInput(State.O);
            board.addCell(new Cell(State.O), Integer.parseInt(inputForO) / 10, Integer.parseInt(inputForO) % 10);
            System.out.println(board);
            possibleWinner = determineWinner(board);
            if (possibleWinner.isPresent()) {
                break;
            }
        }
        System.out.println(board);
        System.out.println("The Winner is " + possibleWinner.get());

    }

    private String readInput(State state) {
        System.out.print("Position for " + state);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private Optional<Cell> checkNeighbours(Board board, int position) {
        return switch (position) {
            case 0 -> evaluateTopLeftCell(board);
            case 1 -> evaluateCenterCell(board);
            case 2 -> evaluateBottomRight(board);
            default -> Optional.empty();
        };
    }

    private Optional<Cell> evaluateTopLeftCell(Board board) {
        Cell cell = board.getGrid()[0][0];
        if ((cell.equals(board.getGrid()[0][1]) && cell.equals(board.getGrid()[0][2])) ||
                (cell.equals(board.getGrid()[1][0]) && cell.equals(board.getGrid()[2][0])) ||
                (cell.equals(board.getGrid()[1][1]) && cell.equals(board.getGrid()[2][2]))) {
            return Optional.of(cell);
        }
        return Optional.empty();
    }

    private Optional<Cell> evaluateCenterCell(Board board) {
        Cell cell = board.getGrid()[1][1];
        if ((cell.equals(board.getGrid()[0][1]) && cell.equals(board.getGrid()[2][2])) ||
                (cell.equals(board.getGrid()[1][0]) && cell.equals(board.getGrid()[1][2])) ||
                (cell.equals(board.getGrid()[2][0]) && cell.equals(board.getGrid()[0][2]))) {
            return Optional.of(cell);
        }
        return Optional.empty();
    }

    private Optional<Cell> evaluateBottomRight(Board board) {
        Cell cell = board.getGrid()[2][2];
        if ((cell.equals(board.getGrid()[2][0]) && cell.equals(board.getGrid()[2][1])) ||
                (cell.equals(board.getGrid()[1][2]) && cell.equals(board.getGrid()[0][2]))) {
            return Optional.of(cell);
        }
        return Optional.empty();
    }


}
