import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Immutable;


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
	
	public double getCurrentPositionX(){
		return this.currentpositionx;
	}
	public void setCurrentPositionX(double positionx) throws IllegalPositionXException {
		if (! isValidCurrentPositionX(positionx))
			throw new IllegalPositionXException(positionx);
		else
			this.currentpositionx = positionx;
			
		
	}
	public boolean isValidCurrentPositionX(double positionx){
		return (positionx > changePixeltoMetric(getMinPositionX()) && positionx < changePixeltoMetric(getMaxPositionX()));
	}
	private double currentpositionx;
	/**
	 * Return the current x coordinate of the LB pixel of Mazub.
	 * 
	 */
	@Basic
	public int getPositionX(){
		return changeMetricToPixel(getCurrentPositionX());
	}
	
	/**
	 * Set the x positon of this Mazub to the given positonx
	 * @param positionx The new x position for this Mazub
	 * @post The new x position of this mazub equals the given positionx. | new.getPositionX() == positionx
	 * @throws IllegalPositionXException if positionx not in the boundaries of the gameworld. | if (!isValidPositionX(positionx))
	 */
	@Basic
	/*private void setPositionX(int positionx){
		this.positionx = positionx;
	}*/
	/**
	 * A method to check whether a is given x coordinate of the position of the LB pixel of Mazub is valid. This position of the LB of Mazub
	 *  must always be inside the boundaries of the world.   
	 * @param positionx The x coordinate that have to be checked.
	 * @return True if x is bigger or equal to 0 and smaller or equal to 1023 | result = (positionx>=0) && (positionx<=1023);
	 */
	/*
	public static boolean isValidPositionX(int positionx){
		return (positionx>=getMinPositionX()) && (positionx<=getMaxPositionX());
	}*/
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
	
	public double getCurrentPositionY(){
		return this.currentpositiony;
	}
	public void setCurrentPositionY(double positiony) throws IllegalPositionYException {
		if (! isValidCurrentPositionY(positiony))
			throw new IllegalPositionYException(positiony);
		else
			this.currentpositionx = positiony;
			this.setPositionY(changeMetricToPixel(positiony));
		
	}
	public boolean isValidCurrentPositionY(double positiony){
		return (positiony > changePixeltoMetric(getMinPositionY()) && positiony < changePixeltoMetric(getMaxPositionY()));
	}
	private double currentpositiony;
	
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
	 * Returning the position of the LB pixel of this Mazub in an array {x,y}.
	 * @return
	 */
	public int[] getLocation(){
		int[] array = {getPositionX(),getPositionY()};
		return array;
	}
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
		if (!isValidHeight(height))
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
	public int [] getSize(){
		int[] array = {getWidth(),getHeight()}; 
		return array;
	}
	// Defensive programming
	public void advanceTime(double time) throws IllegalTimeException{
			if (!isValidTime(time))
				throw new IllegalTimeException(time);
			try{
			if (isMoving())
				setCurrentSpeedX(calculateNewSpeedX(time));
				setCurrentPositionX(calculateNewPositionX(time));
				}
			catch (IllegalPositionXException exc) {
				if (exc.getPositionX()> changePixeltoMetric(getMaxPositionX()))
					this.setCurrentPositionX(getMaxPositionX());
				if (exc.getPositionX()< changePixeltoMetric(getMinPositionX()))
					this.setCurrentPositionX(getMinPositionX());
			}
		}
	public boolean isValidTime(double time){
		return time>0 && time<0.2;
	}
	// Totaal Programeren
	/** 
	 * @param currentVelocity
	 * @param currentAcceleration
	 * @param time
	 * @return
	 */
	public  double calculateNewSpeedX(double time){
		return  this.getCurrentSpeedX() + this.getCurrentAccelerationX() * time;
		}
		
	
	
	public double calculateNewPositionX(double time){
		return this.getCurrentPositionX() +  this.getCurrentSpeedX() * time + 0.5 * this.getCurrentAccelerationX() * Math.pow(time,2);
		
	}
	// Nominaal - StartMove() en EndMove
	/**
	 * @pre The provided direction is not null | direction != null
	 * @post The new status of ismoving equals true | new.isMoving() == true;
	 * @post The current velocity equals the start velocity (negative if moving to the left , positive if moving to the right)
	 *			| if direction == LEFT then new.getCurrentSpeedX() == - this.getStartSpeedX()
	 *			| if direction == RIGHT then new.getCurrentSpeedX() == this.getStartSpeedX()
	 */
	public void startMove(Direction direction){
		assert direction != null;
		ismoving = true;
		setDirection(direction);
		setCurrentSpeedX(direction.getSign()*this.getStartSpeedX());
		setCurrentAccelerationX(direction.getSign() * this.getAccelerationX());
	}
	/**
	 * @post The new status of ismoving equals false | new.isMoving() == false;
	 */
	public void endMove(){
		ismoving = false;
		setDirection(null);
		setCurrentSpeedX(0.0);
		setCurrentAccelerationX(0.0);
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
	public Direction getDirection(){
		return this.direction;
	}
	
	/**
	 * @pre The given direction may not equal null when moving | if isMoving() then direction != null
	 * @pre The given direction must equal null when not moving. | if !isMoving() then direction == null
	 * @param direction
	 */
	public void setDirection(Direction direction){
		assert isValidDirection(direction);
		this.direction = direction;
	}
	public boolean isValidDirection(Direction direction){
		return (this.isMoving() && direction != null ) || (!isMoving() && direction == null);
	}
	private Direction direction;
	/**
	 * Return the current speed of this Mazub in the x-direction
	 * @return
	 */
	public double getCurrentSpeedX(){
		return this.currentspeedx;
	}
	public void setCurrentSpeedX(double speed){
		if (Math.abs(speed) > this.getMaxSpeedX() && this.isMoving())
			this.currentspeedx = getMaxSpeedX() * this.getDirection().getSign();
		else
			this.currentspeedx = speed;
		
	}
	public boolean isValidCurrentSpeedX(double speed){
		return speed ==0 || (Math.abs(speed) <= getMaxSpeedX() && Math.abs(speed) >= getStartSpeedX()); 
	}
	/**
	 * A variable storring the current speed of this Mazub
	 */
	private double currentspeedx;
	/**
	 * A method returning the horizontal start speed of this Mazub in m/s. This start speed is always above 1 m/s. 
	 * @return
	 */
	@Basic
	public double getStartSpeedX(){
		return this.startspeedx;
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
	public void setStartSpeedX(double speed){
		if (speed<1)
			this.startspeedx = 1;
		else
			this.startspeedx = speed;
	}
	/**
	 * A method storring the horizontal start speed of this Mazub.
	 */
	private double startspeedx;
	public double getCurrentAccelerationX(){
		return this.currentaccelerationx;
	}
	public void setCurrentAccelerationX(double acceleration){
		if (Math.abs(acceleration) == getAccelerationX())
			this.currentaccelerationx = acceleration;
		else
			this.currentaccelerationx= 0.0;
		
	}
	public boolean isValidCurrentAccelerationX(double acceleration){
		return acceleration ==0 || Math.abs(acceleration) == getAccelerationX();
	}
	/**
	 * A variable storring the current acceleration in x direction.
	 */
	private double currentaccelerationx;
	/**
	 * A method returning the horizontal acceleration in m/(s^2) of all Mazubs.
	 * @return
	 */
	@Basic
	public static double getAccelerationX(){
		return accelerationx;
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
	public static void setAccelerationX(double acceleration){
		if (acceleration<0)
			accelerationx = 0;
		else
			accelerationx = acceleration;
	}
	/**
	 * A variable storing the horizontal acceleration of all Mazubs.
	 */
	private static double accelerationx;
	@Basic
	public double getMaxSpeedX(){
		return this.maxspeedx;
	}
	@Basic
	public void setMaxSpeedX(double speed){
		this.maxspeedx = Math.abs(speed);
	}
	private double maxspeedx;
	/**
	 * A method returning the maximum horizontal speed when running in m/s. Is always bigger than the start speed
	 */
	public double  getMaxSpeedHorizontalWhenRunning(){
		return this.maxspeedhorizontalwhenrunning;
	}
	/**
	 * 
	 * @param speed
	 * @post if Math.abs(speed) < this.getHorizontalStartSpeed()
	 * 			then this.maxspeedhorizontalwhenrunning = this.getHorizontalStartSpeed()
	 * @post if Math.abs(speed) > this.getHorizontalStartSpeed()
	 * 			then this.maxspeedhorizontalwhenrunning = math.abs(speed);
	 * 
	 */
	public void setMaxSpeedHorizontalWhenRunning(int speed){
		this.maxspeedhorizontalwhenrunning = Math.max(this.getHorizontalStartSpeed(),Math.abs(speed));
	}
	/**
	 * A variable storing the maximum horizontal speed when running in m/s.
	 */
	private double maxspeedhorizontalwhenrunning;
	/**
	 * Returning the position of this Mazub in double in meters
	 * @return
	 */
	
	
	public double calculateNewSpeedY(double time){
		return this.getCurrentSpeedY() + getAccelerationY() * Math.abs(time);
	}
	public double calculateNewPositionY(double time){
		return 0.0;
	}
	// Defensively
	public void startJump(){
		isJumping = true;
		this.setCurrentSpeedY(getStartSpeedY());
	}
	public void endJump() {
		if (this.getCurrentSpeedY() <0)
		else
			this.setCurrentSpeedY(0.0);
	}
	private boolean isJumping;
	
	// TOTAAL PROGRAMEREN
	public double getCurrentSpeedY(){
		return this.currentspeedy;
	}
	public void setCurrentSpeedY(double speed){
		this.currentspeedy(speed);
	}
	private double currentspeedy;
	/**
	 * Returning the vertical acceleration of this Mazub. Equals the gravity constant.
	 * @return
	 */
    @Basic
	private static double getAccelerationY(){
		return -10;
	}
	@Basic
	public static double getStartSpeedY(){
		return 8;
	}
	public void startDuck(int width,int height){
		try{
			this.isducking = true;
			setMaxSpeedHorizontal(getMaxSpeedHorizontalWhenDucking());
			setWidth(width);
			setHeight(height);
		}
		catch (IllegalLengthExcxeption exc){
			1;
		}
	}
	public void endDuck(int width,int height){
		try{
			this.isducking = false;
			setMaxSpeedHorizontal(getMaxSpeedHorizontalWhenRunning());
			setWidth(width);
			setHeight(heiht);
		}
		catch (IllegalLengthException exc){}
	}
	public boolean isDucking(){
		return this.isducking;}
	
	private boolean isducking;
	/**
	 * Returning the maximum speed of Mazub when he is ducking.
	 * @return
	 */
	public static double getMaxSpeedHorizontalWhenDucking(){
		return 1;
	}

	/**
	 * Changing a given in in pixels to a double in metric
	 * @param pixel The length expressed in pixel
	 * @return The length in meters
	 */
	public static double changePixeltoMetric(int pixel){
		return pixel*(.01);}
	
	/**
	 * Changing a given double in meters to a int in pixels 
	 * @param metric The length/speed/velocity expressed in meters, m/s, m/(s^2) that has to be changed to pixels, pixels/s,pixels/(s^2) 
	 * @return The lengt/speed/velocity in pixels
	 */
	public static int changeMetricToPixel(double metric){
		return (int)(metric *100);
	}
	//Nominal
	private 
	public Sprite getCurrentSprite(){
		
	}
}
