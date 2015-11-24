package fatsoenlijkeversie;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Rogier on 24-11-15
 */
public class HumanPlayer extends Player implements MouseListener {

    @Override
    public Move determineMove(Nonogram nonogram) {
        int value = 0;
        boolean intRead = false;
        BufferedReader reader;
        String line;
        do {
            do {
                reader = new BufferedReader(new InputStreamReader(System.in));
                line = null;
                try {
                    line = reader.readLine();
                } catch (IOException e) {
                    System.out.println("ERROR: Enter a String");
                }
            } while (line.equals(null));
            if (line.matches("-?\\d+")) {
                value = Integer.parseInt(line);
                intRead = true;
            }
        } while (!intRead);
        return null;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
