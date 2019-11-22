package place;

public interface lockable {

	boolean isLocked = false;

	/**
	 * 
	 * @param parameter
	 */
	boolean unlock(Key parameter);

	boolean getIsLocked();
}