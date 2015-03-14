package jumpingalien.model;

public enum Direction {
	/**
	 * A enumuration with the 2 posible direction (Left and Right)
	 */
	LEFT { public int getSign(){
			return -1;
	}},
	RIGHT{ public int getSign(){
		return 1;
	}};
	/**
	 * A method returning the sign of each direction.
	 * @return If LEFT then return -1
	 * @return If RIGHT then return 1
	 */
	public abstract int getSign();
}
