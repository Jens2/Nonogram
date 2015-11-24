package fatsoenlijkeversie;

/**
 * Created by Rogier on 24-11-15
 */
public class GameController {
    private Nonogram nonogram;


    public GameController() {


        nonogram = new NonogramImplemenation(0, 0);
        nonogram.addObserver(null);

    }

    public void run() {
        this.setup();
        this.play();
    }

    public void setup() {

    }

    public void play() {
        while (nonogram.gameover()) {

        }
    }


}
