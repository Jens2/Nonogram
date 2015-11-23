package controller;

import model.BlockColour;
import model.Nonogram;
import model.Solver;

/*
 * This class is used to interpret the data given by the FPGA and translate it to nonogram objects
 */
public class NonogramHandler {

	// Creates a nonogram object in the Solver class
	public static boolean createNonogramFromUserInput(int noOfRows, int noOfCols, int[][] rowNumbers, int[][]colNumbers) {
		boolean correctInput = true;
		int maxNoOfRowNo = ((noOfCols - 1) / (2)) + 1;
		int maxNoOfColNo = ((noOfRows - 1) / (2)) + 1;
		BlockColour[][] grid = new BlockColour[noOfRows][noOfCols];
		if (rowNumbers == null || colNumbers == null) {
			correctInput = false;
		} else if (noOfRows == rowNumbers.length && noOfCols == colNumbers.length) {
			for (int i = 0; i < rowNumbers.length; i++) {
				int rowSum = 0;
				if (maxNoOfRowNo >= rowNumbers[i].length) {
					for (int j = 0; j < rowNumbers[i].length; j++) {
						if (!(noOfCols >= rowNumbers[i][j])) {
							correctInput = false;
							break;
						}
						if (rowNumbers[i][j] > 0) {
							rowSum = rowSum + rowNumbers[i][j] + 1;
						}
					}
					rowSum = rowSum - 1;
					if (!(noOfCols >= rowSum)) {
						correctInput = false;
						break;
					}
					if (!correctInput) {
						break;
					}
				} else {
					correctInput = false;
					break;
				}
			}
			if (correctInput) {
				for (int i = 0; i < colNumbers.length; i++) {
					int colSum = 0;
					if (maxNoOfColNo >= colNumbers[i].length) {
						for (int j = 0; j < colNumbers[i].length; j++) {
							if (!(noOfRows >= colNumbers[i][j])) {
								System.out.println();
								correctInput = false;
								break;
							}
							if (colNumbers[i][j] > 0) {
								colSum = colSum + colNumbers[i][j] + 1;
							}
						}
						colSum = colSum - 1;
						if (!(noOfRows >= colSum)) {
							correctInput = false;
							break;
						}
						if (!correctInput) {
							break;
						}
					} else {
						correctInput = false;
						break;
					}
				}
			}
		} else {
			correctInput = false;
		}
		if (correctInput) {
			for (int i = 0; i < noOfRows; i++) {
				for (int j = 0; j < noOfCols; j++) {
					grid[i][j] = BlockColour.WHITE;
				}
			}
			Nonogram n = new Nonogram(noOfRows, noOfCols, grid, rowNumbers, colNumbers);
			Solver.setNonogram(n);
		}
		return correctInput;
	}
	
	public static void setGridInNonogram(BlockColour[][] grid) {
		Nonogram n = Solver.getNonogram();
		n.setGrid(grid);
		Solver.setNonogram(n);
	}
}
