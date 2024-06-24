package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Move {
    private Cell cell;

    public Move(int row, int col){
        this.cell = new Cell(row, col);
    }
}
