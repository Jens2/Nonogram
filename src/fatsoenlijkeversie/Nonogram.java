package fatsoenlijkeversie;


import java.util.Observer;

public interface Nonogram {
    void initializeGrid();

    Colour[][] getGrid();

    int getRowAmount();

    int getColumnAmount();

    Colour getColor(int row, int column);

    int[] getRowNumbers(int row);

    int[] getColumnNumbers(int column);

    boolean gameover();

    void move(Move value);

	void addObserver(Observer observer);

}
