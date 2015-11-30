package fatsoenlijkeversie;

import java.util.Observable;

/*
 * This class is used to store the information of a nonogramm
 */
public class NonogramImplementation extends Observable implements Nonogram {

    private int noOfRows;
    private int noOfCols;
    private Colour[][] grid;
    private int[][] rowNumbers;
    private int[][] columnNumbers;

    /*
     * Deze limitaties hadden te maken met de FPGA en de limieten van het protocol wat daarvoor was geschreven
     * public static final int MAX_NO_OF_ROWS = 15;
     * public static final int MAX_NO_OF_COLUMNS = 15;
     */

    public NonogramImplementation(int noOfRows, int noOfCols) {
        this.noOfRows = noOfRows;
        this.noOfCols = noOfCols;
        this.grid = new Colour[noOfRows][noOfCols];
        this.rowNumbers = new int[0][0];
        this.columnNumbers = new int[0][0];
    }

    /**
     * Initialize a new Nonogram with the given parameters, assigning this to
     * the variables.
     *
     * @param noOfRows      The number of rows this Nonogram has.
     * @param noOfCols      The number of columns this Nonogram has.
     * @param grid          The grid of this Nonogram.
     * @param rowNumbers    The numbers that indicate how much blocks have to be colored
     *                      in the given row.
     * @param columnNumbers The numbers that indicate how much blocks have to be colored
     *                      in the given row.
     */
    public NonogramImplementation(int noOfRows, int noOfCols, Colour[][] grid,
                                 int[][] rowNumbers, int[][] columnNumbers) {
        this.noOfRows = noOfRows;
        this.noOfCols = noOfCols;
        this.grid = grid;
        this.rowNumbers = rowNumbers;
        this.columnNumbers = columnNumbers;
    }

    @Override
    public void initializeGrid() {
        for (int i = 0; i < noOfRows; i++) {
            for (int j = 0; j < noOfCols; j++) {
                this.grid[i][j] = Colour.EMPTY;
            }
        }
        this.setChanged();
        this.notifyObservers(grid);
    }

    /**
     * Set the number of rows to the given value.
     *
     * @param noOfRows The new number of rows.
     */
    public void setnoOfRows(int noOfRows) {
        this.noOfRows = noOfRows;
    }

    /**
     * Set the number of columns to the given value.
     *
     * @param noOfCols The new number of columns.
     */
    public void setnoOfCols(int noOfCols) {
        this.noOfCols = noOfCols;
    }

    public Colour[][] getGrid() {
        return grid;
    }

    public void setGrid(Colour[][] grid) {
        this.grid = grid;
    }

    public int[][] getRowNumbers() {
        return rowNumbers;
    }

    public void setRowNumbers(int[][] rowNumbers) {
        this.rowNumbers = rowNumbers;
    }

    public int[][] getColumnNumbers() {
        return columnNumbers;
    }

    public void setColumnNumbers(int[][] columnNumbers) {
        this.columnNumbers = columnNumbers;
    }

    @Override
    public int getRowAmount() {
        return this.noOfRows;
    }

    @Override
    public int getColumnAmount() {
        return this.noOfCols;
    }

    @Override
    public Colour getColor(int row, int column) {
        Colour result = null;
        if (this.grid.length > row && this.grid[row].length > column) {
            result = this.grid[row][column];
        }
        return result;
    }

    @Override
    public int[] getRowNumbers(int row) {
        return this.rowNumbers.length > row ? this.rowNumbers[row] : null;
    }

    @Override
    public int[] getColumnNumbers(int column) {
        return this.columnNumbers.length > column ? this.columnNumbers[column] : null;
    }

	@Override
	public boolean gameover() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
    public void move(Move value) {
        this.grid[value.getRow()][value.getColumn()] = value.getColour();
        this.setChanged();
        this.notifyObservers(grid);
    }


}
