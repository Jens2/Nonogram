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

    public GameController(Player player) {
        NonogramControllerView controllerView = new NonogramControllerView();
        inputScreen = controllerView.getInputScreen();
        this.player = player;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Play")) {
            nonogram = new NonogramImplemenation(inputScreen.getNumberOfRows(), inputScreen.getNumberOfColumns());
            nonogram.initializeGrid();
            nonogram.addObserver(null);
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
