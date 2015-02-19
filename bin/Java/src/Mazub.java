import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Immutable;

/**
 * 
 * @author Pieter
 *
 */
public class Mazub {
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
	
	@Basic @Immutable
	public int getWidth(){
		return this.width;
	}
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
	public double getMaximumHorizontalVelocity(){
		return this.maximumhorizontalvelocity;
	}
	public void setMaximumHorizontalVelocity(){}
	private double maximumhorizontalvelocity;
	
}
