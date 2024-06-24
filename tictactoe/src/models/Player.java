package models;


import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public class Player {
    private int id;
    private String name;
    private char symbol;

    public Move makeMove() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the row and col you want to place on");
        int row = sc.nextInt();
        int col = sc.nextInt();
        Move move = new Move(row, col);
        move.getCell().setPlayer(this);
        return move;
    }
}
