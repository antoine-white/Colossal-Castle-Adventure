package storage;

import java.util.Collection;

import items.*;

public class LockableTrunk extends Trunk implements lockable {

	private boolean isLocked;

	public LockableTrunk(){
		super();
		this.isLocked = true;
	}

	/**
	 * 
	 * @param capacity
	 */
	public LockableTrunk(int capacity) {
		super(capacity);
		this.isLocked = true;
	}

	/**
	 * 
	 * @param key
	 */
	public boolean unlock(Key key) {
		if (key instanceof TrunkKey) {
			this.isLocked = false;
			return true;
		} else {
			return false;
		}
	}

	public boolean getIsLocked() {
		return this.isLocked;
	}

	@Override
	public boolean addItem(TakeableItem newItem) {
		if (this.getIsLocked()) {
			return false;
		} else {
			return super.addItem(newItem);
		}		
	}

	@Override
	public boolean canAddItem(int itemVol) {
		if (this.getIsLocked()) {
			return false;
		} else {
			return super.canAddItem(itemVol);
		}	
	}

	@Override
	public int getCurrentVol() {
		if (this.getIsLocked()) {
			return false;
		} else {
			return super.getCurrentVol();
		}			
	}

	@Override
	public Collection<TakeableItem> getItems() {
		if (this.getIsLocked()) {
			return false;
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

	@Override
	public TakeableItem takeItem(String ItemStr) {
		if (this.getIsLocked()) {
			return false;
		} else {	
			return super.takeItem(ItemStr);
		}
	}

	public boolean receiveItem(TakeableItem tItem){
		
	}
	
}