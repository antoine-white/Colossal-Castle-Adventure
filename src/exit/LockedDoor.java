package exit;

import place.Place;
import interfaces.Lockable;
import items.*;

public class LockedDoor extends Door implements Lockable {

    private boolean isLock;
    
    /**
     * @param P1
     * @param P2
     */
    public LockedDoor(Place P1, Place P2) {
        super(P1, P2);
        this.isLock = true;
    }
    
    /**
    * unlock the Door
    */
    public void unlock() {
	    this.isLock = false;
    }

    /**
     *
     */
    public void unlock(Key k) {
        if (k instanceof DoorKey) {
            this.unlock();
        }
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public boolean getIsLocked() {
        return this.isLock;
    }

}
