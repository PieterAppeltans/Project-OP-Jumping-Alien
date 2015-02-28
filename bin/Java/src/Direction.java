
public enum Direction {
	LEFT { public int getSign(){
			return -1;
	}},
	RIGHT{ public int getSign(){
		return 1;
	}};
	
	public abstract int getSign();
}
