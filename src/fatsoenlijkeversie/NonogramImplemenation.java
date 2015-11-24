package fatsoenlijkeversie;

import model.BlockColour;

/*
 * This class is used to store the information of a nonogramm
 */
public class NonogramImplemenation {

    private int noOfRows;
    private int noOfCols;
    private BlockColour[][] grid;
    private int[][] rowNumbers;
    private int[][] columnNumbers;

    public static final int MAX_NO_OF_ROWS = 15;
    public static final int MAX_NO_OF_COLUMNS = 15;

    public NonogramImplemenation() {
        this.noOfRows = 0;
        this.noOfCols = 0;
        this.grid = new BlockColour[0][0];
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
    public NonogramImplemenation(int noOfRows, int noOfCols, BlockColour[][] grid,
                                 int[][] rowNumbers, int[][] columnNumbers) {
        this.noOfRows = noOfRows;
        this.noOfCols = noOfCols;
        this.grid = grid;
        this.rowNumbers = rowNumbers;
        this.columnNumbers = columnNumbers;
    }

    /**
     * Get the number of rows.
     *
     * @return noOfRows
     */
    public int getnoOfRows() {
        return noOfRows;
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
     * Get the number of columns
     *
     * @return noOfCols
     */
    public int getnoOfCols() {
        return noOfCols;
    }

    /**
     * Set the number of columns to the given value.
     *
     * @param noOfCols The new number of columns.
     */
    public void setnoOfCols(int noOfCols) {
        this.noOfCols = noOfCols;
    }

    public BlockColour[][] getGrid() {
        return grid;
    }

    public void setGrid(BlockColour[][] grid) {
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
}
