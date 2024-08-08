package org.roly.domain.model;

import java.util.ArrayList;
import java.util.List;
import org.roly.domain.model.Cell.State;

public class Board {

    private int numberOfEmptyCells;
    private final Cell[][] grid;

    public Board() {
        this.grid = new Cell[][]{
            {new Cell(State.EMPTY, "11"), new Cell(State.EMPTY, "12"), new Cell(State.EMPTY, "13")},
            {new Cell(State.EMPTY, "21"), new Cell(State.EMPTY, "22"), new Cell(State.EMPTY, "23")},
            {new Cell(State.EMPTY, "31"), new Cell(State.EMPTY, "32"), new Cell(State.EMPTY, "33")}
        };
        this.numberOfEmptyCells = 9;
    }

    public void addCell(Cell cell) {
        grid[Integer.parseInt(cell.position()) / 10 - 1][Integer.parseInt(cell.position()) % 10 - 1] = cell;
        this.numberOfEmptyCells--;
    }

    public boolean areCellsLeft() {
        return numberOfEmptyCells > 0;
    }

    public void display() {
        StringBuilder sb = new StringBuilder();
        topLegend(sb, grid.length);
        int lineLegend = 1;
        for (Cell[] row : grid) {
            generateLineBorder(sb, grid.length);
            sb.append("\n");
            sb.append(lineLegend);
            sb.append(" ");
            for (Cell cell : row) {
                sb.append("| ");
                sb.append(cell.state().toString());
                sb.append(" ");
            }
            lineLegend++;
            sb.append("|\n");
        }
        generateLineBorder(sb, grid.length);
        System.out.println(sb);
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public List<Cell> getListOfEmptyCells() {
        List<Cell> result = new ArrayList<>();
        for (Cell[] row : grid) {
            for (Cell cell : row) {
                if (!cell.isOccupied()) {
                    result.add(cell);
                }
            }
        }
        return result;
    }

    private static void generateLineBorder(StringBuilder sb, int length) {
        sb.append("  +");
        for (int i = 0; i < length; i++) {
            sb.append("-".repeat(3)).append("+");
        }
    }

    private static void topLegend(StringBuilder sb, int length) {
        sb.append("    ");
        sb.append(1);
        for (int i = 2; i < length + 1; i++) {
            sb.append(" ".repeat(3)).append(i);
        }
        sb.append("\n");
    }
}
