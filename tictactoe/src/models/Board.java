package models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Board {
    private int dimension;
    private List<List<Cell>> cells;

    public Board(int dimension){
        this.dimension = dimension;
        this.cells = new ArrayList<>();
        for(int i=0; i<dimension; i++){
            List<Cell> temp = new ArrayList<>();
            for(int j=0; j<dimension; j++){
                temp.add(new Cell(i, j));
            }
            cells.add(temp);
        }
    }

    public void display(){
        for(int i=0; i<dimension; i++){
            for(int j=0; j<dimension; j++){
                Cell cell = cells.get(i).get(j);
                if (cell.getCellStatus() == CellStatus.FREE) System.out.print("|  |");
                else System.out.print("|" + cell.getPlayer().getSymbol() + "|");
            }
            System.out.println();
        }
    }
}
