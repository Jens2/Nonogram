package fatsoenlijkeversie.view;

import fatsoenlijkeversie.Colour;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Rogier on 24-11-15
 */
public class NonoPanel extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GridView gridView;
    private RowNumberView rowNumberView;
    private ColumnNumberView columnNumberView;
    private int rowAmount;
    private int columnAmount;

    public NonoPanel(int rowAmount, int columnAmount, Colour[][] grid) {
        super(new GridBagLayout());
        this.rowAmount = rowAmount;
        this.columnAmount = columnAmount;
        this.setupGUI(grid);
    }

    public void setupGUI(Colour[][] grid){
        GridBagConstraints gbc = new GridBagConstraints();
        rowNumberView = new RowNumberView(rowAmount, columnAmount);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.fill = GridBagConstraints.VERTICAL;
        this.add(rowNumberView,gbc);

        columnNumberView = new ColumnNumberView(rowAmount, columnAmount);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.fill = GridBagConstraints.VERTICAL;
        this.add(columnNumberView,gbc);
        gridView = new GridView(grid);

    }

    public GridView getGridView() {
        return gridView;
    }

    public RowNumberView getRowNumberView() {
        return rowNumberView;
    }

    public ColumnNumberView getColumnNumberView() {
        return columnNumberView;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
