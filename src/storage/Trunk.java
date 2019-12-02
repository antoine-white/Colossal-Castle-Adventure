package storage;

public class Trunk extends Storage {

	private static int DEFAULT_CAP_TRUNK = 200;
	/**
	 * 
	 * @param capacity the capacity of the new Trunk
	 */
	public Trunk(int capacity) {
		super(capacity);
	}

	/**
	 * create a new Trunk with Trunk.DEFAULT_CAP_TRUNK capacity
	 */
	public Trunk() {
		this(Trunk.DEFAULT_CAP_TRUNK);
	}

	
}