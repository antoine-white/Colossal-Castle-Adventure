package items;

import interfaces.CanTakeItem;
import player.*;

public class HealObject extends TakeableItem {

    private static final int DEFAULT_VOLUME = 5;
    private static final int DEFAULT_HP_HEALED = 20;

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
        this(NB_HP_HEALED, HealObject.DEFAULT_VOLUME, name, description);
    }

    /**
     *
     * @param name
     * @param description
     */
    public HealObject(String name, String description) {
        this(HealObject.DEFAULT_HP_HEALED, name, description);
    }

    /**
     * 
     * @return
     */
    public int getNB_HP_HEALED() {
        return this.NB_HP_HEALED;
    }

    @Override
    public boolean use(CanTakeItem o) {
        //try to cast the receiver of the item to Healable
        try {
            // if it worked we heal the receiver and return true
            ((Healable) o).heal(this.getNB_HP_HEALED());
        } catch (Exception e) {
            // otherwise we return false
            return false;
        }
        return true;
    }

}