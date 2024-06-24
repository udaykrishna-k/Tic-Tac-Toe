package strategies.impl;

import models.Board;
import models.Cell;
import models.CellStatus;
import models.Move;
import strategies.WinningStrategy;

public class DiognalWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWin(Board board, Move move) {
        int i = 0, j = 0;
        while(i < board.getDimension() && j < board.getDimension()){
            if (board.getCells().get(i).get(j).getCellStatus() == CellStatus.FREE ||
                    board.getCells().get(i).get(j).getPlayer() != move.getCell().getPlayer()){
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}
