package place;

public interface lockable{

	/**
	 * 
	 * @param key
	 */
	abstract boolean unlock();

	abstract boolean getIsLocked();
}
