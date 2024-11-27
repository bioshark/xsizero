package org.roly.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.roly.domain.model.Board;
import org.roly.domain.model.Cell;
import org.roly.domain.model.Player;

public class AutoGamePlayService extends PlayableGame {

    private final Random rand = new Random();

    @Override
    public void play() {
        Board board = new Board();
        initializePlayers();
        board.display();
        Player currentPlayer = getHomePlayer();
        Optional<Cell> possibleWinningCell = makeAutoMove(currentPlayer, board, getTimeout());
        while (possibleWinningCell.isEmpty()) {
            currentPlayer = switchPlayer(currentPlayer);
            possibleWinningCell = makeAutoMove(currentPlayer, board, getTimeout());
        }
        displayGameOutcome(possibleWinningCell, currentPlayer);
    }

    private Optional<Cell> makeAutoMove(Player player, Board board, long timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Cell randomEmptyCell = getRandomEmptyCell(board);
        board.addCell(new Cell(player.symbol(), randomEmptyCell.position()));
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
