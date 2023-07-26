package tictactoe;

import static tictactoe.Main.SCANNER;

public class GameService {
    public Game createNewGame() {
        return new Game();
    }

    public void playGame(Game game) {
        GameStateService gameStateService = new GameStateService();
        System.out.println(game);
        String player = Game.PLAYER_X;
        while (GameState.IN_PROCESS.equals(game.getGameState())) {
            Cell cell = getCellFromInput(game);
            game.placeCellToBoard(player, cell);
            gameStateService.updateGameState(game);
            System.out.println(game);
            player = getSwappedPlayer(player);
        }
        System.out.println(game.getResult());
    }

    private String getSwappedPlayer(String player) {
        return Game.PLAYER_X.equals(player) ? Game.PLAYER_O : Game.PLAYER_X;
    }

    private Cell getCellFromInput(Game game) {
        while (true) {
            try {
                String input = SCANNER.nextLine();
                String[] splitArray = input.split(" ");
                int row = Integer.parseInt(splitArray[0]);
                int col = Integer.parseInt(splitArray[1]);
                validateRowAndColumnBoundaries(row,col);
                Cell cell = new Cell(row, col);
                validateCellAvailability(cell, game);
                return cell;
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateRowAndColumnBoundaries(int row, int col) throws Exception {
        if (row < 1 || row > 3 || col < 1 || col > 3) {
            throw new Exception("Coordinates should be from 1 to 3!");
        }
    }

    private void validateCellAvailability(Cell cell, Game game) throws Exception {
        String[][] board = game.getBoard();
        String playerMark = board[cell.getRowIndex()][cell.getColIndex()];
        if (!Game.BLANK.equals(playerMark)) {
            throw new Exception("This cell is occupied! Choose another one!");
        }
    }
}
