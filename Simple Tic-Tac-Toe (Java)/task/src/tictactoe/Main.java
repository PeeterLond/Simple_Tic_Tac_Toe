package tictactoe;
import java.util.Scanner;

public class Main {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        GameService gameService = new GameService();
        Game game = gameService.createNewGame();
        gameService.playGame(game);
    }
}
