/**
 * A class of exceptions signaling illegal x coordinates of the LB pixel of Mazub.
 * 	Each illegal positionx exception involves the illegal x coordinate.
 * 
 * @version 1.0
 * @author Pieter
 *
 */
public class IllegalPositionXException extends RuntimeException{
	/**
	 * 
	 * @param positionx 
	 * 			The x coordinate for this new illegal positionx exception
	 * @post The positionx of this new illegal positionx exception is equal to the given positionx. | new.getPositionX() = positionx
	 */
	public IllegalPositionXException(int positionx) {
		this.positionx = positionx;
	}
	/**
	 * Return the position x of this illegal positionx exception.
	 * @return
	 */
	@Basic @Raw @Immutable
	public int getPositionX(){
		return this.positionx;
	}
	/**
	 * Varible registering the positionx of this illegal positionx exception/
	 */
	private int positionx;
}
