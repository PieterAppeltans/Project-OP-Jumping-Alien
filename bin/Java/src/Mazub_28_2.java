import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Immutable;


/**
 * Mazub is a class to define the player character (Mazub) in the game "Jumping Alien". 
 * 
 * @invar The left bottom pixel of Mazub must always be inside the boundaries of the world. | isValidPositionX(getPositionX())&& isValidPositionY(getPositionY())
 * @invar Mazub must have a non-negative heigth and width. The width and height must be valid | isValidHeight(getHeight())&isValidWidth(getWidth())
 * @invar The maximum speed of each Mazub must be above the initial velocity of that Mazub | isValidMaxSpeedX(getMaxSpeedX())
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
	/**
	 * @effect Set the start speed in the horizontal direction at the given speed in m/s | setStartSpeedX(startspeedx)
	 * @effect Set the maximum speed in the horizontal direction at the given speed in m/s | setMaxSpeedX(maxspeedx)
	 * @effect Set the accelereation of all the Mazubs in the horizontal direction at the given acceleration in m/s | setAccelerationX(accelerationx)
	 */
	public Mazub(double startspeedx,double maxspeedx,double accelerationx){
		this.setStartSpeedX(startspeedx);
		this.setMaxSpeedX(maxspeedx);
		setAccelerationX(accelerationx);
	}
	/**
	 * @effect Create a Mazub with a start speed (horizontal) of 1.0 m/s, a maximum speed (horizontal) of 3.0 m/s and set the acceleration (horizontal)
	 * 			of all the Mazubs to 0.9 m/s^2
	 */
	public Mazub(){
		new Mazub(1.0,3.0,0.9);
	}
	/**
	 * Return the x coordinate of the LB of Mazub in meters. 
	 * 
	 */
	public double getCurrentPositionX(){
		return this.currentpositionx;
	}
	/**
	 * Set the x-position of this Mazub to the given positonx.
	 * @param positionx The new x position for this Mazub.
	 * @post The new x position of this Mazub equals the given positionx. | new.getPositionX() == positionx
	 * @throws IllegalPositionXException if positionx not in the boundaries of the gameworld. | if (!isValidCurrentPositionX(positionx))
	 */
	public void setCurrentPositionX(double positionx) throws IllegalPositionXException {
		if (! isValidCurrentPositionX(positionx))
			throw new IllegalPositionXException(positionx);
		else
			this.currentpositionx = positionx;
			
		
	}
	/**
	 * 
	 * @param positionx The position that have to be checked.
	 * @return True if the supplied position is in the boundaries of the gameworld. | result = (positionx > changePixeltoMetric(getMinPositionX()) && positionx < changePixeltoMetric(getMaxPositionX()))
	 * 
	 */
	public static boolean isValidCurrentPositionX(double positionx){
		return (positionx > changePixeltoMetric(getMinPositionX()) && positionx < changePixeltoMetric(getMaxPositionX()));
	}
	/**
	 * A variable storing the current x coordinate of the LB of this Mazub.
	 */
	private double currentpositionx;
	/**
	 * Return the current x coordinate of the LB pixel of Mazub in pixels.
	 * 
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
				setCurrentPositionY(calculateNewPositionY(time));
				setCurrentSpeedY(calculateNewSpeedY(time));}
			catch(IllegalPositionYException exc){
				if (exc.getPositionY() > changePixeltoMetric(getMaxPositionY()))
					setCurrentPositionY(changePixeltoMetric(getMaxPositionY()));
				if (exc.getPositionY() < changePixeltoMetric(getMinPositionY()))
					setCurrentPositionY(changePixeltoMetric(getMinPositionY()));
			}
			try{
			if (isMoving())
				setCurrentPositionX(calculateNewPositionX(time));
				setCurrentSpeedX(calculateNewSpeedX(time));}
			catch (IllegalPositionXException exc2) {
				if (exc2.getPositionX()> changePixeltoMetric(getMaxPositionX()))
					this.setCurrentPositionX(getMaxPositionX());
				if (exc2.getPositionX()< changePixeltoMetric(getMinPositionX()))
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
		setCurrentAccelerationX(direction.getSign() * getAccelerationX());
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
	/**
	 * 
	 * @param speed The speed to which the current x speed of this Mazub must be change
	 * @post if this Mazub is not moving, it new speed equals O. | if (! isMoving()) then new.getCurrentSpeedX() == speed
	 * @post if the given speed in absolute value is greater than the max speed then the new speed equals the maximum speed in the direction of that speed. 
	 * 		| if (abs(speed) > getMaxSpeedX() then new.getCurrentSpeedX == this.getMaxSpeedX() * Math.signum(speed)
	 * @post if the given speed in absolute value is smaller than the initial speed then the new speed equals the initial speed in the direction of that speed
	 * 		| if (abs(speed)) < getStartSpeedX() then new.getCurrentSpeedX == this.getMaxSpeedX() * Math.signum(speed)
	 * @post else The new value of current speed equals the given speed. | new.getCurrentSpeed == speed.
	 */
	public void setCurrentSpeedX(double speed){
		if (! this.isMoving())
			this.currentspeedx = 0;
		else if (Math.abs(speed) > this.getMaxSpeedX())
			this.currentspeedx = this.getMaxSpeedX() * Math.signum(speed);
		else if (Math.abs(speed) <= this.getStartSpeedX())
			this.currentspeedx = this.getStartSpeedX() * Math.signum(speed);
		else
			this.currentspeedx = speed;
		
	}
	/**
	 * @return If this Mazub is not moving the current speed must equals 0 m/s | if (!isMoving()) the this.getCurrentSpeedX == 0
	 * @return If this Mazub is moving, the absolute value of its speed must be between the maxspeed and the initial speel.
	 * 			| if isMoving() | (Math.abs(this.getCurrentSpeedX()) <= this.getMaxSpeedX() && Math.abs(this.getCurrentSpeedX()) >= this.getStartSpeedX()) 
	 */
	public boolean isValidCurrentSpeedX(){
		return (!this.isMoving() && this.getCurrentSpeedX()==0 ) || ((Math.abs(this.getCurrentSpeedX()) <= this.getMaxSpeedX() && Math.abs(this.getCurrentSpeedX()) >= this.getStartSpeedX())&& this.isMoving()); 
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
	 * 
	 * @param speed The speed to be checked.
	 * @return The start speed must always above 1 m/s. | result == speed > 1
	 */
	public boolean isValidStartSpeedX(double speed){
		return speed >1;
	}
	/**
	 * A variable storring the horizontal start speed of this Mazub.
	 */
	private double startspeedx;
	/**
	 * A method returning the current acceleration in the horizontal direction.
	 * @return
	 */
	public double getCurrentAccelerationX(){
		return this.currentaccelerationx;
	}
	/**
	 * A method to set current acceleration to the given acceleration.
	 * @param acceleration
	 * @post if the given acceleration in absolute value equals the acceleration in horizontal direction then the new value of the current acceleration equals the given acceleration.
	 * 		| if abs(acceleration) == getCurrentAcceleration() then new.getCurrentAccelerationX() == acceleration 
	 * @post if the given acceleration in absolute value doesn't equal the acceleration in horizontal direcion then the new value of the current acceleration equals the acceleration in the horizontal direction
	 * 		in the direction of the given acceleration. | new.getCurrentAccelerationX() == getAccelerationX() * signum(acceleration)
	 * @post if the given acceleration equals 0 then the new value of the acceleration equals 0 | new.getCurrentAccelerationX() == 0
	 */
	public void setCurrentAccelerationX(double acceleration){
		if (Math.abs(acceleration) == getAccelerationX())
				this.currentaccelerationx = acceleration;
		else if (acceleration !=0)
			this.currentaccelerationx = getAccelerationX()*Math.signum(acceleration);
		else if (acceleration == 0)
			this.currentaccelerationx = 0;
			
	}
	/**
	 * 
	 * @param acceleration
	 * @return if this Mazub is not moving, its current acceleration must equal 0. | if (!isMoving()) then acceleration == 0.
	 * @return if this Mazub is moving, its current acceleration must in absolute value equal the accelertion in the horizontal direction
	 * 			| if isMoving() then Math.abs(acceleration) == getAccelerationX() 
	 */
	public boolean isValidCurrentAccelerationX(double acceleration){
		return (!isMoving() && acceleration ==0) || (isMoving() && Math.abs(acceleration) == getAccelerationX());
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
	/**
	 * A method returning the maximum speed in the horizontal direction in m/s
	 * @return
	 */
	@Basic
	public double getMaxSpeedX(){
		return this.maxspeedx;
	}
	/**
	 * A method to set the maximum speed of this Mazub in the horizontal direction
	 * @param speed
	 * @post If the given speed is below the initial speed then the new maximum speed equals the initial speed. |if speed < this.getStartSpeedX() then new.getMaxSpeedX == speed 
	 * @post If the given speed is above the intial speed then the new maximum speed equals the given speed. |if speed > this.getStartSpeedX() then new.getMaxSpeedX() == speed
	 */
	@Basic
	public void setMaxSpeedX(double speed){
		if (speed<this.getStartSpeedX())
			this.maxspeedx = this.getStartSpeedX();
		else
			this.maxspeedx = Math.abs(speed);
	}
	/**
	 * A method to check whether the given maximimum speed is valid for this Mazub.
	 * @param maxspeed
	 * @return True if the given maxspeed is above the start speed in the horizontal direction | result = maxspeed > this.getStartSpeedX()
	 */
	public boolean isValidMaxSpeedX(double maxspeed){
		return maxspeed > this.getStartSpeedX();
	}
	/**
	 * A variable storing the maximum speed in the horizontal direction of this Mazub.
	 */
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
	/*public void setMaxSpeedHorizontalWhenRunning(int speed){
		this.maxspeedhorizontalwhenrunning = Math.max(this.getHorizontalStartSpeed(),Math.abs(speed));
	}*/
	/**
	 * A variable storing the maximum horizontal speed when running in m/s.
	 */
	private double maxspeedhorizontalwhenrunning;
	/**
	 * A method to calculate the new speed of this Mazub
	 * @param time
	 * @return If this Mazub isn't located on the bottom of the game world its new speed equals it current + the acceleration in vertical direction times the time
	 * 			| if this.getCurrentPositionY() >0 then result == this.getCurrentSpeedY() + getAccelerationY() * Math.abs(time)
	 * @return If this Mazub is located on the bottom of the game world its new vertical speed equals 0.
	 */
	public double calculateNewSpeedY(double time){
		if (this.getCurrentPositionY() > 0)
			return this.getCurrentSpeedY() + getAccelerationY() * Math.abs(time);
		else 
			return 0.0;
	}
	public double calculateNewPositionY(double time){
		if (this.getCurrentPositionY() > 0)
			return this.getCurrentPositionY() + this.getCurrentSpeedY() * Math.abs(time) + getAccelerationY() * Math.pow(time, 2);
		else
			return 0.0;
	}
	// Defensively
	public void startJump(){
		isJumping = true;
		this.setCurrentSpeedY(getStartSpeedY());
	}
	public void endJump() throws IllegalEndJumpException{
		if (this.getCurrentSpeedY() <0)
			throw new IllegalEndJumpException()
		else
			this.setCurrentSpeedY(0.0);
	}
	/**
	 * A variable storing the current jumping state of this Mazub.
	 */
	private boolean isJumping;
	
	// TOTAAL PROGRAMEREN
	/**
	 * A method returning the current speed in vertical direction of this Mazub.
	 * @return
	 */
	public double getCurrentSpeedY(){
		return this.currentspeedy;
	}
	
	public void setCurrentSpeedY(double speed){
		this.currentspeedy = speed;
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
    /**
     * A method returning the start speed of this Mazub in the vertical direction.
     * @return
     */
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
			setMaxSpeedX(getMaxSpeedHorizontalWhenRunning());
			setWidth(width);
			setHeight(height);
		}
		catch (IllegalLengthException exc){}
	}
	public boolean isDucking(){
		return this.isducking;}
	/** 
	 * A variable storing the current ducking state of this Mazub.
	 */
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
		if (!isMoving() && && !isDucking() && !isJumping())
		if (!isMoving() && && isDucking())
		
	}
}
