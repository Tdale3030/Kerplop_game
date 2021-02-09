package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

/**
 * Ranged piece
 * 
 * @author Tyner Dale
 * @author John Reimann
 * 
 * 
 */

public class Sniper extends GamePiece implements Moveable, Drawable{
	protected String name="Sniper";
	protected char symbol='S';
	protected int location=GameEngine.x;
	public String description="(Ranged Attack)";
	public Sniper(char symbol, String name, int location) {
		super(symbol, name, location);
		this.symbol=getSymbol();
		this.name=getName();
		this.location=getLocation();
		
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public char getSymbol() {
		return symbol;
	}


	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if ((playerLocation-1==GameEngine.x)||(playerLocation+1==GameEngine.x)){
			return InteractionResult.KILL;
		}
		

		
		return InteractionResult.NONE;
		
		
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		GameEngine.x=GameEngine.x-1;
		GameEngine.sniper=new Sniper('S',"Sniper",GameEngine.x);
		
	}
	
	
	

}
