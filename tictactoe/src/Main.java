import controllers.GameController;
import models.Game;

public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        Game game = gameController.getGame();
        gameController.startGame();
    }
}