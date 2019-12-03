package items;

import interfaces.*;

public abstract class Item implements Describable {

	private final String NAME;
	private final String DESCRIPTION;

	/**
	 * 
	 * @param name name of the item
	 * @param description its description
	 */
	public Item(String name, String description) {
		this.NAME = name;
		this.DESCRIPTION = description;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getNAME() {
		return this.NAME;
	}

	public String readDescription() {
		return this.DESCRIPTION;
	}
}