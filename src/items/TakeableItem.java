package items;

import interfaces.CanTakeItem;

public abstract class TakeableItem extends Item {

    private final int VOLUME;

    /**
     * 
     * @param VOLUME volume of the item
     * @param name name of the item
     * @param description description of the item
     */
    public TakeableItem(int VOLUME, String name, String description) {
        super(name, description);
        this.VOLUME = VOLUME;
    }

    /**
     * 
     * @return the volume of the item
     */
    public int getVOLUME() {
        return this.VOLUME;
    }

    abstract public boolean use(CanTakeItem o);

}