package items;

import interfaces.CanTakeItem;

public abstract class TakeableItem extends Item {

    private final int VOLUME;

    /**
     * 
     * @return
     */
    public int getVOLUME() {
        return this.VOLUME;
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

    abstract public boolean use(CanTakeItem o);

}