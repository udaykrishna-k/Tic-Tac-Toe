package controllers;

import Exceptions.IllegalMoveException;
import models.Board;
import models.Cell;
import models.CellStatus;
import models.Player;

public class BoardController {
    private Board board;

    public BoardController(Board board){
        this.board = board;
    }
    public void occupyCell(int row, int col, Player curPlayer) {
        Cell cell = board.getCells().get(row).get(col);
        cell.setPlayer(curPlayer);
        cell.setCellStatus(CellStatus.OCCUPIED);
    }

    public boolean checkEmptyCell() {
        for(int i=0; i<board.getDimension(); i++){
            for(int j=0; j< board.getDimension(); j++){
                if (board.getCells().get(i).get(j).getCellStatus() == CellStatus.FREE){
                    return true;
                }
            }
        }
        return false;
    }

    public void validateMove(int row, int col) throws IllegalMoveException {
        if (row < 0 || row > board.getDimension() || col < 0 || col > board.getDimension() ||
                board.getCells().get(row).get(col).getCellStatus() == CellStatus.OCCUPIED){
            throw new IllegalMoveException("Your move is out of bounds of board or the cell is already occupied");
        }
    }
}
