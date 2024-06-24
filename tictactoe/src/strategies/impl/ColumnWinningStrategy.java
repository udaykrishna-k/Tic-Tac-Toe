package strategies.impl;

import models.Board;
import models.Cell;
import models.CellStatus;
import models.Move;
import strategies.WinningStrategy;

public class ColumnWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWin(Board board, Move move) {
        Cell cell = move.getCell();
        int col = cell.getCol();
        // Iterating all the rows in the same column
        for(int i=0; i<board.getDimension(); i++){
            if (board.getCells().get(i).get(col).getCellStatus() == CellStatus.FREE ||
                    board.getCells().get(i).get(col).getPlayer() != cell.getPlayer()){
                return false;
            }
        }
        return true;
    }
}
