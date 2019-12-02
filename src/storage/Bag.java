package storage;

public class Bag extends Storage {

	private static int BAG_CAPACITY = 40;

	/**
	 * create a new Bag with Bag.BAG_CAPACITY capacity
	 */
	public Bag() {
		super(Bag.BAG_CAPACITY);
	}

	/**
	 * 
	 * @param capacity the capacity of the new Bag
	 */
	public Bag(int capacity){
		super(capacity);
	}
}