package fatsoenlijkeversie;

public interface Nonogram { // <3
	
	public int getRowAmount();
	
	public int getColumnAmount();

	public Colour getColor(int row, int column);
	
	public int[] getRowNumbers(int row);
	
	public int[] getColumnNumbers(int column);
	
}
