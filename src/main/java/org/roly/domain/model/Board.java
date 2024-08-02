package org.roly.domain.model;

import org.roly.domain.model.Cell.State;

public class Board {

    private int numberOfEmptyCells;
    private Cell[][] grid;

    public Board() {
        Cell[][] grid = {
            {new Cell(State.EMPTY), new Cell(State.EMPTY), new Cell(State.EMPTY)},
            {new Cell(State.EMPTY), new Cell(State.EMPTY), new Cell(State.EMPTY)},
            {new Cell(State.EMPTY), new Cell(State.EMPTY), new Cell(State.EMPTY)}
        };
        this.grid = grid;
        this.numberOfEmptyCells = 9;
    }

    public void addCell(Cell cell, String input) {
        grid[Integer.parseInt(input) / 10 - 1][Integer.parseInt(input) % 10 - 1] = cell;
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
                sb.append(cell);
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
