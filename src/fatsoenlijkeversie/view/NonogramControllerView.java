package fatsoenlijkeversie.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Rogier on 24-11-15
 */
public class NonogramControllerView {
    private InputScreen inputScreen;
    private JFrame frame;
    private NonoPanel nonoPanel;

    public NonogramControllerView() {
        frame = new JFrame("InputScreen");

        inputScreen = new InputScreen();
        frame.setContentPane(inputScreen.getInputScreen());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension fullScreen = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(fullScreen);
        frame.setVisible(true);
    }


    public InputScreen getInputScreen() {
        return inputScreen;
    }

    public void InputRowAndColumns() {
        frame.setContentPane(nonoPanel);
    }

    public NonoPanel getNonoPanel() {
        return nonoPanel;
    }

}
