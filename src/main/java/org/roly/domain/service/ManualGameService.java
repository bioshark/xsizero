package org.roly.domain.service;

import java.util.Optional;
import java.util.Scanner;
import org.roly.domain.model.Board;
import org.roly.domain.model.Cell;
import org.roly.domain.model.Cell.State;

public class ManualGameService implements PlayableGame {

    @Override
    public void play() {
        Board board = new Board();
        board.display();
        Optional<Cell> possibleWinner;
        do {
            possibleWinner = makeMove(State.X, board);
            if (possibleWinner.isPresent()) {
                break;
            }
            possibleWinner = makeMove(State.O, board);
            if (possibleWinner.isPresent()) {
                break;
            }
        } while(possibleWinner.isPresent() || board.areCellsLeft());
        displayGameOutcome(possibleWinner);
    }

    private Optional<Cell> makeMove(State state, Board board) {
        String input = readInput(state);
        board.addCell(new Cell(state, input));
        board.display();
        return determineWinner(board);
    }

    private String readInput(State state) {
        System.out.print("Enter position (row, column) for " + state + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
