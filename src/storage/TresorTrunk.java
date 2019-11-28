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
	public TresorTrunk() {
		super();
	}

	@Override
	public void unlock(Key key) {
		if (key instanceof TrunkKey) {
			super.unlock();			
		}
	}
}