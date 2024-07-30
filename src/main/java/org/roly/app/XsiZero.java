package org.roly.app;

import org.roly.domain.Cell;
import org.roly.domain.Cell.State;
import org.roly.domain.Grid;

public class XsiZero
{
    public static void main( String[] args ) {

        Grid grid = new Grid();
        System.out.println(grid);

        grid.addCell(new Cell(State.X), 1, 3);
        grid.addCell(new Cell(State.O), 3, 2);

        System.out.println(grid);
    }
}
