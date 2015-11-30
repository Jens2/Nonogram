package fatsoenlijkeversie.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Rogier on 27-11-15
 */
public class ColumnNumberView extends JPanel {
    private int rowAmount;
    private int columnAmount;

    public ColumnNumberView(int rowAmount, int columnAmount) {
        super(new GridBagLayout());
        this.rowAmount = rowAmount;
        this.columnAmount = columnAmount;
        this.setupGUI();
    }

    public void setupGUI() {
        GridBagConstraints gbc;
        for (int i = 0; i < columnAmount; i++) {
            for (int j = 0; j < (rowAmount / 2) + 1; j++) {
                JFormattedTextField textField = new JFormattedTextField();
                textField.setValue(new Integer(100));
                gbc = new GridBagConstraints();
                gbc.gridx = i;
                gbc.gridy = j;
                gbc.weightx = 1.0;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                this.add(textField, gbc);
            }

        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}