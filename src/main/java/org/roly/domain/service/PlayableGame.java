package org.roly.domain.service;

import java.util.Optional;
import java.util.Scanner;
import org.roly.domain.model.Board;
import org.roly.domain.model.Cell;
import org.roly.domain.model.Cell.State;
import org.roly.domain.model.Player;

public abstract class PlayableGame {

    private Player homePlayer;
    private Player awayPlayer;
    private long timeout;

    public abstract void play();

    protected void initializePlayers() {
        System.out.print("Specify name for Player playing with X: ");
        Scanner scanner = new Scanner(System.in);
        homePlayer = new Player(scanner.nextLine(), State.X);
        System.out.print("Specify name for Player playing with 0: ");
        scanner = new Scanner(System.in);
        awayPlayer = new Player(scanner.nextLine(), State.O);
    }

    protected Optional<Cell> determineWinner(Board board) {
        for (int i = 0; i < board.getGrid().length; i++) {
            Optional<Cell> potentialWinningCell = checkNeighbours(board, i);
            if (potentialWinningCell.isPresent()) {
                return potentialWinningCell;
            }
        }
        return Optional.empty();
    }

    protected void displayGameOutcome(Optional<Cell> possibleWinner) {
        if (possibleWinner.isPresent()) {
            System.out.println("The Winner is " + possibleWinner.get());
        } else {
            System.out.println("No winner can be determined");
        }
    }

    protected void displayGameOutcome(Optional<Cell> possibleWinner, Player currentPlayer) {
        if (possibleWinner.isPresent()) {
            System.out.println("The Winner is " + currentPlayer.name() + " playing with " + currentPlayer.symbol());
        } else {
            System.out.println("No winner can be determined");
        }
    }


    protected Player switchPlayer(Player currentPlayer) {
        return switch (currentPlayer.symbol()) {
            case X -> awayPlayer;
            case O -> homePlayer;
            default -> currentPlayer;
        };
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

    public Player getHomePlayer() {
        return homePlayer;
    }

    public Player getAwayPlayer() {
        return awayPlayer;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }
}
