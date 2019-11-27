package exit;

import items.DoorKey;
import items.Key;
import place.Place;
import place.Lockable;

public class LockedDoor extends Door implements Lockable {

    
    private boolean isLocked;
    
    /**
     * @param P1
     * @param P2
     */
    public LockedDoor(Place P1, Place P2) {
        super(P1, P2);
        this.isLocked = true;
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
	this.isLocked = false;
    }
        
    /**
     * 
     * @return 
     */
    @Override
    public boolean getIsLocked() {
        return this.isLocked;
    }

}
