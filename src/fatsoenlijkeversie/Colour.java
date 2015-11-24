package fatsoenlijkeversie;

public enum Colour {

	BLACK, WHITE, EMPTY;
	
	public Colour other()	{
		return (this == BLACK)? WHITE:BLACK;
	}
	
}
