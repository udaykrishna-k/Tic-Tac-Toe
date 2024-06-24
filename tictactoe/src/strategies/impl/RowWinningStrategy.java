package strategies.impl;

import models.Board;
import models.Cell;
import models.CellStatus;
import models.Move;
import strategies.WinningStrategy;

public class RowWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWin(Board board, Move move) {
        Cell cell = move.getCell();
        int row = cell.getRow();
        // Iterating all the columns in the same row
        for(int i=0; i<board.getDimension(); i++){
            if (board.getCells().get(row).get(i).getCellStatus() == CellStatus.FREE ||
                board.getCells().get(row).get(i).getPlayer() != cell.getPlayer()){
                return false;
            }
        }
        return true;
    }
}
