package place;

public interface lockable extends ItemReceiver{

	boolean isLocked;

	/**
	 * 
	 * @param key
	 */
	abstract boolean unlock(Key key);

	abstract boolean getIsLocked();
}