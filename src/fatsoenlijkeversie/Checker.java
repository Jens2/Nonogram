package fatsoenlijkeversie;

public class Checker {

	/*
	 * Created by Jens on 26-11-15
	 * This class is used to check whether the colour grid stored in the nonogram is correct.
	 */
	private NonogramImplementation nonogram;
	
	public Checker(NonogramImplementation nonogram){
		this.nonogram = nonogram;
	}
	
	public static void main(String[] args) {
		Colour[][] grid = { {Colour.BLACK, Colour.BLACK, Colour.BLACK, Colour.BLACK, Colour.BLACK}, 
							{Colour.BLACK, Colour.WHITE, Colour.BLACK, Colour.WHITE, Colour.BLACK}, 
							{Colour.WHITE, Colour.WHITE, Colour.WHITE, Colour.WHITE, Colour.WHITE}, 
							{Colour.BLACK, Colour.BLACK, Colour.BLACK, Colour.WHITE, Colour.BLACK}, 
							{Colour.WHITE, Colour.BLACK, Colour.BLACK, Colour.WHITE, Colour.WHITE},
							{Colour.WHITE, Colour.WHITE, Colour.BLACK, Colour.WHITE, Colour.BLACK},
							{Colour.BLACK, Colour.WHITE, Colour.BLACK, Colour.WHITE, Colour.BLACK},
							{Colour.WHITE, Colour.BLACK, Colour.BLACK, Colour.BLACK, Colour.BLACK}};
		int[][] rowNumbers = {{5}, {1,1,1}, {0}, {3,1}, {2}, {1,1}, {1,1,1}, {4}};
		int[][] columnNumbers = {{2,1,1}, {1,2,1}, {2,5}, {1,1}, {2,1,3}};
		NonogramImplementation n = new NonogramImplementation(8, 5, grid, rowNumbers, columnNumbers);
		Checker c = new Checker(n);
		
		System.out.println("Checking Solution...");
		if (c.checkSolution()) {
			System.out.println("Solution is correct");
		} else {
			System.out.println("Solution is not correct");
		}
	}
	
	public boolean checkSolution(){
		boolean correct = true;
		if (!rowCheck()) {
			correct = false;
		} else if (!columnCheck()) {
			correct = false;
		}
		return correct;
	}
	
	public boolean rowCheck(){
		boolean result = true;
		int[][] rowNumbers = nonogram.getRowNumbers();
		Colour[][] grid = nonogram.getGrid();
		int[] noOfBlackFields = getNumberOfBlackFieldsRow(grid);
		
		for (int i = 0; i < rowNumbers.length; i++) {
			int total = 0;
			for (int j = 0; j < rowNumbers[i].length; j++) {
				total = total + rowNumbers[i][j];
			}
			if (noOfBlackFields[i] != total) {
				result = false;
				break;
			}
		}
		if (result) {
			result = deepRowCheck(grid, rowNumbers);
		}
		return result;
	}
	
	public boolean columnCheck(){
		boolean result = true;
		int[][] colNumbers = nonogram.getColumnNumbers();
		Colour[][] grid = nonogram.getGrid();
		int[] noOfBlackFields = getNumberOfBlackFieldsColumn(grid, nonogram.getColumnAmount());
		
		for (int i = 0; i < colNumbers.length; i++) {
			int total = 0;
			for (int j = 0; j < colNumbers[i].length; j++) {
				total = total + colNumbers[i][j];
			}
			if (noOfBlackFields[i] != total) {
				result = false;
				break;
			}
		}
		if (result) {
			result = deepColumnCheck(grid, colNumbers, nonogram.getRowAmount());
		}		
		return result;
	}
	
	private int[] getNumberOfBlackFieldsRow(Colour[][] grid) {
		int[] result = new int[grid.length];
			for (int i = 0; i < grid.length; i++) {
				int noOfBlackFields = 0;
				for (int j = 0; j < grid[i].length; j++) {
					if (grid[i][j] == Colour.BLACK) {
						noOfBlackFields++;
					}
				}
				result[i] = noOfBlackFields;
			}
		return result;
	}
	
	private int[] getNumberOfBlackFieldsColumn(Colour[][] grid, int columnAmount) {
		int[] result = new int[columnAmount];
			for (int i = 0; i < columnAmount; i++) {
				int noOfBlackFields = 0;
				for (int j = 0; j < grid.length; j++) {
					if (grid[j][i] == Colour.BLACK) {
						noOfBlackFields++;
					}
				}
				result[i] = noOfBlackFields;
			}
		return result;
	}
	
	private boolean deepRowCheck(Colour[][] grid, int[][] rowNumbers) {
		boolean result = true;
		/*
		 * Iterate through all rows
		 */
		firstLoop:
		for (int i = 0; i < rowNumbers.length; i++) {
			int indexOfRow = 0;
			/*
			 * Iterate through all row number specifiers
			 */
			for (int j = 0; j < rowNumbers[i].length; j++) {
				int count = rowNumbers[i][j];
				/*
				 * Iterate through the solution whilst remembering the last checked index
				 */
				for (int k = indexOfRow; k < grid[i].length; k++, indexOfRow++) {
					if (grid[i][k] == Colour.WHITE) {
						if (count != 0 && count != rowNumbers[i][j]) {
							result = false;
							break firstLoop;
						} else if (count == 0) {
							// Correct
							break;
						}
					} else {
						count--;
						if (count < 0) {
							return false;
						}
					}
				}
				if (count != 0) {
					result = false;
					break firstLoop;
				}
			}
		}
		return result;
	}
	
	private boolean deepColumnCheck(Colour[][] grid, int[][] colNumbers, int columnAmount) {
		boolean result = true;
		/*
		 * Iterate through all columns
		 */
		firstLoop:
		for (int i = 0; i < colNumbers.length; i++) {
			int indexOfCol = 0;
			/*
			 * Iterate through all column number specifiers
			 */
			for (int j = 0; j < colNumbers[i].length; j++) {
				int count = colNumbers[i][j];
				/*
				 * Iterate through the solution whilst remembering the last checked index
				 */
				for (int k = indexOfCol; k < columnAmount; k++, indexOfCol++) {
					if (grid[k][i] == Colour.WHITE) {
						if (count != 0 && count != colNumbers[i][j]) {
							result = false;
							break firstLoop;
						} else if (count == 0) {
							// Correct
							break;
						}
					} else {
						count--;
						if (count < 0) {
							result = false;
							break firstLoop;
						}
					}
				}
				if (count != 0) {
					result = false;
					break firstLoop;
				}
			}
		}
		return result;
	}
	
	public Nonogram getNonogram() {
		return nonogram;
	}
	
	public void setNonogram(NonogramImplementation nonogram) {
		this.nonogram = nonogram;
	}
	
}
