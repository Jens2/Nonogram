package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;

import gui.InputScreen;
import gui.SolvedPuzzleScreen;

import controller.DataHandler;
import controller.NonogramHandler;

public class InputScreen {

	private JFrame Grid_Input;
	private JPanel input;
	private JPanel gridInput;
	private JPanel rowInput;
	private JPanel columnInput;

	public static final int RESET = 5;
	public static final int MAX_ROWS = 15;
	public static final int MAX_COLUMNS = 15;
	public static final int MIN_ROWS = 5;
	public static final int MIN_COLUMNS = 5;
	
	public static boolean doneSending;
	
	private static int noOfRows;
	private static int noOfCols;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputScreen window = new InputScreen();
					window.Grid_Input.setBounds(8, 30, GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width - 16, GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height - 77);
					window.Grid_Input.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InputScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		/*
		 * Code to set the screen to fullScreen.
		 */
		Dimension fullScreen = Toolkit.getDefaultToolkit().getScreenSize();
		
		/*
		 * Create a frame to handle all the different inputs.
		 */
		Grid_Input = new JFrame();
		Grid_Input.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*
		 * Make sure the screen size stays at maximumSize.
		 */
		Grid_Input.setMaximumSize(fullScreen);
		Grid_Input.setTitle("Smart Automatic Nonogram Solver");
		Grid_Input.getContentPane().setLayout(new CardLayout(0, 0));

		/*
		 * A new panel for the numberofRows and the numberofColumns input.
		 */
		input = new JPanel();
		input.setBackground(Color.decode("#E3E3FF"));
		Grid_Input.getContentPane().add(input, "name_298284959981057");
		input.setBounds(0, 0, fullScreen.width, fullScreen.height);
		input.setLayout(null);
		input.setVisible(true);

		/*
		 * A new panel which will draw the grid and allow the user to fill in
		 * the numbers which indicate which blocks will turn black.
		 */
		gridInput = new JPanel();
		gridInput.setBackground(Color.decode("#E3E3FF"));
		Grid_Input.getContentPane().add(gridInput, "name_298299493464165");
		gridInput.setBounds(0, 0, fullScreen.width, fullScreen.height);
		gridInput.setVisible(false);

		/*
		 * A spinner for indicating the amount of rows.
		 */
		final JSpinner columnsSpinner = new JSpinner();
		columnsSpinner.setValue(MIN_COLUMNS);
		columnsSpinner.setBounds(input.getWidth()/24*10, input.getHeight()/60*21, 89, 27);
		input.add(columnsSpinner);

		/*
		 * A spinner for indicating the amount of columns.
		 */
		final JSpinner rowsSpinner = new JSpinner();
		rowsSpinner.setValue(MIN_ROWS);
		rowsSpinner.setBounds(input.getWidth()/24*10, input.getHeight()/30*8, 89, 27);
		input.add(rowsSpinner);

		/*
		 * A Label asking for the ColumnSize.
		 */
		JLabel lblColumnSize = new JLabel("Column size:");
		lblColumnSize.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblColumnSize.setBounds(input.getWidth()/24*10, input.getHeight()/60*19, 150, 21);
		input.add(lblColumnSize);

		/*
		 * A Label asking for the RowSize
		 */
		JLabel lblRowSize = new JLabel("Row size:");
		lblRowSize.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRowSize.setBounds(input.getWidth()/24*10, input.getHeight()/30*7, 110, 20);
		input.add(lblRowSize);

		/*
		 * A Label asking for the NonogramSize.
		 */
		JLabel lblInputNonoSize = new JLabel("Input Nonogram size:");
		lblInputNonoSize.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblInputNonoSize.setBounds(input.getWidth()/24*10, input.getHeight()/15*2, 350, 39);
		input.add(lblInputNonoSize);

		/*
		 * A Label indicating that the wrong input was given.
		 */
		final JLabel lblInputIsFalse = new JLabel("The wrong input was given.",
				SwingConstants.CENTER);
		lblInputIsFalse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInputIsFalse.setBounds(input.getWidth()/96*25, input.getHeight()/15*8, 600, 20);
		lblInputIsFalse.setVisible(false);
		input.add(lblInputIsFalse);
		
		final JLabel lbl2InputIsFalse = new JLabel("The wrong input was given.",
				SwingConstants.CENTER);
		lbl2InputIsFalse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl2InputIsFalse.setBounds(input.getWidth()/96*25, input.getHeight()/15*8, 600, 20);
		lbl2InputIsFalse.setVisible(false);
		gridInput.add(lbl2InputIsFalse);
		
		final JLabel processing = new JLabel("Processing the nonogram.", SwingConstants.CENTER);
		processing.setFont(new Font("Tahoma", Font.PLAIN, 16));
		processing.setBounds(970, 0, 600, 20);
		processing.setVisible(false);
		gridInput.add(processing);
		
		final JLabel lblInputCorrection2 = new JLabel(
				"This nonogram cannot exist, please check your entries and resubmit.",
				SwingConstants.CENTER);
		lblInputCorrection2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInputCorrection2.setBounds(input.getWidth()/24*6, input.getHeight()/30*17, 600, 20);
		lblInputCorrection2.setVisible(false);
		gridInput.add(lblInputCorrection2);

		/*
		 * A Label indicating what the right input is.
		 */
		final JLabel lblInputCorrection = new JLabel(
				"Please give a valid input for the rows and the columns ranging from 5 to 15",
				SwingConstants.CENTER);
		lblInputCorrection.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInputCorrection.setBounds(input.getWidth()/24*6, input.getHeight()/30*17, 600, 20);
		lblInputCorrection.setVisible(false);
		input.add(lblInputCorrection);

		/*
		 * Dit moet veel makkelijker kunnen, maar ik heb werkelijk geen idee hoe
		 * dat moet. This block of code is creating all the textFields of the
		 * rows and the columns
		 */

		final JFormattedTextField formattedTextFieldRow00 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow01 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow02 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow03 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow04 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow05 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow06 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow07 = new JFormattedTextField();

		final JFormattedTextField[] formattedTextArrayRow0 = new JFormattedTextField[] {
				formattedTextFieldRow00, formattedTextFieldRow01,
				formattedTextFieldRow02, formattedTextFieldRow03,
				formattedTextFieldRow04, formattedTextFieldRow05,
				formattedTextFieldRow06, formattedTextFieldRow07 };

		final JFormattedTextField formattedTextFieldRow10 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow11 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow12 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow13 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow14 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow15 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow16 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow17 = new JFormattedTextField();

		final JFormattedTextField[] formattedTextArrayRow1 = new JFormattedTextField[] {
				formattedTextFieldRow10, formattedTextFieldRow11,
				formattedTextFieldRow12, formattedTextFieldRow13,
				formattedTextFieldRow14, formattedTextFieldRow15,
				formattedTextFieldRow16, formattedTextFieldRow17 };

		final JFormattedTextField formattedTextFieldRow20 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow21 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow22 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow23 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow24 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow25 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow26 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow27 = new JFormattedTextField();

		final JFormattedTextField[] formattedTextArrayRow2 = new JFormattedTextField[] {
				formattedTextFieldRow20, formattedTextFieldRow21,
				formattedTextFieldRow22, formattedTextFieldRow23,
				formattedTextFieldRow24, formattedTextFieldRow25,
				formattedTextFieldRow26, formattedTextFieldRow27 };

		final JFormattedTextField formattedTextFieldRow30 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow31 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow32 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow33 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow34 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow35 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow36 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow37 = new JFormattedTextField();

		final JFormattedTextField[] formattedTextArrayRow3 = new JFormattedTextField[] {
				formattedTextFieldRow30, formattedTextFieldRow31,
				formattedTextFieldRow32, formattedTextFieldRow33,
				formattedTextFieldRow34, formattedTextFieldRow35,
				formattedTextFieldRow36, formattedTextFieldRow37 };

		final JFormattedTextField formattedTextFieldRow40 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow41 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow42 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow43 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow44 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow45 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow46 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow47 = new JFormattedTextField();

		final JFormattedTextField[] formattedTextArrayRow4 = new JFormattedTextField[] {
				formattedTextFieldRow40, formattedTextFieldRow41,
				formattedTextFieldRow42, formattedTextFieldRow43,
				formattedTextFieldRow44, formattedTextFieldRow45,
				formattedTextFieldRow46, formattedTextFieldRow47 };

		final JFormattedTextField formattedTextFieldRow50 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow51 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow52 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow53 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow54 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow55 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow56 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow57 = new JFormattedTextField();

		final JFormattedTextField[] formattedTextArrayRow5 = new JFormattedTextField[] {
				formattedTextFieldRow50, formattedTextFieldRow51,
				formattedTextFieldRow52, formattedTextFieldRow53,
				formattedTextFieldRow54, formattedTextFieldRow55,
				formattedTextFieldRow56, formattedTextFieldRow57 };

		final JFormattedTextField formattedTextFieldRow60 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow61 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow62 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow63 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow64 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow65 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow66 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow67 = new JFormattedTextField();

		final JFormattedTextField[] formattedTextArrayRow6 = new JFormattedTextField[] {
				formattedTextFieldRow60, formattedTextFieldRow61,
				formattedTextFieldRow62, formattedTextFieldRow63,
				formattedTextFieldRow64, formattedTextFieldRow65,
				formattedTextFieldRow66, formattedTextFieldRow67 };

		final JFormattedTextField formattedTextFieldRow70 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow71 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow72 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow73 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow74 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow75 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow76 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow77 = new JFormattedTextField();

		final JFormattedTextField[] formattedTextArrayRow7 = new JFormattedTextField[] {
				formattedTextFieldRow70, formattedTextFieldRow71,
				formattedTextFieldRow72, formattedTextFieldRow73,
				formattedTextFieldRow74, formattedTextFieldRow75,
				formattedTextFieldRow76, formattedTextFieldRow77 };

		final JFormattedTextField formattedTextFieldRow80 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow81 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow82 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow83 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow84 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow85 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow86 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow87 = new JFormattedTextField();

		final JFormattedTextField[] formattedTextArrayRow8 = new JFormattedTextField[] {
				formattedTextFieldRow80, formattedTextFieldRow81,
				formattedTextFieldRow82, formattedTextFieldRow83,
				formattedTextFieldRow84, formattedTextFieldRow85,
				formattedTextFieldRow86, formattedTextFieldRow87 };

		final JFormattedTextField formattedTextFieldRow90 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow91 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow92 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow93 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow94 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow95 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow96 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow97 = new JFormattedTextField();

		final JFormattedTextField[] formattedTextArrayRow9 = new JFormattedTextField[] {
				formattedTextFieldRow90, formattedTextFieldRow91,
				formattedTextFieldRow92, formattedTextFieldRow93,
				formattedTextFieldRow94, formattedTextFieldRow95,
				formattedTextFieldRow96, formattedTextFieldRow97 };

		final JFormattedTextField formattedTextFieldRow100 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow101 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow102 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow103 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow104 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow105 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow106 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow107 = new JFormattedTextField();

		final JFormattedTextField[] formattedTextArrayRow10 = new JFormattedTextField[] {
				formattedTextFieldRow100, formattedTextFieldRow101,
				formattedTextFieldRow102, formattedTextFieldRow103,
				formattedTextFieldRow104, formattedTextFieldRow105,
				formattedTextFieldRow106, formattedTextFieldRow107 };

		final JFormattedTextField formattedTextFieldRow110 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow111 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow112 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow113 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow114 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow115 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow116 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow117 = new JFormattedTextField();

		final JFormattedTextField[] formattedTextArrayRow11 = new JFormattedTextField[] {
				formattedTextFieldRow110, formattedTextFieldRow111,
				formattedTextFieldRow112, formattedTextFieldRow113,
				formattedTextFieldRow114, formattedTextFieldRow115,
				formattedTextFieldRow116, formattedTextFieldRow117 };

		final JFormattedTextField formattedTextFieldRow120 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow121 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow122 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow123 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow124 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow125 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow126 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow127 = new JFormattedTextField();

		final JFormattedTextField[] formattedTextArrayRow12 = new JFormattedTextField[] {
				formattedTextFieldRow120, formattedTextFieldRow121,
				formattedTextFieldRow122, formattedTextFieldRow123,
				formattedTextFieldRow124, formattedTextFieldRow125,
				formattedTextFieldRow126, formattedTextFieldRow127 };

		final JFormattedTextField formattedTextFieldRow130 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow131 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow132 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow133 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow134 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow135 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow136 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow137 = new JFormattedTextField();

		final JFormattedTextField[] formattedTextArrayRow13 = new JFormattedTextField[] {
				formattedTextFieldRow130, formattedTextFieldRow131,
				formattedTextFieldRow132, formattedTextFieldRow133,
				formattedTextFieldRow134, formattedTextFieldRow135,
				formattedTextFieldRow136, formattedTextFieldRow137 };

		final JFormattedTextField formattedTextFieldRow140 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow141 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow142 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow143 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow144 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow145 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow146 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldRow147 = new JFormattedTextField();

		final JFormattedTextField[] formattedTextArrayRow14 = new JFormattedTextField[] {
				formattedTextFieldRow140, formattedTextFieldRow141,
				formattedTextFieldRow142, formattedTextFieldRow143,
				formattedTextFieldRow144, formattedTextFieldRow145,
				formattedTextFieldRow146, formattedTextFieldRow147 };

		final JFormattedTextField[][] rowArrayNumbers = new JFormattedTextField[][] {
				formattedTextArrayRow0, formattedTextArrayRow1,
				formattedTextArrayRow2, formattedTextArrayRow3,
				formattedTextArrayRow4, formattedTextArrayRow5,
				formattedTextArrayRow6, formattedTextArrayRow7,
				formattedTextArrayRow8, formattedTextArrayRow9,
				formattedTextArrayRow10, formattedTextArrayRow11,
				formattedTextArrayRow12, formattedTextArrayRow13,
				formattedTextArrayRow14 };
		
		////////////////////////////////////////////////////////////////////////

		final JFormattedTextField formattedTextFieldColumn00 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn01 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn02 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn03 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn04 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn05 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn06 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn07 = new JFormattedTextField();
		
		final JFormattedTextField formattedTextFieldColumn10 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn11 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn12 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn13 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn14 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn15 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn16 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn17 = new JFormattedTextField();
		
		final JFormattedTextField formattedTextFieldColumn20 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn21 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn22 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn23 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn24 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn25 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn26 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn27 = new JFormattedTextField();
		
		final JFormattedTextField formattedTextFieldColumn30 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn31 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn32 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn33 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn34 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn35 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn36 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn37 = new JFormattedTextField();
		
		final JFormattedTextField formattedTextFieldColumn40 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn41 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn42 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn43 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn44 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn45 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn46 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn47 = new JFormattedTextField();
		
		final JFormattedTextField formattedTextFieldColumn50 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn51 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn52 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn53 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn54 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn55 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn56 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn57 = new JFormattedTextField();
		
		final JFormattedTextField formattedTextFieldColumn60 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn61 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn62 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn63 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn64 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn65 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn66 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn67 = new JFormattedTextField();
		
		final JFormattedTextField formattedTextFieldColumn70 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn71 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn72 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn73 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn74 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn75 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn76 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn77 = new JFormattedTextField();
		
		final JFormattedTextField formattedTextFieldColumn80 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn81 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn82 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn83 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn84 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn85 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn86 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn87 = new JFormattedTextField();

		final JFormattedTextField formattedTextFieldColumn90 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn91 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn92 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn93 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn94 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn95 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn96 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn97 = new JFormattedTextField();

		final JFormattedTextField formattedTextFieldColumn100 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn101 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn102 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn103 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn104 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn105 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn106 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn107 = new JFormattedTextField();

		final JFormattedTextField formattedTextFieldColumn110 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn111 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn112 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn113 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn114 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn115 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn116 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn117 = new JFormattedTextField();

		final JFormattedTextField formattedTextFieldColumn120 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn121 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn122 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn123 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn124 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn125 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn126 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn127 = new JFormattedTextField();

		final JFormattedTextField formattedTextFieldColumn130 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn131 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn132 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn133 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn134 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn135 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn136 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn137 = new JFormattedTextField();

		final JFormattedTextField formattedTextFieldColumn140 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn141 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn142 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn143 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn144 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn145 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn146 = new JFormattedTextField();
		final JFormattedTextField formattedTextFieldColumn147 = new JFormattedTextField();

		final JFormattedTextField[] formattedTextArrayColumn0 = new JFormattedTextField[] {
				formattedTextFieldColumn00, formattedTextFieldColumn10,
				formattedTextFieldColumn20, formattedTextFieldColumn30,
				formattedTextFieldColumn40, formattedTextFieldColumn50,
				formattedTextFieldColumn60, formattedTextFieldColumn70,
				formattedTextFieldColumn80, formattedTextFieldColumn90,
				formattedTextFieldColumn100, formattedTextFieldColumn110,
				formattedTextFieldColumn120, formattedTextFieldColumn130,
				formattedTextFieldColumn140};

		

		final JFormattedTextField[] formattedTextArrayColumn1 = new JFormattedTextField[] {
				formattedTextFieldColumn01, formattedTextFieldColumn11,
				formattedTextFieldColumn21, formattedTextFieldColumn31,
				formattedTextFieldColumn41, formattedTextFieldColumn51,
				formattedTextFieldColumn61, formattedTextFieldColumn71,
				formattedTextFieldColumn81, formattedTextFieldColumn91,
				formattedTextFieldColumn101, formattedTextFieldColumn111,
				formattedTextFieldColumn121, formattedTextFieldColumn131,
				formattedTextFieldColumn141};

	

		final JFormattedTextField[] formattedTextArrayColumn2 = new JFormattedTextField[] {
				formattedTextFieldColumn02, formattedTextFieldColumn12,
				formattedTextFieldColumn22, formattedTextFieldColumn32,
				formattedTextFieldColumn42, formattedTextFieldColumn52,
				formattedTextFieldColumn62, formattedTextFieldColumn72,
				formattedTextFieldColumn82, formattedTextFieldColumn92,
				formattedTextFieldColumn102, formattedTextFieldColumn112,
				formattedTextFieldColumn122, formattedTextFieldColumn132,
				formattedTextFieldColumn142};



		final JFormattedTextField[] formattedTextArrayColumn3 = new JFormattedTextField[] {
				formattedTextFieldColumn03, formattedTextFieldColumn13,
				formattedTextFieldColumn23, formattedTextFieldColumn33,
				formattedTextFieldColumn43, formattedTextFieldColumn53,
				formattedTextFieldColumn63, formattedTextFieldColumn73,
				formattedTextFieldColumn83, formattedTextFieldColumn93,
				formattedTextFieldColumn103, formattedTextFieldColumn113,
				formattedTextFieldColumn123, formattedTextFieldColumn133,
				formattedTextFieldColumn143,};



		final JFormattedTextField[] formattedTextArrayColumn4 = new JFormattedTextField[] {
				formattedTextFieldColumn04, formattedTextFieldColumn14,
				formattedTextFieldColumn24, formattedTextFieldColumn34,
				formattedTextFieldColumn44, formattedTextFieldColumn54,
				formattedTextFieldColumn64, formattedTextFieldColumn74,
				formattedTextFieldColumn84, formattedTextFieldColumn94,
				formattedTextFieldColumn104, formattedTextFieldColumn114,
				formattedTextFieldColumn124, formattedTextFieldColumn134,
				formattedTextFieldColumn144};

		final JFormattedTextField[] formattedTextArrayColumn5 = new JFormattedTextField[] {
				formattedTextFieldColumn05, formattedTextFieldColumn15,
				formattedTextFieldColumn25, formattedTextFieldColumn35,
				formattedTextFieldColumn45, formattedTextFieldColumn55,
				formattedTextFieldColumn65, formattedTextFieldColumn75,
				formattedTextFieldColumn85, formattedTextFieldColumn95,
				formattedTextFieldColumn105, formattedTextFieldColumn115,
				formattedTextFieldColumn125, formattedTextFieldColumn135,
				formattedTextFieldColumn145,};

		final JFormattedTextField[] formattedTextArrayColumn6 = new JFormattedTextField[] {
				formattedTextFieldColumn06, formattedTextFieldColumn16,
				formattedTextFieldColumn26, formattedTextFieldColumn36,
				formattedTextFieldColumn46, formattedTextFieldColumn56,
				formattedTextFieldColumn66, formattedTextFieldColumn76,
				formattedTextFieldColumn86, formattedTextFieldColumn96,
				formattedTextFieldColumn106, formattedTextFieldColumn116,
				formattedTextFieldColumn126, formattedTextFieldColumn136,
				formattedTextFieldColumn146};


		final JFormattedTextField[] formattedTextArrayColumn7 = new JFormattedTextField[] {
				formattedTextFieldColumn07, formattedTextFieldColumn17,
				formattedTextFieldColumn27, formattedTextFieldColumn37,
				formattedTextFieldColumn47, formattedTextFieldColumn57,
				formattedTextFieldColumn67, formattedTextFieldColumn77,
				formattedTextFieldColumn87, formattedTextFieldColumn97,
				formattedTextFieldColumn107, formattedTextFieldColumn117,
				formattedTextFieldColumn127, formattedTextFieldColumn137,
				formattedTextFieldColumn147,};

		final JFormattedTextField[][] columnArrayNumbers = new JFormattedTextField[][] {
				formattedTextArrayColumn0, formattedTextArrayColumn1,
				formattedTextArrayColumn2, formattedTextArrayColumn3,
				formattedTextArrayColumn4, formattedTextArrayColumn5,
				formattedTextArrayColumn6, formattedTextArrayColumn7,
		};

		/*
		 * A button to go to the next panel. This button will send the values of
		 * thespinnerss to the class Nonogram and create input field for the
		 * user according to the input the user has given.
		 */
		JButton btnInputNextBtn = new JButton("Next");
		btnInputNextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				noOfRows = (int) rowsSpinner.getValue();
				noOfCols = (int) columnsSpinner.getValue();
				if(noOfRows <= MAX_ROWS && noOfCols <= MAX_COLUMNS && noOfRows >= MIN_ROWS && noOfCols >= MIN_COLUMNS) {
					//Error message is off.
					lblInputIsFalse.setVisible(false);
					lblInputCorrection.setVisible(false);
					lblInputCorrection2.setVisible(false);
					
					// Switch between panels.
					input.setVisible(false);
					gridInput.setVisible(true);

					// Create the rowInput panel.
					rowInput = new JPanel();
					rowInput.setBounds(gridInput.getWidth()/60, gridInput.getHeight()/30*9, 300, 380);
					gridInput.add(rowInput);
					rowInput.setLayout(new GridLayout(noOfRows, (noOfCols - 1) / 2 + 1));

					// Create the columnInput panel.
					columnInput = new JPanel();
					columnInput.setBounds(gridInput.getWidth()/96*23, gridInput.getHeight()/37, 500, 180);
					gridInput.add(columnInput);
					columnInput.setLayout(new GridLayout(
							(noOfRows - 1) / 2 + 1,
							noOfCols));

					// Create the rows input
					// First select one row
					for (int i = 0; i < noOfRows; i++) {
						// k is the max number of input blocks we can have.
						int k = (noOfCols - 1) / 2 + 1;
						// make each input block.
						for (int l = 0; l < k; l++) {
							rowArrayNumbers[i][l] = new JFormattedTextField();
							rowInput.add(rowArrayNumbers[i][l]);
						}
					}

					// Create the columns input
					// First select one column
					int k = (noOfRows - 1) / 2 + 1;
					for (int i = 0; i < k; i++) {
						// k is the max number of input blocks we can have.
						
						// make each input block
						for (int l = 0; l < noOfCols; l++) {
							columnArrayNumbers[i][l] = new JFormattedTextField();
							columnInput.add(columnArrayNumbers[i][l]);
						}
					}
				} else {
					//Error message is displayed.
					lblInputIsFalse.setVisible(true);
					lblInputCorrection.setVisible(true);
					//Reset the rows and columns.
					rowsSpinner.setValue((int) RESET);
					columnsSpinner.setValue((int) RESET);
				}
				

			}
		});
		btnInputNextBtn.setBounds((input.getWidth()/24*10), input.getHeight()/30*13, 170, 40);
		input.add(btnInputNextBtn);

		/*
		 * A button to go back to the input panel. This will also reset the
		 * columns and rows variables. It will also remove all the formatted-
		 * textFields.
		 */
		JButton btnBackBtn = new JButton("Back");
		btnBackBtn.setBounds(gridInput.getWidth()/24*5, gridInput.getHeight()/15*12, 130, 35);
		btnBackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblInputIsFalse.setVisible(false);
				// Delete the rowInputs
				int k = (noOfCols - 1) / 2 + 1;
				for (int i = 0; i < noOfRows; i++) {
					for (int l = 0; l < k; l++) {
						rowInput.remove(rowArrayNumbers[i][l]);
					}
				}

				// Delete the columnInputs
				k = (noOfRows - 1) / 2 + 1;
				for (int i = 0; i < noOfCols; i++) {
					for (int l = 0; l < k; l++) {
						columnInput.remove(columnArrayNumbers[l][i]);
					}
				}
				gridInput.setVisible(false);
				input.setVisible(true);
				rowsSpinner.setValue((int) RESET);
				columnsSpinner.setValue((int) RESET);
			}
		});
		gridInput.setLayout(null);
		gridInput.add(btnBackBtn);

		/*
		 * A button to submit the numbers the user has filled in.
		 */
		
		JButton btnSubmitBtn = new JButton("Submit");
		btnSubmitBtn.setBounds(gridInput.getWidth()/24*16, gridInput.getHeight()/15*12, 130, 35);
		btnSubmitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblInputIsFalse.setVisible(false);
				lblInputCorrection2.setVisible(false);
				boolean kapot = false;
				int[][] rowNumbers = null;
				int[][] colNumbers = null;
				int maxRowEntry = ((noOfCols -1) / 2) + 1;
				int maxColEntry = ((noOfRows -1) / 2) + 1;
				try {
					rowNumbers = DataHandler.jTextFieldToIntArray(rowArrayNumbers, noOfRows, maxRowEntry, false);
					colNumbers = DataHandler.jTextFieldToIntArray(columnArrayNumbers, noOfCols, maxColEntry, true);
				} catch (NumberFormatException e) {
					kapot = true;
				}
				if (rowNumbers == null || colNumbers == null) {
					kapot = true;
				}
				// In progress
				// Check to see if the specified number in the available slots isn't more than the max number of blocks we can have
				if (NonogramHandler.createNonogramFromUserInput(noOfRows, noOfCols, rowNumbers, colNumbers) && !kapot) {
					// Send the data to the FPGA
//					PinsConnection.testOutputPins();
//					PinsConnection.testInputPins();
					// Go to loading screen or something
					SolvedPuzzleScreen s = new SolvedPuzzleScreen();
					s.frame.setVisible(true);
				} else {
					// ERROR message to tell the input is wrong, we do not want to reset the filled in rows and columns
					lblInputIsFalse.setVisible(true);
					lblInputCorrection2.setVisible(true);
				}
			}
		});
		gridInput.add(btnSubmitBtn);
	}
}
