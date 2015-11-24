package fatsoenlijkeversie;


import java.util.Observer;

public interface Nonogram { // <3
	
	public int getRowAmount();
	
	public int getColumnAmount();

	public Colour getColor(int row, int column);
	
	public int[] getRowNumbers(int row);
	
	public int[] getColumnNumbers(int column);

    boolean gameover();

    void move(int value);

	void addObserver(Observer observer);

}
