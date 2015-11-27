package fatsoenlijkeversie.view;

import javax.swing.*;
import java.awt.*;
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
    private JLabel welcome;

    public static void main(String[] args) {
        JFrame frame = new JFrame("InputScreen");
        frame.setContentPane(new InputScreen().inputScreen);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public InputScreen() {
        SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel();
        spinnerNumberModel.setValue(5);
        spinnerNumberModel.setMinimum(5);
        rowsSpinner.setModel(spinnerNumberModel);
        SpinnerNumberModel spinnerNumberModel1 = new SpinnerNumberModel();
        spinnerNumberModel1.setValue(5);
        spinnerNumberModel1.setMinimum(5);
        columnsSpinner.setModel(spinnerNumberModel1);
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

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        inputScreen = new JPanel();
        inputScreen.setLayout(new GridBagLayout());
        rowsSpinner = new JSpinner();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 0.4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 30;
        inputScreen.add(rowsSpinner, gbc);
        columnsSpinner = new JSpinner();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 30;
        inputScreen.add(columnsSpinner, gbc);
        label1 = new JLabel();
        label1.setFont(new Font("Helvetica Neue", label1.getFont().getStyle(), 23));
        label1.setText("Rows");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 0.4;
        gbc.anchor = GridBagConstraints.WEST;
        inputScreen.add(label1, gbc);
        label2 = new JLabel();
        label2.setFont(new Font("Helvetica Neue", label2.getFont().getStyle(), 23));
        label2.setText("Columns");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.weightx = 0.4;
        gbc.anchor = GridBagConstraints.WEST;
        inputScreen.add(label2, gbc);
        playButton = new JButton();
        playButton.setText("Play");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 6;
        inputScreen.add(playButton, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.weighty = 0.2;
        gbc.fill = GridBagConstraints.VERTICAL;
        inputScreen.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.VERTICAL;
        inputScreen.add(spacer2, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.weighty = 0.3;
        gbc.fill = GridBagConstraints.VERTICAL;
        inputScreen.add(spacer3, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputScreen.add(spacer4, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputScreen.add(spacer5, gbc);
        welcome = new JLabel();
        welcome.setFont(new Font("Helvetica Neue", welcome.getFont().getStyle(), 23));
        welcome.setText("Welcome to Nonogram");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        inputScreen.add(welcome, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 20;
        inputScreen.add(spacer6, gbc);
        label1.setLabelFor(rowsSpinner);
        label2.setLabelFor(columnsSpinner);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return inputScreen;
    }
}
