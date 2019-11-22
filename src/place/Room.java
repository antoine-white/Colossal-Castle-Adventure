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
	public Room(string description, string name, int level, Storage[] storages, TalkPaint[] paints, Ennemy[] ennemies) {
		// TODO - implement Room.Room
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param lamp
	 */
	public string search(boolean lamp) {
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
	public Item[] getItemsFromStorage(string storage) {
		// TODO - implement Room.getItemsFromStorage
		throw new UnsupportedOperationException();
	}

	public string talkToPaint() {
		// TODO - implement Room.talkToPaint
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param storage
	 * @param item
	 */
	public Item getItemFromStorage(string storage, string item) {
		// TODO - implement Room.getItemFromStorage
		throw new UnsupportedOperationException();
	}
}