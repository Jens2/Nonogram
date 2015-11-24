package fatsoenlijkeversie;

/**
 * Created by Rogier on 24-11-15
 */
public abstract class Player {

    public abstract Move determineMove(Nonogram nonogram);

    public void makeMove(Nonogram nonogram) {
        Move move = this.determineMove(nonogram);
        nonogram.move(move);
    }
}
