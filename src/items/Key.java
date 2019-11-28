package items;

public abstract class Key extends TakeableItem {

    private final static int KEY_VOLUME = 1;

    /**
     * 
     * @param name
     * @param description
     */
    public Key(String name, String description) {
        super(Key.KEY_VOLUME, name, description);
    }
}