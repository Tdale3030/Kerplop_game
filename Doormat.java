package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
/**
 * Used for drawable requirement
 * 
 * @author Tyner Dale
 * @author John Reimann
 * 
 * 
 */
public class Doormat implements Drawable {
	
	public String name="Doormat";
	public char symbol='_';
	protected int location=GameEngine.d;
	public String description="(A doormat)";
	
	public Doormat(char symbol, String name, int location) {
		super();
		this.symbol = symbol;
		this.name = name ;
		this.location=location;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	

	public char getSymbol() {
		return symbol;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
		
	}

}
