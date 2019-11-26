package exit;

import items.DoorKey;
import items.Key;
import items.TakeableItem;
import place.Place;
import projet.Lockable;

public class LockedWindow extends Window implements Lockable {

    private boolean isLocked;
    
    /**
     * 
     * @param P1
     * @param P2
     */
    public LockedWindow(Place P1, Place P2) {
        super(P1, P2);
        this.isLocked = true;
    }

    /**
     * @param k
     */
    public boolean unlock(Key k) {
        if (k instanceof DoorKey) {
            this.unlock();
            return true;
        } else {
            return false;
        }
    }

    /**
    * unlock the Door
    */
    protected void unlock() {
	this.isLocked = false;
    }
    
    @Override
    public boolean getIsLocked() {
        return this.isLocked;
    }

}
