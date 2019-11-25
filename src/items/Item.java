package items;

public abstract class Item {

	private final String NAME;

	/**
	 * 
	 * @param name
	 * @param description
	 */
	public Item(String name, String description) {
                this.NAME = name; 
                System.out.println("C'est objet est " + description);
		throw new UnsupportedOperationException();
	}
        
        /**
         * 
         * @return 
         */
	public String getNAME() {               
            return NAME; 
                           
	}
        
        /**
         * 
         * @return 
         */
	public String toString() {
		// TODO - implement Item.toString
		throw new UnsupportedOperationException();
	}
}