package place;

public interface Lockable{

	/**
	 * 
	 * @param key
	 */
	abstract boolean unlock();

	abstract boolean getIsLocked();
}
