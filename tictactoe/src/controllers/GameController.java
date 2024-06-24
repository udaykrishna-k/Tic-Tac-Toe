package controllers;

import Exceptions.IllegalMoveException;
import lombok.Getter;
import lombok.Setter;
import models.*;
import strategies.WinningStrategy;
import strategies.impl.AntiDiognalWinningStrategy;
import strategies.impl.ColumnWinningStrategy;
import strategies.impl.DiognalWinningStrategy;
import strategies.impl.RowWinningStrategy;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class GameController {
    private BoardController boardController;
    private Game game;
    public GameController(){
        System.out.println("Welcome to tictactoe !!!!");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the board");
        int dimension = sc.nextInt();
        System.out.println("Preparing the Board!!!");
        Board board = new Board(dimension);

        List<WinningStrategy> winningStrategies = List.of(new RowWinningStrategy(), new ColumnWinningStrategy(),
                new DiognalWinningStrategy(), new AntiDiognalWinningStrategy());
        Game game = new Game(board, winningStrategies);
        System.out.println("How many players are willing to play ?");
        int numberOfPlayers = sc.nextInt();
        for(int i=1; i<=numberOfPlayers; i++){
            System.out.println("enter the name of the player");
            String name = sc.next();
            System.out.println("select any symbol !!!");
            char symbol = sc.next().charAt(0);
            Player player = new Player();
            player.setId(i);
            player.setName(name);
            player.setSymbol(symbol);
            game.getPlayers().add(player);
        }
        this.game = game;
        this.boardController = new BoardController(board);
    }

    public void startGame(){
        game.setGameStatus(GameStatus.IN_PROGRESS);
        while(game.getGameStatus() == GameStatus.IN_PROGRESS){
            if (! boardController.checkEmptyCell()){
                game.setGameStatus(GameStatus.DRAW);
                break;
            }
            game.getBoard().display();
            Player curPlayer = game.getPlayers().get(game.getNextPlayerIdx());
            game.setNextPlayerIdx((game.getNextPlayerIdx() + 1) % game.getPlayers().size());
            System.out.println("Player " + curPlayer.getName() + " make your move !!");
            Move proposedMove = null;
            while(true) {
                proposedMove = curPlayer.makeMove();
                Cell cell = proposedMove.getCell();
                int row = cell.getRow();
                int col = cell.getCol();
                try {
                    boardController.validateMove(row, col);
                    boardController.occupyCell(row, col, curPlayer);
                    break;
                } catch (IllegalMoveException e) {
                    System.out.println("Please play inside the board and play on empty cells only...");
                }
            }

            for(int i=0; i<game.getWinningStrategies().size(); i++){
                WinningStrategy winningStrategy = game.getWinningStrategies().get(i);
                if (winningStrategy.checkWin(game.getBoard(), proposedMove)){
                    game.setGameStatus(GameStatus.COMPLETED);
                    game.setWinningPlayer(curPlayer);
                    break;
                }
            }

        }
        if (game.getWinningPlayer() != null){
            System.out.println("Player " + game.getWinningPlayer().getName() + " has won !!!");
        }
        else{
            System.out.println("Game ended in DRAW !!!");
        }
    }
}
