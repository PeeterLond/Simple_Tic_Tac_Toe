package tictactoe;

import java.lang.Math;

public class GameStateService {

    public void updateGameState(Game game) {
            if (validateIsWin(game)) {
                game.setResult(GameState.WIN.getText().replace("player", game.getWinner()));
                game.setGameState(GameState.WIN);
            } else if (validateIsDraw(game)) {
                game.setResult(GameState.DRAW.getText());
                game.setGameState(GameState.DRAW);
            } else {
                game.setResult(GameState.IN_PROCESS.getText());
            }
    }

    private static int countMarks(String[][] board, String mark) {
        int count = 0;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (mark.equals(board[row][col])) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean validateIsWin(Game game) {
        if (validateWinByRows(game)) {
            return true;
        } else if (validateWinByCol(game)) {
            return true;
        } else if (validateWinByDiagonal(game)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validateWinByRows(Game game) {
        boolean isWin = false;
        String[][] board = game.getBoard();
        for (String[] row : board) {
            if (isThreeInARow(row[0], row[1], row[2] )) {
                game.setWinner(row[0]);
                isWin = true;
            }
        }
        return isWin;
    }

    private boolean validateWinByCol(Game game) {
        boolean isWin = false;
        String[][] board = game.getBoard();
        for (int col = 0; col < board[0].length; col++) {
            if (isThreeInARow(board[0][col], board[1][col], board[2][col])) {
                game.setWinner(board[0][col]);
                isWin = true;
            }
        }
        return isWin;
    }

    private boolean validateWinByDiagonal(Game game) {
        return isDescendingDiagonal(game) || isAscendingDiagonal(game);
    }

    private boolean isDescendingDiagonal(Game game) {
        boolean isWin = false;
        String[][] board = game.getBoard();
        if (isThreeInARow(board[0][0], board[1][1], board[2][2])) {
            game.setWinner(board[0][0]);
            isWin = true;
        }
        return isWin;
    }

    private boolean isAscendingDiagonal(Game game) {
        boolean isWin = false;
        String[][] board = game.getBoard();
        if (isThreeInARow(board[2][0], board[1][1], board[0][2])) {
            game.setWinner(board[2][0]);
            isWin = true;
        }
        return isWin;
    }

    private boolean isThreeInARow(String a, String b, String c) {
        if (a.equals(Game.BLANK) || b.equals(Game.BLANK) || c.equals(Game.BLANK)) {
            return false;
        }
        return a.equals(b) && b.equals(c);
        }


    private boolean validateIsDraw(Game game) {
        int blankMarkNr = countMarks(game.getBoard(), Game.BLANK);
        return blankMarkNr == 0;
    }
}
