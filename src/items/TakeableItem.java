package items;

public abstract class TakeableItem extends Item {

	private int VOLUME;

        /**
         * 
         * @return 
         */
	public int getVOLUME() {	
            return this.VOLUME; 
	}
        
        /**
         * 
         * @param name
         * @param description 
         */
	public TakeableItem(String name, String description) {
            super(name, description);
        }
        
        /**
         * 
         * @param VOLUME
         * @param name
         * @param description 
         */
        public TakeableItem(int VOLUME, String name, String description) {
            super(name, description);
            this.VOLUME = VOLUME;
        }
        
	
}