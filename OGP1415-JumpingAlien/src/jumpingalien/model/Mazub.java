/*
 * Pieter Appeltans - Ingenieurswetenschappen - github.com/PieterAppeltans/Project-OP-Jumping-Alien
 */

package jumpingalien.model;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Immutable;
import jumpingalien.util.*;

/**
 * Mazub is a class to define the player character (Mazub) in the game "Jumping Alien". 
 * 
 * @invar The left bottom pixel of Mazub must always be inside the boundaries of the world. | isValidPositionX(getPositionX())&& isValidPositionY(getPositionY())
 * @invar Mazub must have a non-negative heigth and width. The width and height must be valid | isValidHeight(getHeight()) && isValidWidth(getWidth())
 * @invar The current direction of this Mazub must be valid. | isValidDirection(getDirection())
 * @invar The initial speed of this Mazub in the x direction must be valid. | isValidStartSpeedX(getStartSpeedX)
 * @invar The maximum speed of each Mazub must be above the initial velocity of that Mazub | isValidMaxSpeedX(getMaxSpeedX())
 * @invar The current speed in the x direction of this Mazub must be valid . | isValidCurrentSpeedX()
 * @invar The current acceleration in x direction must be valid. | isValidCurrentAccelerationX(acceleration)
 * @invar
 * 
 * 
 * @invar Mazub is always green.
 * @author Pieter Appeltans
 *
 */

public class Mazub {
	/**
	 * @effect Set the current x coordinate of the new Mazub to the given positionx in pixel | setPositionX(positionx)
	 * @effect Set the current y coordinate of the new Mazub to the given positiony in pixel | setPositionY(positiony)
	 * @effect Set the start speed in the horizontal direction at the given speed in m/s | setStartSpeedX(startspeedx)
	 * @effect Set the maximum speed and the maximum speed when running in the horizontal direction at the given speed in m/s | setMaxSpeedX(maxspeedx) & setMaxSpeedWhenRunning(maxspeedy)
	 * @post The sprites of this new Mazub equals the given sprites | newMazub.getSprites() == sprites
	 */
	public Mazub(int pixelLeftX,int pixelBottomY,double startspeedx,double maxspeedx,Sprite[] sprites ) throws IllegalPositionXException,IllegalPositionYException{
		this.setPositionX(pixelLeftX);
		this.setPositionY(pixelBottomY);
		this.setStartSpeedX(startspeedx);
		this.setMaxSpeedX(maxspeedx);
		this.setMaxSpeedHorizontalWhenRunning(maxspeedx);
		this.images = sprites;
	}
	/**
	 * @effect Create a Mazub with a start speed (horizontal) of 1.0 m/s, a maximum speed(when running) (horizontal) of 3.0 m/s, a position (pixelLeftX,pixelBottomY) and sprites that equals the given sprites
	 */
	public Mazub(int pixelLeftX,int pixelBottomY,Sprite[] sprites){
		this(pixelLeftX,pixelBottomY,1.0,3.0,sprites);
	}
	/**
	 * A method returning the sprite at the given index.
	 * @param index The index of the wanted sprite.
	 * @return The sprite at the given index. | this.images[index]
	 */
	public Sprite getImageAtIndex(int index){
		
		return this.images[index];
	}
	/**
	 * A method returning an array with all the Sprites.
	 * @return An array with all the Sprites. | this.images
	 */
	@Basic
	public Sprite[] getImages(){
		return this.images;
	}
	/**
	 * A variable storing an array with all the sprites.
	 */
	public Sprite[] images;
	/**
	 * Return the x coordinate of the LB of Mazub in meters. 
	 * @return x coordinate of the LB pixel of this Mazub in meters | this.currentpositionx
	 */
	@Basic
	public double getCurrentPositionX(){
		return this.currentpositionx;
	}
	/**
	 * Set the x-position of this Mazub to the given positonx.
	 * @param positionx The new x position in meters for this Mazub.
	 * @throws IllegalPositionXException if positionx not in the boundaries of the gameworld. | if (!isValidCurrentPositionX(positionx))
	 * @post The new x position of this Mazub equals the given positionx. | new.getPositionX() == positionx
	 */
	@Basic
	public void setCurrentPositionX(double positionx) throws IllegalPositionXException {
		if (! isValidCurrentPositionX(positionx))
			throw new IllegalPositionXException(positionx);
		else
			this.currentpositionx = positionx;
	}
	/**
	 * 
	 * @param positionx The position to be checked.
	 * @return True if the supplied position is in the boundaries of the gameworld. Which means, it has to be bigger than or equal to the minimum and smaller than or equal to the maximum. 
	 * 				| result = isValidPositionX(changeMetricToPixel(positionx))
	 * 
	 */
	public static boolean isValidCurrentPositionX(double positionx){
		return isValidPositionX(changeMetricToPixel(positionx));
	}
	/**
	 * A variable storing the current x coordinate of the LB of this Mazub.
	 */
	private double currentpositionx;
	/**
	 * Return the current x coordinate of the LB pixel of this Mazub in pixels.
	 * @return the x coordinate of the LB pixel of this Mazub in pixels. | changeMetricToPixel(getCurrentPositionX())
	 */
	public int getPositionX(){
		return changeMetricToPixel(getCurrentPositionX());
	}
	
	
	 /** Set the x positon of this Mazub to the given positonx in pixels
	 *@effect setCurrentPositionX(changePixeltoMetric(positionx))
	 *@throws IllegalPositionXException if ! isValidPositionX(positionx)
	 */
	
	public void setPositionX(int positionx) throws IllegalPositionXException{
		setCurrentPositionX(changePixeltoMetric(positionx));
	}
	/**
	 * A method to check whether a is given x coordinate of the position of the LB pixel of Mazub is valid. This position of the LB of Mazub
	 *  must always be inside the boundaries of the world.   
	 * @param positionx The x coordinate that have to be checked.
	 * @return True if x is bigger or equal to the minimum in the x direction and smaller or equal to the maximum in the x direction | result = (positionx>=getMinPositionX()) && (positionx<=getMaxPositionX());
	 */
	
	public static boolean isValidPositionX(int positionx){
		return (positionx>=getMinPositionX()) && (positionx<=getMaxPositionX());
	}
	
	/**
	 * Returning the x coordinate of the left boundary of the game world.
	 * @return
	 */
	@Basic @Immutable
	public static int getMinPositionX(){
		return 0;
	}
	/**
	 * Returning the x coordinate of right boundary of the game world.
	 * @return
	 */
	@Basic @Immutable
	public static int getMaxPositionX(){
		return 1023;
	}
	
	/**
	 * A method returning the current vertical position of the LB pixel of this Mazub in meters.
	 * @return
	 */
	@Basic
	public double getCurrentPositionY(){
		return this.currentpositiony;
	}
	/**
	 * A method to set the vertical position of the LB pixel of this Mazub to the given positiony
	 * @param positiony The new positiony in meters for this Mazub.
	 * @throws IllegalPositionYException If the supplied positiony not in the boundaries of the gameworld.
	 * 			| if (! isValidCurrentPositionY(positiony))
	 * @post new.getCurrentPositionY() == positiony 
	 */
	@Basic
	public void setCurrentPositionY(double positiony) throws IllegalPositionYException {
		if (! isValidCurrentPositionY(positiony))
			throw new IllegalPositionYException(positiony);
		else
			this.currentpositiony = positiony;
		
	}
	/**
	 * A method to check whether a given position is valid
	 * @param positiony The positiony in meter to be checked.
	 * @return True if the positiony is in the boundaries of the game world, which means not smaller 
	 * 	than the minimum and not bigger than the maximum  |  isValidPositionY(changeMetricToPixel(positiony))
	 */
	public static boolean isValidCurrentPositionY(double positiony){
		return isValidPositionY(changeMetricToPixel(positiony));
	}
	/**
	 * A variable storing the current position y of this Mazub.
	 */
	private double currentpositiony;
	
	/**
	 * Return the y coordinate in pixels of the LB pixel of this Mazub.
	 * @return The y coordinate of the LB pixel of this Mazub in pixel | changeMetricToPixel(getCurrentPositionY())
	 */
	public int getPositionY(){
		return changeMetricToPixel(getCurrentPositionY());
	}
	
	/**
	 * Set the positiony of Mazub to the given positiony.
	 * @param postiony The new y coordinate in pixels of the position of Mazub.
	 * @throws IllegalPositionYExeption if the positiony not in the boundary of the game world. |if (!isValidPositionY(positiony))
	 * @effect setCurrentPositionY(changePixeltoMetric(positiony))
	 */
	 
	
	public void setPositionY(int positiony) throws IllegalPositionYException{
		setCurrentPositionY(changePixeltoMetric(positiony));
	}
	/**
	 * A method to check wheter the given positiony is a valid y coordinate for a position
	 * @param positiony The positiony to be checked in pixel
	 * @return
	 */
	@Basic
	public static boolean isValidPositionY(int positiony){
		return (positiony>=getMinPositionY()) && (positiony<=getMaxPositionY());
	}
	
	/**
	 * Returning the y coordinate of the bottom boundary of the game world.
	 * @return 
	 */
	@Basic @Immutable
	public static int getMinPositionY(){
		return 0;
	}
	/**
	 * Returning the y coordinate of the  top boundary of the game world.
	 * @return
	 */
	@Basic @Immutable
	public static int getMaxPositionY(){
		return 767;
	}
	
	/**
	 * Returning the position of the LB pixel of this Mazub in an array {x,y}.
	 * @return {getPositionX(),getPositionY()}
	 */
	public int[] getLocation(){
		int[] array = {getPositionX(),getPositionY()};
		return array;
	}
	/**
	 * Returning the current width of Mazub.
	 * The width may change during the game, example when ducking.
	 * @return The width of this Mazub| this.width
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
	 * A method checking whether a given width is vao!d. 
	 * @param width The width to be checked.
	 * @return True if this width is valid for this Mazub. 
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
	 * The height may change during the game, example when ducking.
	 * @return The heigth of this Mazub in pixels
	 */
	@Basic
	public int getHeight(){
		return this.height;
	}
	/**
	 * A method to set the height to the given heigth.
	 * @param height The new height of this Mazub
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
	/** 
	 * A method returning the seize {width,height} in an array of this Mazub.
	 * @return An array with the current width and height of this Mazub{getWidth(),getHeight()}
	 */
	public int [] getSize(){
		int[] array = {getWidth(),getHeight()}; 
		return array;
	}
	/**
	 * A bookkeeping method to calculate new horizontal position, the new horizontal speed, the new vertical position and the new vertical speed of this Mazub.
	 * It also set the width and the height of this Mazub to the size of the current Sprite.
	 * At last it also check if you are landed after a jump so you can jump again.
	 * @param time The time to be advanced.
	 * @throws IllegalTimeException If the given time is not valid | if (! isValidTime())
	 * @throws IllegalLengthException If the height or width of the current sprite isn't valid | (!isValidWidth() || !isValidHeight())
	 * @effect Set the width of this Mazub to the width of the current sprite|setWidth(currentSprite.getWidth())
	 * @effect Set the heigth of this Mazub to the height of the current sprite | setHeight(currentSprite.getHeight())
	 * @effect Set the current positionx of this Mazub to a new position | setCurrentPositionX(newPositionX)
	 * @effect Set the current speedx of this Mazub to the new speed | setCurrentSpeedX(newspeedx)
	 * @effect Set the current positiony of this Mazub to new position | setCurrentPositionY(newpositiony)
	 * @effect Set the current speedy of this Mazub to the new speed | setCurrentSpeedY(newspeedy)
	 * @effect If the Mazub is landed than to the method Land() | if checkLanded() than Land()
	 */
	public void advanceTime(double time) throws IllegalTimeException,IllegalLengthException{
			Sprite currentSprite = getCurrentSprite();
			setWidth(currentSprite.getWidth());
			setHeight(currentSprite.getHeight());
			if (!isValidTime(time))
				throw new IllegalTimeException(time);
			try{
				setCurrentPositionX(calculateNewPositionX(time));
				setCurrentSpeedX(calculateNewSpeedX(time));
				}
			catch (IllegalPositionXException exc2) {
					if (exc2.getPositionX()> changePixeltoMetric(getMaxPositionX()))
						this.setCurrentPositionX(changePixeltoMetric(getMaxPositionX()));
					if (exc2.getPositionX()< changePixeltoMetric(getMinPositionX()))
						this.setCurrentPositionX(changePixeltoMetric(getMinPositionX()));
				}
			try{
				setCurrentPositionY(calculateNewPositionY(time));
				setCurrentSpeedY(calculateNewSpeedY(time));}
			catch(IllegalPositionYException exc){
				if (exc.getPositionY() > changePixeltoMetric(getMaxPositionY()))
					setCurrentPositionY(changePixeltoMetric(getMaxPositionY()));
				if (exc.getPositionY() < changePixeltoMetric(getMinPositionY()))
					setCurrentPositionY(changePixeltoMetric(getMinPositionY()));
			}
			if (checkLanded())
				this.Land();	
		}
	/**
	 * A method checking whether the given time is valid.
	 * @param time The time to be checked.
	 * @return True if the suplied is bigger than 0 and smaller than 0.2 | result == return time>=0 && time<=0.2
	 */
	public static boolean isValidTime(double time){
		return time>=0 && time<=0.2;
	}
	
	/** 
	 * @param time The time advanced since the last calculation.
	 * @return The new speed. The speed is always in absolute value smaller  than or equal to  abs(this.getCurrentSpeedX() + this.getCurrentAccelerationX() * time) |
	 * 			 abs(result) <= abs(this.getCurrentSpeedX() + this.getCurrentAccelerationX() * time)
	 */
	public  double calculateNewSpeedX(double time){
		return  this.getCurrentSpeedX() + this.getCurrentAccelerationX() * time;
		}
	/**
	 * @param time The time advanced since the last calculation.
	 * @return The new position is in absolute value smaller or equal to abs(getCurrentPositionX() + getCurrentSpeedX()*time + getCurrentAccelerationX()*time^2 /2)
	 * | abs(result) <= abs(getCurrentPositionX() + getCurrentSpeedX()*time + getCurrentAccelerationX()*time^2 /2)
	 */
	public double calculateNewPositionX(double time){
	
		return this.getCurrentPositionX() +  this.getCurrentSpeedX() * time + 0.5 * this.getCurrentAccelerationX() * Math.pow(time,2);
		
	}
	/**
	 * @pre The provided direction is not null | direction != null
	 * @pre This Mazub may not already being moving in this direction | !(isMoving() && getDirection() == direction)
	 * @post The new status of ismoving equals true | new.isMoving() == true;
	 * @post The new direction equals the given direction | new.getDirection() = direction
	 * @post The new current velocity equals the start velocity (negative if moving to the left , positive if moving to the right)
	 *			| if direction == LEFT then new.getCurrentSpeedX() == - this.getStartSpeedX()
	 *			| if direction == RIGHT then new.getCurrentSpeedX() == this.getStartSpeedX()
	 *@post The new current acceleration equals the acceleration in the x direction (negative if moving to the left , positive if moving to the right)
	 *			| if direction == LEFT then new.getCurrentAccelerationX() == - this.getAccelerationX()
	 *			| if direction == RIGHT then new.getCurrentAccelerationX() == this.getAccelerationX()
	 */
	public void startMove(Direction direction){
		assert direction != null;
		assert !(isMoving() && getDirection()==direction);
		ismoving = true;
		setDirection(direction);
		setCurrentSpeedX(direction.getSign() * this.getStartSpeedX());
		setCurrentAccelerationX(direction.getSign() * getAccelerationX());
	}
	/**
	 * @pre When invoked the Mazub must be moving. | this.isMoving()
	 * @post The time of the last movement in the x direction must equal the current time.
	 * 			| new.getTimeLastMoveX() == System.currentTimeMillis()
	 * @post The direction of the last movement in the x direction must equal the current direction
	 * 			| new.getDirectionLastMove() == previous.getDirection()
	 * @post The new status of ismoving equals false | new.isMoving() == false;
	 * @post The new direction must equal null | new.getDirection() == null
	 * @post The new current speed in x direction must equal 0 | new.getCurrentSpeedX() == 0
	 * @post The new current acceleration in x direction must equal 0 | new.getCurrentAcceleration == 0
	 * 
	 */
	public void endMove(){
		assert isMoving();
		setTimeLastMoveX(System.currentTimeMillis());
		setDirectionLastMove(getDirection());
		ismoving = false;
		setDirection(null);
		setCurrentSpeedX(0.0);
		setCurrentAccelerationX(0.0);
	}
	/**
	 * A method returning the time in milis this Mazub ended his last movement.
	 * @return
	 */
	@Basic
	public long getTimeLastMoveX(){
		return this.timelastmovex;
	}
	/** 
	 * A method to set the time at which the last movement ended. 
	 * @param time The time the last movement ended
	 * @post The new time of the last movement in x direction equals the given time 
	 * 		| new.getTimeLastMoveX == time
	 */
	@Basic
	public void setTimeLastMoveX(long time){
		this.timelastmovex = time;
	}
	/**
	 * A variable storing the last time this Mazub moved
	 */
	public long timelastmovex;
	/**
	 * A method returning the direction of the last movement of this Mazub.
	 * @return
	 */
	@Basic
	public Direction getDirectionLastMove(){
		return directionlastmove;
	}
	/**
	 * A method to set the direction of the last movement of this Mazub.
	 * @param direction The direction of the last movement of this Mazub.
	 * @post The new direction of the last movemement equals the given direction 
	 * 		| new.getDirectionLastMove() == direction
	 */
	@Basic
	public void setDirectionLastMove(Direction direction){
		this.directionlastmove = direction;
	}
	/**
	 * A variable storing the last direction of this Mazub.
	 */
	public Direction directionlastmove;
	/**
	 * Return the current moving status of this Mazub.
	 * @return
	 */
	@Basic
	public boolean isMoving(){
		return this.ismoving;
	}
	/**
	 * A variable storring the current moving status of this Mazub
	 */
	private boolean ismoving;
	/**
	 * A method returning the direction of the this mazub
	 * @return
	 */
	@Basic
	public Direction getDirection(){
		return this.direction;
	}
	
	/**
	 * @pre The given direction may not equal null when moving | if isMoving() then direction != null
	 * @pre The given direction must equal null when not moving. | if !isMoving() then direction == null
	 * @param direction The new direction of this Mazub.
	 * @post The new direction of this Mazub must equal the given direction
	 * 		| new.getDirection() == direction
	 */
	@Basic
	public void setDirection(Direction direction){
		assert isValidDirection(direction);
		this.direction = direction;
	}
	/**
	 * A method to check wheter a given direction is valid given the current moving state.
	 * @param direction The direction to be checked.
	 * @return True if this Mazub is moving and the given direction not Equals null.
	 * 			| result = this.isMoving() && direction != null
	 * @return True if this Mazub isn't moving and the given direction equals null.
	 * 			| result = (!isMoving() && direction == null)
	 */
	public boolean isValidDirection(Direction direction){
		return (this.isMoving() && direction != null ) || (!isMoving() && direction == null);
	}
	/**
	 * A variable storing the current direction of movement of this Mazub.
	 */
	private Direction direction;
	
	
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
	 * @return The start speed must always above or equal to 1 m/s. | result == speed >= 1
	 */
	public boolean isValidStartSpeedX(double speed){
		return speed >=1;
	}
	/**
	 * A variable storring the horizontal start speed of this Mazub.
	 */
	private double startspeedx;
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
	 * @post If the given speed is below the initial speed then the new maximum speed equals the initial speed. |if speed < this.getStartSpeedX() then new.getMaxSpeedX == this.getStartSpeedX() 
	 * @post If the given speed is above the intial speed then the new maximum speed equals the given speed. |if speed > this.getStartSpeedX() then new.getMaxSpeedX() == speed
	 */
	@Basic
	public void setMaxSpeedX(double speed){
		if (speed<this.getStartSpeedX())
			this.maxspeedx = this.getStartSpeedX();
		else
			this.maxspeedx = speed;
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
	 * Return the current speed of this Mazub in the x-direction in m/s
	 * @return The speed of this Mazub in the x direction in m/s | this.currentspeedx
	 */
	@Basic
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
	@Basic
	public void setCurrentSpeedX(double speed){
		if (! this.isMoving())
			this.currentspeedx = 0;
		else if (Math.abs(speed) > this.getMaxSpeedX())
			this.currentspeedx = this.getMaxSpeedX() * Math.signum(speed);
		else if (Math.abs(speed) < this.getStartSpeedX())
			this.currentspeedx = this.getStartSpeedX() * Math.signum(speed);
		else
			this.currentspeedx = speed;
		
	}
	
	/**
	 * @return Ture If this Mazub is not moving and the current speed equals 0 m/s | if (!isMoving()) the this.getCurrentSpeedX == 0
	 * @return If this Mazub is moving, the absolute value of its speed must be between the maximum speed and the initial speed.
	 * 			| if isMoving() then| (Math.abs(this.getCurrentSpeedX()) <= this.getMaxSpeedX() && Math.abs(this.getCurrentSpeedX()) >= this.getStartSpeedX()) 
	 */
	public boolean isValidCurrentSpeedX(){
		return (!this.isMoving() && this.getCurrentSpeedX()==0 ) || ((Math.abs(this.getCurrentSpeedX()) <= this.getMaxSpeedX() && Math.abs(this.getCurrentSpeedX()) >= this.getStartSpeedX())&& this.isMoving()); 
	}
	/**
	 * A variable storring the current speed of this Mazub
	 */
	private double currentspeedx;
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
	private static double accelerationx = 0.9;

	/**
	 * A method returning the current acceleration in the horizontal direction.
	 * @return
	 */
	@Basic
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
	@Basic
	public void setCurrentAccelerationX(double acceleration){
		if (Math.abs(acceleration) == getAccelerationX())
				this.currentaccelerationx = acceleration;
		else if (acceleration !=0)
			this.currentaccelerationx = getAccelerationX()*Math.signum(acceleration);
		else if (acceleration == 0)
			this.currentaccelerationx = 0;
			
	}
	/**
	 * @param acceleration
	 * @return if this Mazub is not moving, its current acceleration must equal 0. | if (!isMoving()) then acceleration == 0.
	 * @return if this Mazub is moving, its current acceleration must in absolute value equal the accelertion in the horizontal direction
	 * 			| if isMoving() then Math.abs(acceleration) == getAccelerationX() 
	 */
	public boolean isValidCurrentAccelerationX(double acceleration){
		return (!isMoving() && acceleration ==0) || (isMoving() && Math.abs(acceleration) == getAccelerationX());
	}
	/**
	 * A variable storring the current acceleration in x direction in m/(s^2).
	 */
	private double currentaccelerationx;
	/**
	 * A method to calculate the new speed in vertical direction of this Mazub
	 * @param time The time past since the last calculation.
	 * @return The new speed in the vertical direction, this is in absolute value always smaller than  or equal to abs(getCurrentSpeedY() + getAccelerationY() * time)
	 * | abs(result) <= abs(getCurrentSpeedY() + getAccelerationY() * time) 
	 */
	public double calculateNewSpeedY(double time){
			return this.getCurrentSpeedY() + getAccelerationY() * Math.abs(time);
		
	}
	/**
	 * A method to calculate the new position in vertical direction of this Mazub.
	 * @param time The time past since the last calculation.
	 * @return The new position bassed on the current time, these is always in absolute value smaller than or equal to abs(getCurrentPositionY() + getCurrentSpeedY() * time + getCurrentAccelerationY()*time^2/2)
	 * 			| result <= abs(getCurrentPositionY() + getCurrentSpeedY() * time + getCurrentAccelerationY()*time^2/2)
	 */
	public double calculateNewPositionY(double time){
			return this.getCurrentPositionY() + this.getCurrentSpeedY() * Math.abs(time) + getAccelerationY() * Math.pow(time, 2);
	}
	/**
	 * A method to start jumping.
	 * @post if not jumping and landed when this method is invoked then the new isJumping() equals True
	 * 				| if (!isJumping() && isLanded()) then new.isJumping() == True
	 * @post ... then the new landed state equals false | ... then new.isLanded() == False
	 * @post ... then the current speed in the y direction equals the start speed in the vertical direction
	 * 		| ... then new.getCurrentSpeedY() == getStartSpeedY()
	 * @post if this Mazub is not yet landed when this method is invoked then the current speed in y direction remains unchanged.
	 *  	| ... then new.getCurrentSpeedY() == previous.getCurrentSpeedY()
	 */
	public void startJump(){
		try{
		
		this.setJumpingState(true);
		this.landed = false;
		this.setCurrentSpeedY(getStartSpeedY());
		}
		catch (IllegalJumpException exc){
			//this.setCurrentSpeedY(exc.getCurrentSpeed());
		}
	}
	/**
	 * A method to end jumping.
	 * @post if the current speed is positive then the current speed in vertical direction is set to 0.
	 * 			| if getCurrentSpeedY()>=0 then new.getCurrentSpeedY() == 0
	 * @post if the current speed is not positive or this Mazub is not jumping the current speed remain unchanged.
	 * 			| if getCurrentSpeedY()<0 then new.getCurrentSpeedY() == previous.getCurrentSpeedY()
	 */
	public void endJump() {
		try{
			this.setJumpingState(false); 
			this.setCurrentSpeedY(0.0);
			}
		catch (IllegalJumpException exc){
			//this.setCurrentSpeedY(exc.getCurrentSpeed());
		}
	}
	/**
	 * A method to change the the current jumping state of this Mazub.
	 * @param isjumping The value to which the jumping state must be set.
	 * @throws IllegalJumpException	if isjumping(the argument) is false and the current speed is not positive or if isjumping is true and this mazub is not landed.
	 * 			| if !isjumping && getCurrentSpeedY() <0 or isjumping && ! hasLanded()
	 * @post The new jumping state of this Mazub equals the isjumping | new.isJumping() == isjumping
	 */
	public void setJumpingState(boolean isjumping) throws IllegalJumpException{
		if (isjumping == false && getCurrentSpeedY()<0)
			throw new IllegalJumpException(getCurrentSpeedY());
		else if (isjumping == true && !hasLanded())
			throw new IllegalJumpException(getCurrentSpeedY());
		else
			this.isjumping = isjumping;
	}
	/**
	 * A method to get the current jumping state of this Mazub.
	 * @return
	 */
	public boolean isJumping(){
		return this.isjumping;
	}
	/**
	 * A variable storing the current jumping state of this Mazub.
	 */
	private boolean isjumping = false;
	/**
	 * A method return the current landing state of this Mazub.
	 * @return
	 */
	public boolean hasLanded(){
		return this.landed;
	}
	/**
	 * A method that check wheter Mazub is landed.
	 * @return	True if this Mazub is not landed yet and the the current y coordinate of its position equals the minimum position y
	 * 			| if (!hasLanded() && getCurrentPositionY() == changePixeltoMetric(getMinPositionY())
	 */
	public boolean checkLanded(){
		if (!hasLanded() && getCurrentPositionY() == changePixeltoMetric(getMinPositionY()))
			return true;
		else
			return false;
		
	}
	/**
	 * A method to land this Mazub.
	 * @effect The current speed in y direction is set to 0. | this.setCurrentSpeedY(0)
	 * @effect The current jumping state is set to false. | this.setJumpingState(false)
	 * @post The new landed state of this mazub equals true | new.hasLanded() == true;
	 */
	public void Land(){
		try{
		this.setCurrentSpeedY(0);
		this.setJumpingState(false);
		this.landed = true;}
		catch (IllegalJumpException exc){}// Normaly no Illegal Jump Exception is thrown so we don't have to handle it.
		
	}
	/**
	 * A variable storing the current landed state of this Mazub.
	 */
	private boolean landed = false; // We start with this on false so that if we start at a heigth above the ground we can not jump immediatelly. 

	/**
	 * A method returning the current speed in m/s in vertical direction of this Mazub.
	 * @return
	 */
	@Basic
	public double getCurrentSpeedY(){
		return this.currentspeedy;
	}
	/**
	 * A method to set the current speed in vertical direction to the given speed.
	 * @param speed The new vertical speed of this Mazub.
	 * @post The new current speed in y direction equals the given speed. | new.getCurrentSpeedY() == speed
	 */
	@Basic
	public void setCurrentSpeedY(double speed){
		this.currentspeedy = speed;
	}
	/**
	 * A variable storing the current speed in vertical direction.
	 */
	private double currentspeedy;
	/**
	 * Returning the vertical acceleration of this Mazub if this mazub is not at ground level. Equals the gravity constant of the planent on which Mazub lives 
	 * If this Mazub is at ground level nul is returned 
	 * @return if this.getPositionY()> getMinPositionY() then return -10 | if getPositionY()> getMinPositionY() then return - 10.
	 * @return if this.getPositionY() == getMinPositionY() then return 0 | if getPositionY() == getMinPositionY() then return 0.
	 */
    @Basic 
	public  double getAccelerationY(){
    	if (this.getPositionY() == getMinPositionY())
    		return 0;
    	else 
    		return -10;}
    /**
     * A method returning the start speed in m/s of this Mazub in the vertical direction.
     * @return The spped in vertical direction in m/s of this Mazub | 8
     */
	@Basic @Immutable
	public static double getStartSpeedY(){
		return 8;
	}
	/**
	 * A method to start ducking
	 * @post After invoking this method, this Mazub is ducking | new.isDucking() == true;
	 * @effect The maximum speed is set to the maximum speed when ducking | new.getMaxSpeedX() == getMaxSpeedHorizontalWhenDucking() 
	 */
	public void startDuck(){
		this.isducking = true;
		setMaxSpeedX(getMaxSpeedHorizontalWhenDucking());
	}
	/**
	 * A method to end ducking
	 * @post After invoking this method, this Mazub is not ducking anymore | new.isDucking == false;
	 * @effect The Maximum speed is set to the maximum speed when running | new.getMaxSpeedX() == getMaxSpeedHorizontalWhenRunning()
	 */
	public void endDuck(){
		this.isducking = false;
		setMaxSpeedX(getMaxSpeedHorizontalWhenRunning());
	}
	/**
	 * Return the current ducking state of this Mazub.
	 * @return
	 */
	public boolean isDucking(){
		return this.isducking;}
	/** 
	 * A variable storing the current ducking state of this Mazub.
	 */
	private boolean isducking;
	/**
	 * A method returning the maximum horizontal speed when running in m/s. Is always bigger then or equal to the start speed
	 */
	public double  getMaxSpeedHorizontalWhenRunning(){
		return this.maxspeedhorizontalwhenrunning;
	}
	/**
	 * 
	 * @param speed
	 * @post if the given speed in absolute value is smaller than the start speed then the max speed equals the start speed
	 * 			|if Math.abs(speed) < this.getHorizontalStartSpeed()
	 * 			then this.maxspeedhorizontalwhenrunning = this.getHorizontalStartSpeed()
	 * @post if the given speed in absolute value is bigger than or equal than the start speed in horizontal direction
	 * 			then the max speed when running equals the given speed.
	 * 			|if Math.abs(speed) >= this.getHorizontalStartSpeed()
	 * 			then this.maxspeedhorizontalwhenrunning = math.abs(speed);
	 * 
	 */
	public void setMaxSpeedHorizontalWhenRunning(double speed){
		this.maxspeedhorizontalwhenrunning = Math.max(this.getStartSpeedX(),Math.abs(speed));
	}
	/**
	 * A variable storing the maximum horizontal speed when running in m/s.
	 */
	private double maxspeedhorizontalwhenrunning;
	/**
	 * Returning the maximum speed of Mazub when he is ducking.
	 * @return
	 */
	public static double getMaxSpeedHorizontalWhenDucking(){
		return 1;
	}

	/**
	 * Changing a given int in pixels to a double in metric
	 * @param pixel The length expressed in pixel
	 * @return The length in meters | pixel*(.01)
	 */
	public static double changePixeltoMetric(int pixel){
		return pixel*(.01);}
	
	/**
	 * Changing a given double in meters to a int in pixels 
	 * @param metric The length/speed/velocity expressed in meters, m/s, m/(s^2) that has to be changed to pixels, pixels/s,pixels/(s^2) 
	 * @return The lengt/speed/velocity in pixels | (int)(metric*100)
	 */
	public static int changeMetricToPixel(double metric){
		return (int)(metric *100);
	}
	/**
	 * A method that return if this Mazub as moved within the last second.
	 * @return True if this Mazub is now moving or the difference between the last movement and now is less than 1 second
	 * 			| true if (isMoving() ||  System.currentTimeMillis() - getTimeLastMoveX())<1000 
	 */
	public boolean hasMovedXLastSecond(){
		if (isMoving())
			return true;
		else if ((System.currentTimeMillis() - getTimeLastMoveX())<1000 )
			return true;
		else
			return false;
	}
	/**
	 * A method returning the current sprite.
	 * @return if this mazub is not moving horizontally, has not moved horizontally within the las second and is not ducking
	 * 				then the sprite at index 0 is returned
	 * @return if this Mazub is not moving horizontally, has not moved horizontally within the last second and is ducking
	 * 				then the sprite at index 1 is returned
	 * @return if this Mazub is not moving horizontally, but has moved horizontally within the last second and the direction last movement
	 * 				was moving to the right and the character is not ducking.
	 * 				then the sprite at index 2 is returned
	 * @return if this Mazub is not moving horizontally, but has moved horizontally within the last second and the direction last movement
	 * 				was moving to the left and the character is not ducking.
	 * 				then the sprite at index 3 is returned
	 * @return if this Mazub is moving to the right and jumping and not ducking return the sprite at index 4 
	 * @return if this Mazub is moving to the leftt and jmping and not ducking return the image at index 5
	 * @return if this Mazub is ducking and moving to the right or was moving to the right within 1s, return the image at index 6
	 * @return if this Mazub is ducking and moving to the left or was moving to the left (within 1s), return the image at index 7
	 * @return if this Mazub is not ducking and not jumping and moving to the right, return an image at index between 8 .. 8+ m
	 * 	with m=(getImages().length - 8 )/2 -1
	 * @return if this Mazub is not ducking and not jumping and moving to the right, return an image at index between 9+m .. 9+ 2m
	 * 	with m=(getImages().length - 8 )/2 -1
	 */
	public Sprite getCurrentSprite() {
		if (!isMoving() &&!hasMovedXLastSecond() && !isDucking() )

			return this.getImageAtIndex(0);
		else if (!isMoving()  &&!hasMovedXLastSecond() && isDucking() )
			return this.getImageAtIndex(1);
		else if (!isMoving() && hasMovedXLastSecond() && getDirectionLastMove() == Direction.RIGHT && !isDucking() )
			return this.getImageAtIndex(2);
		else if (!isMoving() && hasMovedXLastSecond() && getDirectionLastMove() == Direction.LEFT && !isDucking() )
			return this.getImageAtIndex(3);
		else if (isMoving() && getDirection() == Direction.RIGHT && !hasLanded() && !isDucking())
			return this.getImageAtIndex(4);
		else if (isMoving() && getDirection() == Direction.LEFT && !hasLanded() && !isDucking())
			return this.getImageAtIndex(5);
		else if ( isDucking() && (getDirection() == Direction.RIGHT || (getDirectionLastMove() == Direction.RIGHT && hasMovedXLastSecond()&& getDirection() != Direction.LEFT )))
			return this.getImageAtIndex(6);
		else if ( isDucking() && (getDirection() == Direction.LEFT || (getDirectionLastMove() == Direction.LEFT && hasMovedXLastSecond()&& getDirection() != Direction.RIGHT)))
			return this.getImageAtIndex(7);			
		else if (!isDucking() && hasLanded() && isMoving() && getDirection() == Direction.RIGHT){
			return (this.getImageAtIndex(nextWalkIndex()));}
		else if (!isDucking() && hasLanded() && isMoving() && getDirection() == Direction.LEFT){
			return (this.getImageAtIndex(nextWalkIndex()));}
		else
			return (this.getImageAtIndex(0));
					
	}
	/**
	 * A method returning the index of the next walking image
	 * @return if this Mazub is walking to the right the returned index is in the range 8 ... 8+m
	 * 			| if getDirection() == Direction.RIGHT then return index in range[8 .. 8 +m]
	 * @return if this Mazub is walking to the left the returned index is in the range 9+m ... 9+2m
	 * 			| if getDirection() == Direction.LEFT the return index in range[9+m ... 9+2m]
	 */
	public int nextWalkIndex(){
		
			if (getTimeLastImage() == 0 || (System.currentTimeMillis() - getTimeLastImage() >75)){
			int m = (getImages().length - 8 )/2 -1;
			
			if (getDirection() == Direction.RIGHT){
				int index = 8 + (Math.max(getCurrentIndex(),8) - 8 +1)%(m+1);
				System.out.println(index);
				setCurrentIndex(index);
				setTimeLastImage(System.currentTimeMillis());
				System.out.println(getCurrentIndex());
				return index;
				}
			else if (getDirection() == Direction.LEFT){
				int index = 9+ m + (Math.max(getCurrentIndex(), 9+m) -(9+m) +1)%(m+1);
				setCurrentIndex(index);
				setTimeLastImage(System.currentTimeMillis());
				return index;}
			else
				return getCurrentIndex();}
			else
				return getCurrentIndex();
				
		
		
		
	}
	/**
	 * A method returning the time in milis that last new walking image was selected
	 */
	public long getTimeLastImage(){
		return this.timeLastImage ;
	}
	/**
	 * 
	 * @param time The time the last walking image was selected.
	 * @post The new time last image equals the given time. | new.getTimeLastImage() == time
	 * 
	 */
	public void setTimeLastImage(long time){
		this.timeLastImage = time;
	}
	/**
	 * A variable storing the time the last walking image was selected.
	 */
	public long timeLastImage;
	/**
	 * Returning the index of the current walking image
	 * @return
	 */
	public int getCurrentIndex(){
		return this.currentIndex;
	}
	/**
	 * A method to set the index of the current walking image to a given index.
	 * @param index
	 */
	public void setCurrentIndex(int index){
		;
		this.currentIndex = index;
	}
	/**
	 * A variablse storing the index of the current walking image
	 */
	private int currentIndex; 
}
