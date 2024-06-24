package strategies.impl;

import models.Board;
import models.CellStatus;
import models.Move;
import strategies.WinningStrategy;

public class AntiDiognalWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWin(Board board, Move move) {
        int i = 0, j = board.getDimension()-1;
        while(i < board.getDimension() && j >= 0){
            if (board.getCells().get(i).get(j).getCellStatus() == CellStatus.FREE ||
                    board.getCells().get(i).get(j).getPlayer() != move.getCell().getPlayer()){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
