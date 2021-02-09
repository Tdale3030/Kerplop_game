package levelPieces;

import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;

/**
 * 
 * LevelSetup sets up all the pieces and creates array lists that have moveable and interacting pieces
 * 
 * @author Tyner Dale
 * @author John Reimann
 * 
 * 
 *
 */
public class LevelSetup {

	public void createLevel(int levelNum) {
		
		if (levelNum==1) {
			GameEngine.x=17;
			GameEngine.y=11;
			GameEngine.A=13;
			GameEngine.c=8;
			GameEngine.d=4;
			GameEngine.d_2=10;
			GameEngine.c_2=3;

		}
		else if(levelNum==2) {
			GameEngine.x=16;
			GameEngine.y=13;
			GameEngine.A=15;
			GameEngine.c=17;
			GameEngine.d=4;
			GameEngine.d_2=10;
			GameEngine.c_2=5;
			
		}
		GameEngine.annihilator.setLocation(GameEngine.A);
		GameEngine.sniper.setLocation(GameEngine.x);
		GameEngine.treasure.setLocation(GameEngine.y);
		GameEngine.robber.setLocation(GameEngine.r);
		GameEngine.coin_1.setLocation(GameEngine.c);
		GameEngine.coin_2.setLocation(GameEngine.c_2);
		GameEngine.doormat.setLocation(GameEngine.d);
		GameEngine.doormat_2.setLocation(GameEngine.d_2);
	
	}

	public Drawable[] getBoard() {
		Drawable [] board = {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null};
		return board;
		
	}

	public ArrayList<Moveable> getMovingPieces() {
	
		ArrayList<Moveable> list = new ArrayList<Moveable>();
		
		list.add(GameEngine.sniper);
		list.add(GameEngine.robber);
	
		

		return list;
		
	}

	public ArrayList<GamePiece> getInteractingPieces() {
		ArrayList<GamePiece> interact = new ArrayList<GamePiece>();
		
		interact.add(GameEngine.annihilator);
		interact.add(GameEngine.sniper);
		interact.add(GameEngine.treasure);
		interact.add(GameEngine.robber);
		interact.add(GameEngine.coin_1);
		interact.add(GameEngine.coin_2);
		
		return interact;
	}

	public int getPlayerStartLoc() {
		

		
		return 0;
	}

}
