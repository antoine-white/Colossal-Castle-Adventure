package place;

import java.util.*;

public class Room extends Place implements describable {

	private Collection<Storage> storages;
	private Ennemy ennemy;
	private TalkPaint talkPaints;
	private int level;

	/**
	 * 
	 * @param description
	 * @param name
	 * @param level
	 * @param storages
	 * @param paints
	 * @param ennemies
	 */
	public Room(String description, String name, int level, Storage[] storages, TalkPaint[] paints, Ennemy[] ennemies) {
		// TODO - implement Room.Room
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param lamp
	 */
	public String search(boolean lamp) {
		// TODO - implement Room.search
		throw new UnsupportedOperationException();
	}

	public Ennemy getEnnemy() {
		return this.ennemy;
	}

	public int getLevel() {
		return this.level;
	}

	/**
	 * 
	 * @param storage
	 */
	public Item[] getItemsFromStorage(String storage) {
		// TODO - implement Room.getItemsFromStorage
		throw new UnsupportedOperationException();
	}

	public String talkToPaint() {
		// TODO - implement Room.talkToPaint
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param storage
	 * @param item
	 */
	public Item getItemFromStorage(String storage, String item) {
		// TODO - implement Room.getItemFromStorage
		throw new UnsupportedOperationException();
	}

	public Collection<storage> getStorages(){
		return this.storages;
	}
}