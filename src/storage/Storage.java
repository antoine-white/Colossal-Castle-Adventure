package storage;

import java.util.*;

public abstract class Storage {

	private Collection<TakeableItem> takeableItems;
	private int CAPACITY;
	private int currentVol;
	private static int DEFAULT_CAP;

	/**
	 * 
	 * @param capacity
	 */
	public Storage(int capacity) {
		// TODO - implement Storage.Storage
		throw new UnsupportedOperationException();
	}

	public int getCurrentVol() {
		return this.currentVol;
	}

	public Item getItems() {
		// TODO - implement Storage.getItems
		throw new UnsupportedOperationException();
	}

	public Storage() {
		// TODO - implement Storage.Storage
		throw new UnsupportedOperationException();
	}

	public void addItem() {
		// TODO - implement Storage.addItem
		throw new UnsupportedOperationException();
	}
}