package storage;

import items.*;

public class TresorTrunk extends LockableTrunk {

	/**
	 * 
	 * @param capacity the capacity of the new TresorTrunk
	 */
	public TresorTrunk(int capacity) {
		super(capacity);
	}

	/**
	 * create a new TresorTrunk with Trunk.DEFAULT_CAP_TRUNK capacity
	 */
	public TresorTrunk(){
		super();
	}

	/**
	 * 
	 * @param key the key to unlock the trunk, it only works with TresorKey
	 * @return if the Trunk was successfully unlock
	 */
	@Override
	public boolean unlock(Key key) {
		if (key instanceof TresorKey) {
			this.unlock();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param tItem the item that should be applied to the instance
	 * @return true if it is a TresorKey and unlock the Trunk, returns 
	 * false otherwise 
	 */
	@Override
	public boolean receiveItem(TakeableItem tItem) {
		if (tItem instanceof TresorKey) {
			this.unlock((Key)tItem);
			return true;
		} else {
			return false;
		}
	}
}