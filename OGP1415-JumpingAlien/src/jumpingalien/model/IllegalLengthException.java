package jumpingalien.model;
/**
 * A class signaling an illegal length exception. Each illlegal lenght exception stores the illegal length exception. 
 * @author Pieter
 * @version 1.0
 *
 */
public class IllegalLengthException extends RuntimeException {
	/**
	 * A variable storing the version ID of this Illegal Length Exception.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * @param length The length of this illegal length exception.
	 * @post The length of this illegal length exception equals length. | new.getLength() == length
	 */
	public IllegalLengthException(int length){
		this.length = length;
	}
	/**
	 * A method returning the length of this illegal length exception.
	 * @return
	 */
	public int  getLength(){
		return this.length;
	}
	/**
	 * A variable storing the length of this illegal length exception.
	 */
	private int length;
}
