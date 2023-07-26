package tictactoe;

public class Cell {

    private int rowIndex;
    private int colIndex;

    public Cell(int row, int col) {
        this.rowIndex = row - 1;
        this.colIndex = col - 1;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public int getColIndex() {
        return colIndex;
    }

    public void setColIndex(int colIndex) {
        this.colIndex = colIndex;
    }
}
