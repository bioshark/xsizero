package org.roly.domain.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.roly.domain.model.Board;
import org.roly.domain.model.Cell;
import org.roly.domain.model.Cell.State;

class ManualGameServiceTest {

    private final ManualGameService service = new ManualGameService();

    @Test
    void shouldDetectWinnerHorizontally() {
        Board board = new Board();
        board.addCell(new Cell(State.X), "11");
        board.addCell(new Cell(State.X), "12");
        board.addCell(new Cell(State.X), "13");
        board.display();

        Optional<Cell> winnerCell = service.determineWinner(board);

        assertThat(winnerCell).isNotEmpty();
        assertThat(winnerCell.get()).isEqualTo(new Cell(State.X));
    }

    @Test
    void shouldDetectWinnerHorizontallyDown() {
        Board board = new Board();
        board.addCell(new Cell(State.X), "31");
        board.addCell(new Cell(State.X), "32");
        board.addCell(new Cell(State.X), "33");
        board.display();

        Optional<Cell> winnerCell = service.determineWinner(board);

        assertThat(winnerCell).isNotEmpty();
        assertThat(winnerCell.get()).isEqualTo(new Cell(State.X));
    }

    @Test
    void shouldDetectWinnerVertically() {
        Board board = new Board();
        board.addCell(new Cell(State.X), "11");
        board.addCell(new Cell(State.X), "21");
        board.addCell(new Cell(State.X), "31");
        board.display();

        Optional<Cell> winnerCell = service.determineWinner(board);

        assertThat(winnerCell).isNotEmpty().get().isEqualTo(new Cell(State.X));
    }

    @Test
    void shouldDetectWinnerVerticallyRight() {
        Board board = new Board();
        board.addCell(new Cell(State.X), "13");
        board.addCell(new Cell(State.X), "23");
        board.addCell(new Cell(State.X), "33");
        board.display();

        Optional<Cell> winnerCell = service.determineWinner(board);

        assertThat(winnerCell).isNotEmpty().get().isEqualTo(new Cell(State.X));
    }

    @Test
    void shouldDetectWinnerDiagonalLeft() {
        Board board = new Board();
        board.addCell(new Cell(State.O), "11");
        board.addCell(new Cell(State.O), "22");
        board.addCell(new Cell(State.O), "33");
        board.display();

        Optional<Cell> winnerCell = service.determineWinner(board);

        assertThat(winnerCell).isNotEmpty().get().isEqualTo(new Cell(State.O));
    }

    @Test
    void shouldDetectWinnerDiagonalRight() {
        Board board = new Board();
        board.addCell(new Cell(State.O), "13");
        board.addCell(new Cell(State.O), "22");
        board.addCell(new Cell(State.O), "31");
        board.display();

        Optional<Cell> winnerCell = service.determineWinner(board);

        assertThat(winnerCell).isNotEmpty().get().isEqualTo(new Cell(State.O));
    }

}