package fatsoenlijkeversie;
import java.util.ArrayList;

import fatsoenlijkeversie.NonogramImplementation;

public class BruteForceSolver {
	public NonogramImplementation nonogram;
	
	public void initialize(String args[]) {
		nonogram = new NonogramImplementation(5, 5);
		this.testSolver(nonogram);
	}
	
	public void testSolver(NonogramImplementation nonogram) {
		int rows = nonogram.getRowAmount();
		ArrayList<int[]> numbers = new ArrayList<int[]>();
		for (int i = 0; i < rows; i++) {
			int[] numbersOfRow = nonogram.getRowNumbers(i);
			int totalOfRow = 0;
			for (int j = 0; j < numbersOfRow.length; j++) {
				totalOfRow = totalOfRow + numbersOfRow[j];
			}
			numbers.add(numbersOfRow);
			System.out.println("Row " + i + ": " + numbersOfRow);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
