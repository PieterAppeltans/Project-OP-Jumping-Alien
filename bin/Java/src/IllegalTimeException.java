
public class IllegalTimeException extends RuntimeException{
	/**
	 * A varialbe storing the version ID of this Illegal Time Exception.
	 */
	private static final long serialVersionUID = 1L;
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
