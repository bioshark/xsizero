package org.roly.domain.service;

import java.util.Optional;
import java.util.Scanner;
import org.roly.domain.model.Board;
import org.roly.domain.model.Cell;
import org.roly.domain.model.Player;

public class ManualGameService extends PlayableGame {

    @Override
    public void play() {
        Board board = new Board();
        initializePlayers();
        board.display();
        Player currentPlayer = getHomePlayer();
        Optional<Cell> possibleWinningCell = makeMove(currentPlayer, board);
        while (possibleWinningCell.isEmpty()) {
            currentPlayer = switchPlayer(currentPlayer);
            possibleWinningCell = makeMove(currentPlayer, board);
        }
        displayGameOutcome(possibleWinningCell, currentPlayer);
    }

    private Optional<Cell> makeMove(Player player, Board board) {
        String input = readInput(player);
        board.addCell(new Cell(player.symbol(), input));
        board.display();
        return determineWinner(board);
    }

    private String readInput(Player player) {
        System.out.print("Enter position (row, column) for " + player.name() + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
