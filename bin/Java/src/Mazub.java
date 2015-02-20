import be.kuleuven.cs.som.annotate.Basic;


/**
 * 
 * @author Pieter
 *
 */
public class Mazub {
	public Mazub(){}
	
	// Defensive way
	@Basic
	public int getPositionX(){
		return this.positionx;
	}
	@Basic 
	public void setPositionX(int positioxn){}
	private int positionx;
	@Basic
	public int getPositionY(){
		return this.positiony;
	}
	@Basic
	public void setPositionY(int postiony){}
	
	private int positiony;
	
	@Basic 
	public int getWidth(){
		return this.width;
	}
	private int width;
	@Basic
	public void setWidth(){}
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
