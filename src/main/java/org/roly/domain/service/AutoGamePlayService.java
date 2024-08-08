package org.roly.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.roly.domain.model.Board;
import org.roly.domain.model.Cell;
import org.roly.domain.model.Cell.State;

public class AutoGamePlayService implements PlayableGame {

    private final Random rand = new Random();

    @Override
    public void play() {
        Board board = new Board();
        board.display();
        Optional<Cell> possibleWinner;
        do {
            possibleWinner = makeAutoMove(State.X, board);
            if (possibleWinner.isPresent()) {
                break;
            }
            possibleWinner = makeAutoMove(State.O, board);
            if (possibleWinner.isPresent()) {
                break;
            }
        } while(possibleWinner.isPresent() || board.areCellsLeft());
        displayGameOutcome(possibleWinner);
    }

    private Optional<Cell> makeAutoMove(State state, Board board) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("board.getListOfEmptyCells() = " + board.getListOfEmptyCells());
        Cell randomEmptyCell = getRandomEmptyCell(board);
        board.addCell(new Cell(state, randomEmptyCell.position()));
        board.display();
        return determineWinner(board);
    }

    private Cell getRandomEmptyCell(Board board) {
        List<Cell> availableCells = board.getListOfEmptyCells();
        if (availableCells.size() > 1) {
            int randomIndex = rand.nextInt(0, availableCells.size() - 1);
            return availableCells.get(randomIndex);
        }
        return availableCells.get(0);
    }

}
