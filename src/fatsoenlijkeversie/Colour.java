package fatsoenlijkeversie;

public enum Colour {
	
	BLACK, WHITE;
	
	public Colour other()	{
		return (this == BLACK)? WHITE:BLACK; 
	}
	
}
