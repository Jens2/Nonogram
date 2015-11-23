package controller;

import javax.swing.JFormattedTextField;

import model.BlockColour;
import model.Nonogram;
import model.Solver;

/*
 * This class is used to handle the data
 */
public class DataHandler {
	
	public static int[][] jTextFieldToIntArray(JFormattedTextField[][] input, int noOfEntries, int maxSpec, boolean isCol) throws NumberFormatException {
		int[][] result = null;
		String s = null;
		if (!isCol) {
			if (input.length >= noOfEntries) {
				result = new int[noOfEntries][];
				for (int i = 0; i < noOfEntries; i++) {
					int[][] data = new int[noOfEntries][maxSpec];
					for (int j = 0; j < maxSpec; j++) {
						s = input[i][j].getText();
						if (s != null) {
							s = s.replaceAll("[^0-9]", "");
							if (s.equals("")) {
								data[i][j] = 0;
							} else {
								data[i][j] = Integer.parseInt(s);
							}
						} else {
							data[i][j] = 0;
						}
					}
					result[i] = data[i];
				}
			}
		} else {
			if (input.length >= maxSpec) {
				result = new int[noOfEntries][];
				for (int i = 0; i < noOfEntries; i++) {
					int[][] data = new int[noOfEntries][maxSpec];
					for (int j = 0; j < maxSpec; j++) {
						s = input[j][i].getText();
						if (s != null) {
							s = s.replaceAll("[^0-9]", "");
							if (s.equals("")) {
								data[i][j] = 0;
							} else {
								data[i][j] = Integer.parseInt(s);
							}
						} else {
							data[i][j] = 0;
						}
					}
					result[i] = data[i];
				}
			}
		}
		return result;
	}
	
	public static int[] integerBelow16To4BitArray(int input) {
		int[] result = new int[4];
		for (int i = 0; i < 4; i++) {
			result[4-i-1] = input & 0x1;
			input >>= 1;
		}
		return result;
	}

	// Method to extract the grid from the data and put it into the nonogram
	public static void setGridFromData(int[] bitArray) {
		Nonogram n = Solver.getNonogram();
		if (n != null && bitArray.length == n.getnoOfRows() * n.getnoOfCols()) {
			BlockColour[][] grid = new BlockColour[n.getnoOfRows()][n.getnoOfCols()];
			int arrayNumber = 0;
			for (int i = 0; i < n.getnoOfRows(); i++) {
				for (int j = 0; j < n.getnoOfCols(); j++) {
					if (bitArray[arrayNumber] == 0) {
						grid[i][j] = BlockColour.WHITE;
					} else {
						grid[i][j] = BlockColour.BLACK;
					}
					arrayNumber++;
				}
			}
			NonogramHandler.setGridInNonogram(grid);
		}
	}
}
