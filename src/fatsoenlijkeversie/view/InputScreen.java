package fatsoenlijkeversie.view;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by Rogier on 24-11-15
 */
public class InputScreen {
    private JSpinner rowsSpinner;
    private JSpinner columnsSpinner;
    private JLabel label1;
    private JLabel label2;
    private JPanel inputScreen;
    private JButton playButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("InputScreen");
        frame.setContentPane(new InputScreen().inputScreen);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public InputScreen() {

    }

    public void addButtonListener(ActionListener actionListener) {
        playButton.addActionListener(actionListener);
    }

    public int getNumberOfRows() {
        return (int) rowsSpinner.getValue();
    }

    public int getNumberOfColumns() {
        return (int) columnsSpinner.getValue();
    }

    public JPanel getInputScreen() {
        return inputScreen;
    }
}
