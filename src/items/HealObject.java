package items;

public class HealObject extends TakeableItem {

	private static int DEFAULT_VOLUME;
	private static int DEFAULT_HP_HEALED;
	private int NB_HP_HEALED;

	/**
	 * 
	 * @param nbHPHealed
	 * @param name
	 */
	public HealObject(int nbHPHealed, String name) {
		super(name, DEFAULT_VOLUME, "");
		// TODO - implement HealObject.HealObject
		throw new UnsupportedOperationException();
	}

	public int getNB_HP_HEALED() {
		// TODO - implement HealObject.getNB_HP_HEALED
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public HealObject(String name) {
		this(HealObject.DEFAULT_HP_HEALED, name);
	}
}