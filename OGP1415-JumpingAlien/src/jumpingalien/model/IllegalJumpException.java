package jumpingalien.model;

public class IllegalJumpException extends RuntimeException{

	/**
	 * A variable storing the id of this IllegalStartException
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * A method to create a new Illegal Jump Exception
	 * @param currentSpeed The current speed of this Illegal Jump Exception
	 */
	public IllegalJumpException(double currentSpeed){
		this.currentSpeed = currentSpeed;
	}
	/**
	 * A method returning the current speed of this Illegal Jump Exception
	 * @return
	 */
	public double getCurrentSpeed(){
		return this.currentSpeed;
	}
	/**
	 * A variable storring the current speed of this Illegal Jump Exception
	 */
	private double currentSpeed;
}
