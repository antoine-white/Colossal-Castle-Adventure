package items;

public abstract class Key extends TakeableItem {

	private int DEFAULT_VOLUME;
        
        /**
         * 
         * @param name
         * @param description 
         */
	public Key(String name, String description) {
            super(name, description);
        }
}