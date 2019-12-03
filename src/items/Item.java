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
	 * @return the name of the item
	 */
	public String getNAME() {
		return this.NAME;
	}

	@Override
	public String readDescription() {
		return this.DESCRIPTION;
	}
}