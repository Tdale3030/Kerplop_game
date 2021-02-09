package gameEngine;


import java.util.ArrayList;

import levelPieces.Annihilator;
import levelPieces.Coin;
import levelPieces.Doormat;
import levelPieces.GamePiece;
import levelPieces.LevelSetup;
import levelPieces.Robber;
import levelPieces.Sniper;
import levelPieces.Treasure;


/**
 * Framework for LevelGame.
 * 
 * @author Tyner Dale
 * @author John Reimann
 * 
 * 
 *
 */

public class GameEngine {
	/**
	 * Determines the size of the game board.
	 * 
	 * Board is a 1D structure. It is an odd number so player can start exactly in
	 * the middle if desired.
	 */
	public final static int BOARD_SIZE = 21;
	/**
	 * Number of levels defined for this game. GameEngine will automatically play
	 * each level, starting with 1 through the number specified here.
	 */
	public final static int NUM_LEVELS = 2;
	// Keep track of the current level, starting with level 1
	private int currentLevel=0;
	// LevelEngine will create all the data structures for this level
	private LevelSetup levelData;
	// Each level has a 1D array for the board containing pieces that can be drawn
	// or null for empty
	private Drawable[] gameBoard;
	// Only some pieces can move.
	private ArrayList<Moveable> movingPieces;
	// Only game pieces interact
	private ArrayList<GamePiece> interactingPieces;
	// Player keeps track of player status and controls player movement/location
	
	private Player player;
	public static int x=0;
	public static int y=0;
	public static int r=20;
	public static int c=0;
	public static int d=0;
	public static int A=0;
	public static int d_2=0;
	public static int c_2=0;
	public static Annihilator annihilator=new Annihilator('A',"Annihilator",A);
	public static Sniper sniper= new Sniper('S',"Sniper",x);
	public static Treasure treasure=new Treasure('X',"treasure",y);
	public static Robber robber=new Robber('r',"Robber",r);
	public static Coin coin_1=new Coin('$',"coin",c);
	public static Doormat doormat=new Doormat('_',"Doormat",d);
	public static Doormat doormat_2=new Doormat('_',"Doormat",d_2);
	public static Coin coin_2=new Coin('$',"coin",c_2);

	/**
	 * Driver for the game. Creates game and plays it.
	 * 
	 * @param args Unused
	 */
	public static void main(String[] args) {
		GameEngine game = new GameEngine();
		game.playGame();
	}

	/**
	 * Constructor for GameEngine. It creates a new LevelEngine
	 */
	public GameEngine() {
		levelData = new LevelSetup();
	}

	/**
	 * Plays the game. Continues until either all levels have been completed or the
	 * player has been killed. Program exits when game is over.
	 */
	public void playGame() {
		// Give player a default location of 0
		player = new Player(0);
		
		displayInstructions() ;
		
		// play through the levels until all done or player dies
		while (currentLevel < NUM_LEVELS && !player.isDead()) {
			currentLevel++;
			setupLevel(currentLevel); // setup the next level

			playLevel(); // and play that level
		}

		// If reach this point, either all levels were completed OR
		// player is dead
		if (player.isDead())
			System.out.println("Too bad, you lose...");
		else
			System.out.println("Congratulations, you won!");
		System.exit(0);
	}

	/**
	 * Display the instructions
	 * 
	 * @param gameBoard - board so we know what pieces to display info on
	 */
	private void displayInstructions() {
		
		System.out.println("* The Game KerPlop *");
		System.out.println("The object of the game is to capture prizes without being killed.");
		System.out.println("You need " + Player.POINTS_TO_ADVANCE + 
				" points to advance, you die after " + Player.POINTS_TO_DIE + " hits.") ;
		System.out.println("P - Player (you)");
		System.out.println(sniper.getSymbol()+" - "+sniper.getName()+" "+sniper.description);
		System.out.println(robber.getSymbol()+" - "+robber.getName()+" "+robber.description);
		System.out.println(coin_1.getSymbol()+" - "+coin_1.getName()+" "+coin_1.description);
		System.out.println(treasure.getSymbol()+" - "+treasure.getName()+" "+treasure.description);
		System.out.println(annihilator.getSymbol()+" - "+annihilator.getName()+" "+annihilator.description);
		System.out.println(doormat.symbol+" - "+doormat.name+" "+doormat.description);
	
	}
	

	/**
	 * Plays the game for one level.
	 * 
	 * During each round, the board is displayed, the player enters a movement
	 * option, the player's location is updated, then the player interacts with any
	 * pieces in the interactingPieces list. Moveable piece locations are then
	 * updated for the next round. This continues until the level is finished.
	 */
	public void playLevel() {
		while (!levelFinished()) {
			displayBoard(); // update the display

			// prompt and update the player's location
			player.doMove(gameBoard);
			
			movePieces(); // then move the pieces

			interaction(); // process interactions after player moves

			
		}
	}

	/**
	 * Should be called at the beginning of every level (including beginning of
	 * program) to set up the data for that level.
	 * 
	 * @param levelNum The number of the level to be loaded. Level number should be
	 *                 from 1 to GameEngine.NUM_LEVELS
	 */
	public void setupLevel(int levelNum) {
		// LevelEngine needs to create the specified level
		levelData.createLevel(levelNum);

		// get the data for the level
		gameBoard = levelData.getBoard();
		movingPieces = levelData.getMovingPieces();
		interactingPieces = levelData.getInteractingPieces();

		// reset player statistics, starting location determined
		// by level engine
		player.resetLevel(levelData.getPlayerStartLoc());
	}

	/**
	 * Prints a representation of the board. A null represents an empty space (drawn
	 * as just a space). All other objects must be Drawable, so that the draw method
	 * can be used.
	 */
	public void displayBoard() {
		for (int i = 0; i < gameBoard.length; i++) {
			// Ensure player is always drawn, even if on top of another piece
			// Note, only 1 piece per location except player can be on top of another
			if (i == player.getLocation())
				player.draw();
			else if(i==sniper.getLocation()) {
				System.out.print(sniper.getSymbol());
	
			}
			else if(i==treasure.getLocation())
				System.out.print(treasure.getSymbol());
			else if(i==robber.getLocation())
				System.out.print(robber.getSymbol());
			else if(i==coin_1.getLocation()) {
				System.out.print(coin_1.getSymbol());		
				
			}
			else if(i==coin_2.getLocation()) {
				System.out.print(coin_2.getSymbol());		
				
			}
			else if(i==doormat.getLocation()) {
				System.out.print(doormat.getSymbol());		
				
			}
			else if(i==doormat_2.getLocation()) {
				System.out.print(doormat.getSymbol());		
				
			}
			
			else if(i==annihilator.getLocation()) {
				System.out.print(annihilator.getSymbol());		
			}
			else if (gameBoard[i] == null)
				System.out.print(' ');
			else
				gameBoard[i].draw();
			System.out.print('|');
		}
		System.out.println();
	}

	/**
	 * Calls the move method for each Moveable piece. All Moveable pieces should be
	 * placed in the movingPieces list.
	 */
	public void movePieces() {
		for (Moveable piece : movingPieces) {
			piece.move(gameBoard, player.getLocation());
		}
	}

	/**
	 * Calls the interact method for each interactingPiece (i.e., GamePiece) All
	 * interacting pieces should be placed in the interactingPieces list. GameEngine
	 * will display a message and take the appropriate action based on the
	 * InteractionResult (e.g., sets player status to DEAD if the result is
	 * InteractionResult.KILL).
	 */
	public void interaction() {
		for (GamePiece piece : interactingPieces) {
			InteractionResult result = piece.interact(gameBoard, player.getLocation());
			if (result == InteractionResult.GET_POINT) {
				player.addPoint();
				System.out.println("\nYou just won a prize!\n");
			}
			if (result == InteractionResult.HIT) {
				player.takeDamage();
				System.out.println("\nYou just took a hit!\n");
				if (player.isDead()) {
					System.out.println("Too many hits, you are dead");
					// can only be killed once
					break;
				}
			}
			if (result == InteractionResult.KILL) {
				player.killed();
				System.out.println("\nKerPolp! Something just killed you!\n");
				// can only be killed once
				break;
			}
			if (result == InteractionResult.ADVANCE) {
				player.wonAdvance();
				System.out.println("\nGood news, you have won an advance!\n");
				// can only advance once
				break;
			}
		}
	}

	/**
	 * Determines if this level is complete. Will be complete if player is advancing
	 * (either by interaction with a game piece or accumulating points) or dead
	 * (either by interaction with a game piece or accumulating too many hits).
	 * 
	 * @return true if player advances or was killed, false otherwise
	 */
	public boolean levelFinished() {
		if (player.canAdvance()) {
			if (currentLevel < NUM_LEVELS)
				System.out.println("Advancing to next level...\n");
			return true;
		}
		if (player.isDead()) {
			return true;
		}
		return false;
	}

}
