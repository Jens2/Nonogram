package model;

//import org.apache.commons.lang.ArrayUtils;
//
//import controller.DataHandler;
//import controller.NonogramHandler;
//import controller.PinsConnection;


/* 
 * This class is used to run the nonogram solver program
 */
public final class Solver {
	
	private static Nonogram nono;

	private Solver() {
		nono = new Nonogram();
	}
	public static Nonogram getNonogram() {
		return nono;
	}
	
	public static void setNonogram(Nonogram nono) {
		Solver.nono = nono;
	}
	
	public static void main(String[] args) throws InterruptedException {
//		System.out.println("Starting test...");
//		int noOfRows = 10;
//		int noOfCols = 15;
//		int[][] row = {{5},{4},{7,7},{6},{8,1},{1,1,1,3,4},{0},{0},{0},{0}};
//		int[][] col = {{1,3},{2},{1,1,1,1,1},{9},{1},{1,1,1,1,1},{9},{1},{1,1,1,1,1},{9},{1},{1,1,1,1,1},{9},{1},{6,2}};
//		if (NonogramHandler.createNonogramFromUserInput(noOfRows, noOfCols, row, col)) {
//			DataHandler.createAndSendSizeOfNono();
//			DataHandler.sendSpecificationsOfNono();
//		}
//		int gridSize = noOfCols * noOfRows;
//		int[] grid = DataHandler.getGrid(gridSize);
//		System.out.println("\n");
//		DataHandler.setGridFromData(grid);
//		for (int i = 0; i < Solver.getNonogram().getnoOfRows(); i++) {
//			System.out.println("\n");
//			for (int j = 0; j < Solver.getNonogram().getnoOfCols(); j++) {
//				System.out.print(Solver.getNonogram().getGrid()[i][j]);
//			}
//		}
//		int[] hexNo1 = new int[4];
//		int[] hexNo2 = new int[4];
//		int[] hexNo3 = new int[4];
//		int[] hexNo4 = new int[4];
//		int state = 1;
//		for (int i = 0; i < 16; i++) {
//			hexNo1 = DataHandler.integerBelow16To4BitArray(i);
//			hexNo2 = DataHandler.integerBelow16To4BitArray(i);
//			hexNo3 = DataHandler.integerBelow16To4BitArray(i);
//			hexNo4 = DataHandler.integerBelow16To4BitArray(i);
//			System.out.println("Sending " + i);
//			PinsConnection.sendGPIOData(hexNo1, hexNo2, hexNo3, hexNo4, state);
//			Thread.sleep(1000);
//		}
//		DataHandler.sendSpecificationsOfNono();
		/*
		 * Test case for setting rows:
		 */
		/*
		int[][] rowNumbers = new int[5][4];
		int[][] colNumbers = new int[4][4];
		rowNumbers[0][0] = 1;
		rowNumbers[0][1] = 1;
		rowNumbers[0][2] = 1;
		rowNumbers[0][3] = 1;
		
		rowNumbers[1][0] = 0;
		rowNumbers[1][1] = 0;
		rowNumbers[1][2] = 0;
		rowNumbers[1][3] = 0;
		
		rowNumbers[2][0] = 0;
		rowNumbers[2][1] = 1;
		rowNumbers[2][2] = 0;
		rowNumbers[2][3] = 1;
		
		rowNumbers[3][0] = 1;
		rowNumbers[3][1] = 0;
		rowNumbers[3][2] = 1;
		rowNumbers[3][3] = 0;
		
		NonogramHandler.createNonogramFromUserInput(10, 10, rowNumbers , colNumbers);
		DataHandler.createAndSendSizeOfNono();
		int[] hexNo1 = rowNumbers[0];
		int[] hexNo2 = rowNumbers[1];
		int[] hexNo3 = rowNumbers[2];
		int[] hexNo4 = rowNumbers[3];
		int state = 0;
		PinsConnection.sendGPIOData(hexNo1, hexNo2, hexNo3, hexNo4, state);
		Thread.sleep(1000);
		PinsConnection.sendGPIOData(hexNo2, hexNo2, hexNo3, hexNo4, state);
		Thread.sleep(1000);
		PinsConnection.sendGPIOData(hexNo3, hexNo2, hexNo3, hexNo4, state);
		Thread.sleep(1000);
		PinsConnection.sendGPIOData(hexNo4, hexNo2, hexNo3, hexNo4, state);
		Thread.sleep(1000);
		int sizeOfNono = Solver.getNonogram().getnoOfCols() * Solver.getNonogram().getnoOfRows();
		int[] hoi = new int[0];
		while (hoi.length < sizeOfNono) {
			hoi = ArrayUtils.addAll(hoi, PinsConnection.getGPIOData());
		}
		DataHandler.setGridFromData(hoi);
//		int noOfFields = 0;
		for (int i = 0; i < nono.getnoOfRows(); i++) {
			for (int j = 0; j < nono.getnoOfCols(); j++) {
				System.out.println(nono.getGrid()[i][j]);
//				noOfFields++;
			}
		}
//		System.out.println(noOfFields);
//		System.out.println(Solver.nono.getnoOfRows());
//		System.out.println(Solver.nono.getnoOfCols());
//		for (int i = 0; i < Solver.nono.getRowNumbers().length; i++) {
//			for (int j = 0; j < Solver.nono.getRowNumbers()[i].length; j++) {
//				if (j == 0) {
//					System.out.println("nieuw en " + i);
//				}
//				System.out.println(Solver.nono.getRowNumbers()[i][j]);
//			}
//		}
 * */
	}
}
