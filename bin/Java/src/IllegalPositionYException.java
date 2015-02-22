/**
  A class of exceptions signaling illegal y coordinates of the LB pixel of Mazub.
 * 	Each illegal positiony exception involves the illegal y coordinate.
 * @author Pieter
 * @version 1.0
 */
public class IllegalPositionYException extends RuntimeException {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		/**
		 * 
		 * @param positiony
		 * 			The y coordinate of the position of this Illegal positiony exception.
		 * @post The positiony of this new created Illegal positiony exception equals positiony. 
		 */
		public IllegalPositionYException(int positiony){
			this.positiony = positiony;
		}
		/**
		 * Return the positiony of this Illegal positiony exception.
		 * @return
		 */
		public int getPositionY(){
			return this.positiony;
		}
		/**
		 * A variable registering the positiony of this Illegal positiony exception.
		 */
		public int positiony;
}
