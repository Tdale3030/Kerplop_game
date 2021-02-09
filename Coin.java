package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
/**
 * Gives you point
 * 
 * @author Tyner Dale
 * @author John Reimann
 * 
 * 
 */

public class Coin extends GamePiece implements Drawable{
	private int count=0;
	private String name="coin";
	private char symbol='$';
	private int location=GameEngine.c;
	public String description="(A prize)";
	public Coin(char symbol, String name, int location) {
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
			this.count++;
			if (count<=1)
				return InteractionResult.GET_POINT;
			else {
				return InteractionResult.NONE;
			}
		}
		
		return InteractionResult.NONE;
		
		
	}

}
