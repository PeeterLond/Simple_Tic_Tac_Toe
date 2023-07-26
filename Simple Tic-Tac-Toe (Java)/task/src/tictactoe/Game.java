package tictactoe;


public class Game {

    public static final String PLAYER_X = "X";
    public static final String PLAYER_O = "O";
    public static final String BLANK = " ";
    private String winner;
    private String result;
    private GameState gameState = GameState.IN_PROCESS;
    private String[][] board = createBoard();

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    private String[][] createBoard() {
        return new String[][] {
                {" ", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "}
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------\n");
        for (int row = 0; row < board.length; row++) {
            sb.append("| " + board[row][0] + " " + board[row][1] + " " + board[row][2] + " |\n");
        }
        sb.append("---------\n");

        return sb.toString();
    }

    public void placeCellToBoard(String playerX, Cell cell) {
        board[cell.getRowIndex()][cell.getColIndex()] = playerX;
    }
}
