package levelPieces;

import java.util.Random;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
/**
 * Close hit attack.
 * 
 * @author Tyner Dale
 * @author John Reimann
 * 
 * 
 */
public class Robber extends GamePiece implements Drawable, Moveable {

	protected String name="Robber";
	protected char symbol='r';
	protected int location=GameEngine.r;
	public String description="(Close Attack)";
	public Robber(char symbol, String name, int location) {
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
		if (playerLocation==GameEngine.r){
			return InteractionResult.HIT;
		}
		

		
		return InteractionResult.NONE;
		
		
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		Random rand= new Random();
		GameEngine.r=rand.nextInt(GameEngine.BOARD_SIZE-1);
		GameEngine.robber.setLocation(GameEngine.r);
		
	}
	

}
