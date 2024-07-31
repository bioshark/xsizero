package org.roly.domain.model;

import org.roly.domain.model.Cell.State;

public class Board {

    private Cell[][] grid;

    public Board(Cell[][] grid) {
        Cell[][] populatedGrid = new Cell[grid.length][grid.length];
        for (int i = 0; i < populatedGrid.length; i++) {
            for (int j = 0; j < populatedGrid.length; j++) {
                populatedGrid[i][j] = new Cell(State.EMPTY);
            }
        }
        this.grid = populatedGrid;
    }

    public Board() {
        Cell[][] grid = {
            {new Cell(State.EMPTY), new Cell(State.EMPTY), new Cell(State.EMPTY)},
            {new Cell(State.EMPTY), new Cell(State.EMPTY), new Cell(State.EMPTY)},
            {new Cell(State.EMPTY), new Cell(State.EMPTY), new Cell(State.EMPTY)}
        };
        this.grid = grid;
    }

    public void addCell(Cell cell, int line, int col) {
        grid[line - 1][col - 1] = cell;
    }

    @Override
    public String toString() {
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
        return sb.toString();
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
