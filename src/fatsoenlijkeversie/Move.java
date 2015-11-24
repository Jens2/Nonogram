package fatsoenlijkeversie;

/**
 * Created by Rogier on 24-11-15
 */
public class Move {
    private int row;
    private int column;
    private Colour colour;

    public Move(int row, int column, Colour colour) {
        this.row = row;
        this.column = column;
        this.colour = colour;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }
}
