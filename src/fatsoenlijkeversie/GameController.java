package fatsoenlijkeversie;

import fatsoenlijkeversie.view.InputScreen;
import fatsoenlijkeversie.view.NonogramControllerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Rogier on 24-11-15
 */
public class GameController implements ActionListener {
    private Nonogram nonogram;
    private InputScreen inputScreen;
    private Player player;
    private NonogramControllerView controllerView;

    public GameController(Player player) {
        controllerView = new NonogramControllerView();
        inputScreen = controllerView.getInputScreen();
        this.player = player;
        inputScreen.addButtonListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Play")) {
            nonogram = new NonogramImplementation(inputScreen.getNumberOfRows(), inputScreen.getNumberOfColumns());
            nonogram.initializeGrid();

            controllerView.InputRowAndColumns(nonogram.getGrid());
            nonogram.addObserver(controllerView.getNonoPanel().getGridView());
        }
    }

    public void run() {
        this.setup();
        this.play();
    }

    public void setup() {

    }

    public void play() {
        while (nonogram.gameover()) {
            player.makeMove(nonogram);
        }
    }


}
