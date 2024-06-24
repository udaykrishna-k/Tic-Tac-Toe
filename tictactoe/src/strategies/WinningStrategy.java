package strategies;

import models.Board;
import models.Move;

public interface WinningStrategy {
    boolean checkWin(Board board, Move move);
}
