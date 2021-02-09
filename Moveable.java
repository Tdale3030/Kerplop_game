package gameEngine;

/**
 * To handle all moveable pieces
 * 
 * @author Tyner Dale
 * @author John Reimann
 * 
 */
//public interface Moveable extends Drawable{
public interface Moveable {
	
	/**
	 * move takes the game board and the player's location and 
	 * updates the board (i.e., moves this piece to a new
	 * location). 
	 * 
	 * NOTE: It is possible with this function signature for a piece
	 * to move other pieces. This could make for interesting game play..
	 * but should be done with caution! If safety becomes a concern,
	 * this method could be modified to return the new location, with
	 * additional calls in GameEngine to move the piece. 
	 * 
	 * @param gameBoard board with pieces/null that is in each location
	 * @param playerLocation players current location on board
	 * 
	 */
	public void move(Drawable[] gameBoard, int playerLocation);
}