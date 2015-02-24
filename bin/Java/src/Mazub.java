import be.kuleuven.cs.som.annotate.Basic;


/**
 * Mazub is a class to define the player character (Mazub) in the game "Jumping Alien". 
 * 
 * @invar The left bottom pixel of Mazub must always be inside the boundaries of the world. | isValidPositionX(getPositionX())&& isValidPositionY(getPositionY())
 * @invar Mazub must have a non-negative heigth and width. The width and height must be valid | isValidHeight(getHeight())&isValidWidth(getWidth())
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
	/**
	 * Returnig the current width of Mazub.
	 * The width may change during the game, example when ducking.
	 * @return
	 */
	@Basic 
	public int getWidth(){
		return this.width;
	}
	/**
	 * Set the width of this Mazub to the given width.
	 * @param width The new width of this Mazub. 
	 * @throws IllegalLengthException if the supplied width is not valid. | if (!isValidWidth(width))
	 * @post The new width of this Mazub equals the given width. | new.getWidth() == width
	 */
	@Basic
	public void setWidth(int width) throws IllegalLengthException{
		if (! isValidWidth(width))
			throw new IllegalLengthException(width);
		this.width = width;
	}
	/**
	 * A method checking whether a given width is possible. 
	 * @param width The width to be checked.
	 * @return Width must be a valid for this Mazub. 
	 */
	public static boolean isValidWidth(int width){
		return width >0; // We can change this method later, with an extra condition (eg width<getMaxPositionX())
	}
	/**
	 * A variable storing the width of Mazub.
	 */
	private int width;
	
	/**
	 * Returning the current height of Mazub.
	 * The width may change during the game, example when ducking.
	 * @return
	 */
	@Basic
	public int getHeight(){
		return this.height;
	}
	/**
	 * 
	 * @param height
	 * @throw IllegalLengthException if the given height is not valid | not isValidHeight(height)
	 * @post The new height of this Mazub equals the given height | new.getHeight() == height
	 */
	@Basic
	public void setHeight(int height) throws IllegalLengthException{
		if (!isValidHeigth(height))
			throw new IllegalLengthException(height);
		this.height = height;
	}
	
	/**
	 * Checking whether a given height is valid.
	 * @param height The height to be checked.
	 * @return True if the width is valid
	 */
	public boolean isValidHeight(int height){
		return height >0;
	}
	/**
	 * A variable storing the current height of this Mazub.
	 */
	private int height;
	
	// Nominal way
	public static void calculateNewVelocity(double currentVelocity,double currentAcceleration){
		
	}
	public static void calculateNewPosition(double currentPosition,double currentVelocity,double currentAcceleration){}
	/**
	 * @post The new status of ismoving equals true | new.isMoving() == true;
	 */
	public void startMove(){
		ismoving = true;
	}
	/**
	 * @post The new status of ismoving equals false | new.isMoving() == false;
	 */
	public void endMove(){
		ismoving = false;
	}
	/**
	 * Return the current moving status of this Mazub.
	 * @return
	 */
	public boolean isMoving(){
		return this.ismoving;
	}
	/**
	 * A variable storring the current moving status of this Mazub
	 */
	private boolean ismoving;
	/**
	 * A method returning the horizontal start speed of this Mazub in m/s. This start speed is always above 1 m/s. 
	 * @return
	 */
	@Basic
	public double getHorizontalStartSpeed(){
		return this.horizontalstartspeed;
	}
	/**
	 * A method to set the initial horizontal speed to a given speed.
	 * @param speed
	 * @post if speed <1 
	 * 			then this.horizontalstartspeed = 1;
	 * @post if speed > 1
	 * 			then this.horizontalstartspeed = speed; 
	 */
	@Basic
	public void setHorizontalStartSpeed(double speed){
		if (speed<1)
			this.horizontalstartspeed = 1;
		else
			this.horizontalstartspeed = speed;
	}
	/**
	 * A method storring the horizontal start speed of this Mazub.
	 */
	private double horizontalstartspeed;
	/**
	 * A method returning the horizontal acceleration in m/(s^2) of all Mazubs.
	 * @return
	 */
	@Basic
	public static double getHorizontalAcceleration(){
		return horizontalacceleration;
	}
	/**
	 * A method to set the horizontal acceleration to a given value
	 * @param acceleration
	 * @post if acceleration<0 
	 * 			then horizontalacceleration = 0;
	 * @post if acceleration >0
	 * 			then horizontalacceleration = acceleration; 
	 */
	@Basic
	public static void setHorizontalAcceleration(double acceleration){
		if (acceleration<0)
			horizontalacceleration = 0;
		else
			horizontalacceleration = acceleration;
	}
	/**
	 * A variable storing the horizontal acceleration of all Mazubs.
	 */
	private static double horizontalacceleration;
	
	/**
	 * A method returning the maximum horizontal speed when running in m/s. Is always bigger than the start speed
	 */
	public double  getMaxSpeedHorizontalWhenRunning(){
		return this.maxspeedhorizontalwhenrunning;
	}
	/**
	 * 
	 * @param speed
	 * @post if speed < this.getHorizontalStartSpeed()
	 * 			then this.maxspeedhorizontalwhenrunning = this.getHorizontalStartSpeed()
	 * @post if speed > this.getHorizontalStartSpeed()
	 * 			then this.maxspeedhorizontalwhenrunning =speed;
	 * 
	 */
	public void setMaxSpeedHorizontalWhenRunning(int speed){
		this.maxspeedhorizontalwhenrunning = Math.max(this.getHorizontalStartSpeed(),speed);
	}
	/**
	 * A variable storing the maximum horizontal speed when running in m/s.
	 */
	private double maxspeedhorizontalwhenrunning;
	@Basic
	public double getMaxSpeedHorizontal(){
		return this.maxspeedhorizontal;
	}
	@Basic
	public void setMaxSpeedHorizontal(){}
	private double maxspeedhorizontal;
	/**
	 * Changing a given double in meters to a double in pixels 
	 * @param metric The length/speed/velocity expressed in meters, m/s, m/(s^2) that has to be changed to pixels, pixels/s,pixels/(s^2) 
	 * @return metric*
	 */
	public static int changeMetricToPixel(double metric){
		return (int)(metric *100);
	}
	// Defensive programming
	public void advanceTime(double time){}
	
	// Defensively
	public void startJump(){}
	public void endJup(){}
	/**
	 * Returning the vertical acceleration of this Mazub. Equals the gravity constant.
	 * @return
	 */
	private static double getAccelerationVertical(){
		return -10;
	}
	public static double getStartMovingVelocityVertical(){
		return 8;
	}
	public void startDuck(){}
	public void endDuck(){}
	/**
	 * Returning the maximum speed of Mazub when he is ducking.
	 * @return
	 */
	public static double getMaxSpeedHorizontalWhenDucking(){
		return 1;
	}
	//Nominal
	public Spite getCurrentSprite(){}
}
