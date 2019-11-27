package place;

public interface lockable{

	boolean isLocked = false;

	/**
	 * 
	 * @param key
	 */
	abstract boolean unlock();

	abstract boolean getIsLocked();
}