package place;

public interface lockable extends ItemReceiver{

	boolean isLocked;

	/**
	 * 
	 * @param key
	 */
	abstract boolean unlock();

	abstract boolean getIsLocked();
}