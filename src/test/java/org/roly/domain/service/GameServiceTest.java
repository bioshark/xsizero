package org.roly.domain.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.roly.domain.model.Board;
import org.roly.domain.model.Cell;
import org.roly.domain.model.Cell.State;

class GameServiceTest {

    private final GameService gameService = new GameService();

    @Test
    void shouldDetectWinnerHorizontally() {
        Board board = new Board();
        board.addCell(new Cell(State.X), 1, 1);
        board.addCell(new Cell(State.X), 1, 2);
        board.addCell(new Cell(State.X), 1, 3);
        System.out.println(board);

        Optional<Cell> winnerCell = gameService.determineWinner(board);

        assertThat(winnerCell).isNotEmpty();
        assertThat(winnerCell.get()).isEqualTo(new Cell(State.X));
    }

    @Test
    void shouldDetectWinnerHorizontallyDown() {
        Board board = new Board();
        board.addCell(new Cell(State.X), 3, 1);
        board.addCell(new Cell(State.X), 3, 2);
        board.addCell(new Cell(State.X), 3, 3);
        System.out.println(board);

        Optional<Cell> winnerCell = gameService.determineWinner(board);

        assertThat(winnerCell).isNotEmpty();
        assertThat(winnerCell.get()).isEqualTo(new Cell(State.X));
    }

    @Test
    void shouldDetectWinnerVertically() {
        Board board = new Board();
        board.addCell(new Cell(State.X), 1, 1);
        board.addCell(new Cell(State.X), 2, 1);
        board.addCell(new Cell(State.X), 3, 1);
        System.out.println(board);

        Optional<Cell> winnerCell = gameService.determineWinner(board);

        assertThat(winnerCell).isNotEmpty();
        assertThat(winnerCell.get()).isEqualTo(new Cell(State.X));
    }

    @Test
    void shouldDetectWinnerVerticallyRight() {
        Board board = new Board();
        board.addCell(new Cell(State.X), 1, 3);
        board.addCell(new Cell(State.X), 2, 3);
        board.addCell(new Cell(State.X), 3, 3);
        System.out.println(board);

        Optional<Cell> winnerCell = gameService.determineWinner(board);

        assertThat(winnerCell).isNotEmpty();
        assertThat(winnerCell.get()).isEqualTo(new Cell(State.X));
    }

    @Test
    void shouldDetectWinnerDiagonalLeft() {
        Board board = new Board();
        board.addCell(new Cell(State.O), 1, 1);
        board.addCell(new Cell(State.O), 2, 2);
        board.addCell(new Cell(State.O), 3, 3);
        System.out.println(board);

        Optional<Cell> winnerCell = gameService.determineWinner(board);

        assertThat(winnerCell).isNotEmpty();
        assertThat(winnerCell.get()).isEqualTo(new Cell(State.O));
    }

    @Test
    void shouldDetectWinnerDiagonalRight() {
        Board board = new Board();
        board.addCell(new Cell(State.O), 1, 3);
        board.addCell(new Cell(State.O), 2, 2);
        board.addCell(new Cell(State.O), 3, 1);
        System.out.println(board);

        Optional<Cell> winnerCell = gameService.determineWinner(board);

        assertThat(winnerCell).isNotEmpty();
        assertThat(winnerCell.get()).isEqualTo(new Cell(State.O));
    }

}