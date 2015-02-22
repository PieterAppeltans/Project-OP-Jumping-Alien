import be.kuleuven.cs.som.annotate.Basic;


/**
 * Mazub is a class to define the player character (Mazub) in the game "Jumping Alien". 
 * 
 * @invar The left bottom pixel of Mazub must always be inside the boundaries of the world. | isValidPositionX(getPositionX())&& isValidPositionY(getPositionY())
 * 
 *
 * 
 * @invar Mazub is always green.
 * @author Pieter
 *
 */
/*This character has a position(x,y), denoting the pixel occupied by the bottom-left pixel of the image. 
 * It also has a height and width, which may change during game (by example while duking, he become smaller).
 * 
 * 
*/ 
public class Mazub {
	public Mazub(){}
	
	// Defensive way
	/**
	 * Return the current x coordinate of the LB pixel of Mazub.
	 * 
	 */
	@Basic
	public int getPositionX(){
		return this.positionx;
	}
	
	
	/**
	 * Set the x positon of this Mazub to the given positonx
	 * @param positionx The new x position for this Mazub
	 * @post The new x position of this mazub equals the given positionx. | new.getPositionX() == positionx
	 * @throws IllegalPositionXException if positionx not in the boundaries of the gameworld. | if (!isValidPositionX(positionx))
	 */
	@Basic
	public void setPositionX(int positionx) throws IllegalPositionXException {
		if (! isValidPositionX(positionx))
			throw new IllegalPositionXException(positionx);
		this.positionx = positionx;
	}
	/**
	 * A method to check whether a is given x coordinate of the position of the LB pixel of Mazub is valid. This position of the LB of Mazub
	 *  must always be inside the boundaries of the world.   
	 * @param positionx The x coordinate that have to be checked.
	 * @return True if x is bigger or equal to 0 and smaller or equal to 1023 | result = (positionx>=0) && (positionx<=1023);
	 */
	public static boolean isValidPositionX(int positionx){
		return (positionx>=getMinPositionX()) && (positionx<=getMaxPositionX());
	}
	/**
	 * Returning the left boundary of the game world.
	 * @return
	 */
	public static int getMinPositionX(){
		return 0;
	}
	/**
	 * Returning the right boundary of the game world.
	 * @return
	 */
	public static int getMaxPositionX(){
		return 1023;
	}
	/**
	 * A variable registering the current positionx of this Mazub.
	 */
	private int positionx;
	
	/**
	 * Return the y coordinate of the LB pixel of this Mazub.
	 * @return
	 */
	@Basic
	public int getPositionY(){
		return this.positiony;
	}
	
	/**
	 * Set the positiony of Mazub to the given positiony.
	 * @param postiony The new y coordinate of the position of Mazub.
	 * @throws IllegalPositionYExeption if the positiony not in the boundary of the game world. |if (!isValidPositionY(positiony))
	 * @post The new positiony equals the given positiony | new.getPositionY() == positiony
	 * 
	 */
	@Basic
	public void setPositionY(int positiony) throws IllegalPositionYException{
		if (!isValidPositionY(positiony))
			throw new IllegalPositionYException(positiony);
		this.positiony = positiony;
	}
	public static boolean isValidPositionY(int positiony){
		return (positiony>=getMinPositionY()) && (positiony<=getMaxPositionY());
	}
	/**
	 * Returning the bottom boundary of the game world.
	 * @return
	 */
	public static int getMinPositionY(){
		return 0;
	}
	/**
	 * Returning the top boundary of the game world.
	 * @return
	 */
	public static int getMaxPositionY(){
		return 767;
	}
	/**
	 * A variable registering the current positiony of this Mazub.
	 */
	private int positiony;
	
	@Basic 
	public int getWidth(){
		return this.width;
	}
	
	@Basic
	public void setWidth(){}
	/**
	 * A variable storing the width of Mazub.
	 */
	private int width;
	@Basic
	public int getHeigth(){
		return this.heigth;
	}
	@Basic
	public void setHeigth(int height){}
	private int heigth;
	
	// Nominal way
	
	public void startMove(){}
	public void endMove(){}
	@Basic
	public double getMaximumHorizontalVelocity(){
		return this.maximumhorizontalvelocity;
	}
	@Basic
	public void setMaximumHorizontalVelocity(){}
	private double maximumhorizontalvelocity;
	public void advanceTime(){}
	public void startJump(){}
	public void endJup(){}
	public void startDuck(){}
	public void endDuck(){}
}
