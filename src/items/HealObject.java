package items;

public class HealObject extends TakeableItem {

	private static int DEFAULT_VOLUME;
	private static int DEFAULT_HP_HEALED;
	private int NB_HP_HEALED;

	/**
         * 
         * @param NB_HP_HEALED
         * @param VOLUME
         * @param name
         * @param description 
         */
	public HealObject(int NB_HP_HEALED, int VOLUME, String name, String description) {
            super(VOLUME, name, description);
            this.NB_HP_HEALED = NB_HP_HEALED;
        }
        
        /**
         * 
         * @param NB_HP_HEALED
         * @param name
         * @param description 
         */
        public HealObject(int NB_HP_HEALED, String name, String description) {
            super(DEFAULT_VOLUME, name, description);
            this.NB_HP_HEALED = NB_HP_HEALED;
        }
    
        /**
         * 
         * @return 
         */
	public int getNB_HP_HEALED() {
            return NB_HP_HEALED; 
	}
}