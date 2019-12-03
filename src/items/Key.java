package items;

import interfaces.*;

public abstract class Key extends TakeableItem {

    private final static int KEY_VOLUME = 1;

    /**
     * 
     * @param name name of the key
     * @param description description of the key
     */
    public Key(String name, String description) {
        super(Key.KEY_VOLUME, name, description);
    }

    /**
     */
     @Override
    public boolean use(CanTakeItem o){
        try {
            ((Lockable) o).unlock((Key)this);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}