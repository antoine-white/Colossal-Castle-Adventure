package exit;

import items.DoorKey;
import items.Key;
import place.Place;
import place.Lockable;

public class LockedWindow extends Window implements Lockable {

    private boolean isLock;
    
    /**
     * 
     * @param P1
     * @param P2
     */
    public LockedWindow(Place P1, Place P2) {
        super(P1, P2);
        this.isLock = true;
    }

    /**
     * 
     * @param k
     * @return 
     */
    @Override
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
	this.isLock = false;
    }
    
    @Override
    public boolean getIsLocked() {
        return this.isLock;
    }

}
