package levelPieces;




import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;


public class Annihilator extends GamePiece implements Drawable {
	
	protected String name="Annihilator";
	protected char symbol='A';
	protected int location=GameEngine.A;
	public String description="(An unstoppable force)";
	public Annihilator(char symbol, String name, int location) {
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
		
		if ((playerLocation==GameEngine.A)||(playerLocation-1==GameEngine.A)||(playerLocation+1==GameEngine.A)){
			
			return InteractionResult.KILL;
		}
		

		
		return InteractionResult.NONE;
		
		
	}



}