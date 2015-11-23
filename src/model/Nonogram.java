package model;

/*
 * This class is used to store the information of a nonogram
 */
public class Nonogram {

	private static int noOfRows;
	private static int noOfCols;
	private static BlockColour[][] grid;
	private static int[][] rowNumbers;
	private static int[][] columnNumbers;

	public static final int MAX_NO_OF_ROWS = 15;
	public static final int MAX_NO_OF_COLUMNS = 15;

	public Nonogram() {
		Nonogram.noOfRows = 0;
		Nonogram.noOfCols = 0;
		Nonogram.grid = new BlockColour[0][0];
		Nonogram.rowNumbers = new int[0][0];
		Nonogram.columnNumbers = new int[0][0];
	}

	/**
	 * Initialize a new Nonogram with the given parameters, assigning this to
	 * the variables.
	 * 
	 * @param noOfRows
	 *            The number of rows this Nonogram has.
	 * @param noOfCols
	 *            The number of columns this Nonogram has.
	 * @param grid
	 *            The grid of this Nonogram.
	 * @param rowNumbers
	 *            The numbers that indicate how much blocks have to be colored
	 *            in the given row.
	 * @param columnNumbers
	 *            The numbers that indicate how much blocks have to be colored
	 *            in the given row.
	 */
	public Nonogram(int noOfRows, int noOfCols, BlockColour[][] grid,
			int[][] rowNumbers, int[][] columnNumbers) {
		Nonogram.noOfRows = noOfRows;
		Nonogram.noOfCols = noOfCols;
		Nonogram.grid = grid;
		Nonogram.rowNumbers = rowNumbers;
		Nonogram.columnNumbers = columnNumbers;
	}

	/**
	 * Get the number of rows.
	 * @return noOfRows
	 */
	public int getnoOfRows() {
		return noOfRows;
	}

	/**
	 * Set the number of rows to the given value.
	 * @param noOfRows The new number of rows.
	 */
	public void setnoOfRows(int noOfRows) {
		Nonogram.noOfRows = noOfRows;
	}

	/**
	 * Get the number of columns
	 * @return noOfCols
	 */
	public int getnoOfCols() {
		return noOfCols;
	}

	/**
	 * Set the number of columns to the given value.
	 * @param noOfCols The new number of columns.
	 */
	public void setnoOfCols(int noOfCols) {
		Nonogram.noOfCols = noOfCols;
	}

	public BlockColour[][] getGrid() {
		return grid;
	}

	public void setGrid(BlockColour[][] grid) {
		Nonogram.grid = grid;
	}

	public int[][] getRowNumbers() {
		return rowNumbers;
	}

	public void setRowNumbers(int[][] rowNumbers) {
		Nonogram.rowNumbers = rowNumbers;
	}

	public int[][] getColumnNumbers() {
		return columnNumbers;
	}

	public void setColumnNumbers(int[][] columnNumbers) {
		Nonogram.columnNumbers = columnNumbers;
	}
}
