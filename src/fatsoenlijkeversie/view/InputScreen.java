package fatsoenlijkeversie.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Rogier on 24-11-15
 */
public class InputScreen {
    private JSpinner rowsSpinner;
    private JSpinner columnsSpinner;
    private JLabel label1;
    private JLabel label2;
    private JPanel Inputscreen;
    private JButton playButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("InputScreen");
        frame.setContentPane(new InputScreen().Inputscreen);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public InputScreen() {
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playButton.setText("Succes!");
            }
        });
    }
}
