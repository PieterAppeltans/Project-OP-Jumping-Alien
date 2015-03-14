package jumpingalien.model;
import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Immutable;
import be.kuleuven.cs.som.annotate.Raw;

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
	 * Variable storing the current version ID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * @param positionx 
	 * 			The x coordinate for this new illegal positionx exception
	 * @post The positionx of this new illegal positionx exception is equal to the given positionx. | new.getPositionX() = positionx
	 */
	public IllegalPositionXException(double positionx) {
		this.positionx = positionx;
	}
	/**
	 * Return the position x of this illegal positionx exception.
	 * @return
	 */
	@Basic @Raw @Immutable
	public double getPositionX(){
		return this.positionx;
	}
	/**
	 * Varible registering the positionx of this illegal positionx exception/
	 */
	private double positionx;
}
