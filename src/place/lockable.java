package place;

public interface Lockable{

	boolean isLocked = false;

	/**
	 * 
	 * @param key
	 */
	abstract boolean unlock();

	abstract boolean getIsLocked();
}