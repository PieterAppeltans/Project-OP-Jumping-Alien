package jumpingalien.model;

public class IllegalTimeException extends RuntimeException{
	/**
	 * A varialbe storing the version ID of this Illegal Time Exception.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * A method to create a new Illegal Time Exception
	 * @param time The time of this illegal time exception
	 * @post The time of this Illegal Time Exception equals the given time | new.getTime() == time
	 */
	public IllegalTimeException(double time) {
		this.time = time;
	}
	/**
	 * A method returning the time of this Illegal Time Exception.
	 * @return
	 */
	public double getTime(){
		return this.time;
	}
	/**
	 * A variable storing the time of this Illegal Time Exception.
	 */
	private double time;
}
