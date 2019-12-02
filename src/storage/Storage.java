package storage;

import java.util.*;

import items.TakeableItem;

public abstract class Storage {
	
	private final Collection<TakeableItem> TAKEABLE_ITEMS;
	private final int CAPACITY;
	private int currentVol;
	private static int DEFAULT_CAP = 10;

	/**
	 * 
	 * @param capacity the max capacity of the storage that it cannot exceed
	 */
	public Storage(int capacity) {
		this.CAPACITY = capacity;
		this.currentVol = 0;
		this.TAKEABLE_ITEMS = new ArrayList<>();
	}

	/**
	 * Create a Storage with Storage.DEFAULT_CAP capacity
	 */
	public Storage() {
		this(Storage.DEFAULT_CAP);
	}

	/**
	 * 
	 * @return the capacity of the storage
	 */
	public int getCAPACITY() {
		return this.CAPACITY;
	}

	/**
	 * 
	 * @return the sum of all the volume of all items in the storage
	 */
	public int getCurrentVol() {
		return this.currentVol;
	}

	/**
	 * 
	 * @return all the items in the storage
	 */
	public Collection<TakeableItem> getItems() {
		return this.TAKEABLE_ITEMS;
	}

	/**
	 * 
	 * @param itemVol the volume of the item we would like to test if we can add 
	 * it to the storage
	 * @return if this item can be added given its volume
	 */
	public boolean canAddItem(int itemVol) {
		return this.CAPACITY >= this.currentVol + itemVol;
	}

	/**
	 * add a item in the storage
	 * @param newItem the item that is added, if possible, to the storage
	 * @return if the item was added
	 */
	public boolean addItem(TakeableItem newItem) {
		if (this.canAddItem(newItem.getVOLUME())) {
			this.TAKEABLE_ITEMS.add(newItem);
			this.currentVol += newItem.getVOLUME();
			return true;
		} else {
			return false;
		}
	}	

	/**
	 * remove an item in the storage
	 * @param toRemove the item that has to be removed
	 * @return if it was removed succefully
	 */
	public boolean removeItem(TakeableItem toRemove){
		if(this.TAKEABLE_ITEMS.remove(toRemove)){
			this.currentVol -= toRemove.getVOLUME();
			return true;
		}else {
			return false;
		}
	}

	/**
	 * 
	 * @param ItemStr the name of the item that we want to get
	 * @return the item that has the name given in parameters,
	 * returns null otherwise
	 */
	public TakeableItem takeItem(String ItemStr) {
		for (final TakeableItem tItem : this.getItems()) {
			if (Objects.equals(tItem.getNAME(),ItemStr)) {
				this.removeItem(tItem);
				return tItem;
			}
		}
		return null;
	}
}