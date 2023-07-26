package tictactoe;

public enum GameState {
    IN_PROCESS("In process"),
    WIN("player wins"),
    DRAW("Draw");

    private final String text;

    GameState(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
