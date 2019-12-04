package storage;

import java.util.Collection;

import items.*;
import interfaces.*;

public class LockableTrunk extends Trunk implements Lockable,CanTakeItem {

	private boolean isLocked;

	/**
	 * create a new LockableTrunk with Trunk.DEFAULT_CAP_TRUNK capacity
	 */
	public LockableTrunk(){
		super();
		this.isLocked = true;
	}

	/**
	 * 
	 * @param capacity the capacity of the new LockableTrunk
	 */
	public LockableTrunk(int capacity) {
		super(capacity);
		this.isLocked = true;
	}

	/**
	 * create a new LockableTrunk with Trunk.DEFAULT_CAP_TRUNK capacity
	 */
	public LockableTrunk(TakeableItem initialItem) {
		super();
		super.addItem(initialItem);
	}

	/**
	 * unlock the Trunk
	 */
	protected void unlock() {
		this.isLocked = false;
	}

	@Override
	public void unlock(Key key){
		if(key instanceof TrunkKey){
			this.unlock();
		}
	}

	/**
	 * 
	 * @return if the Trunk is locked
	 */
	public boolean getIsLocked() {
		return this.isLocked;
	}

	protected void addItemToLock(TakeableItem newItem){
		super.addItem(newItem);
	}

	/**
	 * add an item only if the Trunk is unlocked
	 */
	@Override
	public boolean addItem(TakeableItem newItem) {
		if (this.getIsLocked()) {
			return false;
		} else {
			return super.addItem(newItem);
		}		
	}
	/**
	 * @param itemVol the volume of the item we would like to test if we can add 
	 * it to the storage
	 * @return if this item can be added given its volume and if the Trunk is unlocked
	 */
	@Override
	public boolean canAddItem(int itemVol) {
		if (this.getIsLocked()) {
			return false;
		} else {
			return super.canAddItem(itemVol);
		}	
	}

	/**
	 * @return -1 if the Trunk is locked and the actual volume otherwise
	 */
	@Override
	public int getCurrentVol() {
		if (this.getIsLocked()) {
			return -1;
		} else {
			return super.getCurrentVol();
		}			
	}

	/**
	 * @return null if the Trunk is locked and the all the items in the Trunk
	 */
	@Override
	public Collection<TakeableItem> getItems() {
		if (this.getIsLocked()) {
			return null;
		} else {				
			return super.getItems();
		}
	}

	@Override
	public boolean removeItem(TakeableItem toRemove) {
		if (this.getIsLocked()) {
			return false;
		} else {	
			return super.removeItem(toRemove);
		}
	}
}