package models;

import lombok.Getter;
import lombok.Setter;
import strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Game {
    private List<Player> players;
    private Board board;
    private int nextPlayerIdx;
    private GameStatus gameStatus;
    private List<WinningStrategy> winningStrategies;
    private Player WinningPlayer;

    public Game(Board board, List<WinningStrategy> winningStrategies){
        this.players = new ArrayList<>();
        this.gameStatus = GameStatus.START;
        this.nextPlayerIdx = 0;
        this.board = board;
        this.winningStrategies = winningStrategies;
    }
}
