package fatsoenlijkeversie.view;

import fatsoenlijkeversie.Colour;
import fatsoenlijkeversie.NonogramImplementation;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Rogier on 24-11-15
 */
public class GridView extends JComponent implements Observer {
    private Colour[][] grid;

    public GridView(Colour[][] grid) {
        this.grid = grid;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof NonogramImplementation) {
            this.grid = (Colour[][]) arg;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Dimension dimension = this.getSize();
        int squareWidth = dimension.width / grid.length;
        int squareHeight = dimension.height / grid[0].length;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                g.drawRect(column * squareWidth, row * squareHeight, squareWidth, squareHeight);
            }

        }
        ;
    }
}
