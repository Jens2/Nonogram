package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.BlockColour;
import model.Nonogram;
import model.Solver;
//import controller.DataHandler;

public class SolvedPuzzleScreen {

	public JFrame frame;
	private Nonogram nono = Solver.getNonogram();
	
	private static final int x = 100;
	private static final int y = 100;

	public Solved solved = new Solved();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Solver.setNonogram(new Nonogram(5,5,new BlockColour[0][0], new int[0][0], new int[0][0]));
		new SolvedPuzzleScreen();
	}
	/**
	 * Create the application.
	 */
	public SolvedPuzzleScreen() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("The Solved Puzzle");
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setMinimumSize(new Dimension(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width / 2,
				GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height - 77));
		frame.setBounds(8, 30, GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width / 2,
				GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height - 77);
		// Test code
		/*if (nono == null || true) {
			BlockColour[][] grid = new BlockColour[5][5];
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (j%2 == 0 && i%2 == 0) {
						grid[i][j] = BlockColour.BLACK;
					} else if (j%2 == 0){
						grid[i][j] = BlockColour.BLACK;
					} else if (i%2 == 0) {
						grid[i][j] = BlockColour.BLACK;
					} else {
						grid[i][j] = BlockColour.WHITE;
					}
				}
			}
			nono.setGrid(grid);
			int[] bitArray = {1,1,1,1,1, 1,0,1,0,1, 1,1,1,1,1, 1,0,0,0,0, 1,0,0,0,0};
			DataHandler.setGridFromData(bitArray);
		}*/
		// End test code
		frame.getContentPane().add(new Solved());
		
		frame.pack();
		frame.setVisible(true);
	}
	
	class Solved extends JPanel {
	
		private static final long serialVersionUID = 29L;

		public Solved() {
			setBackground(Color.decode("#E3E3FF"));
			initialize();
			
		}
		
		public void initialize() {
//			setLayout(new GridLayout(nono.getnoOfRows(), nono.getnoOfCols()));
//			DataHandler.setGridFromData(DataHandler.getGrid(nono.getnoOfCols() * nono.getnoOfRows()));
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			int noOfRows = nono.getnoOfRows();
			int noOfCols = nono.getnoOfCols();
			int width = noOfCols * 50;
			int height = noOfRows * 50;
			g.fillRect(x, y, width, height);
			BlockColour[][] grid = nono.getGrid();
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++) {
					if (grid[i][j].equals(BlockColour.WHITE)) {
						g.clearRect(x + j*50, y + i*50, width / noOfCols, height / noOfRows);
					}
				}
			}
		}
	}
}
