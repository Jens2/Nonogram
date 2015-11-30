package fatsoenlijkeversie.view;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;

/**
 * Created by Rogier on 27-11-15
 */
public class RowNumberView extends JPanel {
    private int rowAmount;
    private int columnAmount;

    public RowNumberView(int rowAmount, int columnAmount) {
        super(new GridBagLayout());
        this.rowAmount = rowAmount;
        this.columnAmount = columnAmount;
        this.setupGUI();
    }

    public void setupGUI() {
        GridBagConstraints gbc;
        for (int i = 0; i < rowAmount; i++) {
            for (int j = 0; j < (columnAmount / 2) + 1; j++) {
                JFormattedTextField textField1 = new JFormattedTextField();
                
                gbc = new GridBagConstraints();
                gbc.gridx = j;
                gbc.gridy = i;
                gbc.weightx = 1.0;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                this.add(textField1, gbc);
            }

        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
