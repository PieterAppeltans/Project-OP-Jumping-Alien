package jumpingalien.part1.facade;


import jumpingalien.model.Direction;
import jumpingalien.model.Mazub;
import jumpingalien.part1.facade.IFacade;
import jumpingalien.util.ModelException;
import jumpingalien.util.Sprite;

public class Facade implements IFacade {
	public Mazub createMazub(int pixelLeftX,int pixelBottomY,Sprite[] sprites) throws ModelException{
		try{
		return new Mazub(pixelLeftX,pixelBottomY,sprites);}
		catch (Exception exc){
			throw new ModelException(exc);
		}
	}
	public int[] getLocation(Mazub alien){
		return alien.getLocation();
	}
	public double[] getVelocity(Mazub alien){
		double[] array =  {alien.getCurrentSpeedX(),alien.getCurrentSpeedY()}; 
		return array;
	}
	public double [] getAcceleration(Mazub alien){
		double [] array = {alien.getCurrentAccelerationX(),alien.getAccelerationY()};
		return array;
	}
	public int [] getSize(Mazub alien){
		return alien.getSize();
	}
	public Sprite getCurrentSprite(Mazub alien){
		return alien.getCurrentSprite();
	}
	public void startJump(Mazub alien){
		alien.startJump();
	}
	public void endJump(Mazub alien){
		alien.endJump();
	}
	public void startMoveLeft(Mazub alien){
		alien.startMove(Direction.LEFT);
	}
	public void endMoveLeft(Mazub alien){
		alien.endMove();
		}
	public void startMoveRight(Mazub alien){
		alien.startMove(Direction.RIGHT);
		}
	public void endMoveRight(Mazub alien){
		alien.endMove();
	}
	public void startDuck(Mazub alien){
		alien.startDuck();
	}
	public void endDuck(Mazub alien){
		alien.endDuck();
	}
	public void advanceTime(Mazub alien, double dt) throws ModelException{
		try{
		alien.advanceTime(dt);}
		catch (Exception exc){
			throw new ModelException(exc);
		}
	}
	
}
