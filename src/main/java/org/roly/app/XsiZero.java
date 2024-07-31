package org.roly.app;

import java.util.Optional;
import org.roly.domain.Cell;
import org.roly.domain.Cell.State;
import org.roly.domain.Board;
import org.roly.domain.service.GameService;

public class XsiZero
{
    public static void main( String[] args ) {

        Board board = new Board();
        GameService service = new GameService();

        System.out.println(board);

        board.addCell(new Cell(State.X), 1, 3);
        board.addCell(new Cell(State.O), 3, 2);

        System.out.println(board);

        Optional<Cell> winneer = service.whoWon(board);
        if (winneer.isPresent() && !winneer.get().equals(new Cell(State.EMPTY))) {
            System.out.println("The winner is " + winneer.get().state());
        } else {
            System.out.println("There is no winner yet, keep playing!");
        }
    }
}
