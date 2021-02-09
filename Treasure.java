package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;

/**
 * Creates piece that advances you to next level
 * 
 * @author Tyner Dale
 * @author John Reimann
 * 
 * 
 */


public class Treasure extends GamePiece  {
	protected String name="Treasure";
	protected char symbol='X';
	protected int location=GameEngine.y;
	public String description="(Advances you to Next Level)";
	public Treasure(char symbol, String name, int location) {
		super(symbol, name, location);
		this.symbol=getSymbol();
		this.name=getName();
		this.location=getLocation();
		
	}

	public String getName() {
		return name;
	}


	public char getSymbol() {
		return symbol;
	}


	public void setName(String name) {
		this.name = name;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (playerLocation==this.location){
			return InteractionResult.ADVANCE;
		}
		
		return InteractionResult.NONE;
		
		
	}

	
	

}
