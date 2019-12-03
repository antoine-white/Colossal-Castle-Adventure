package exit;

import place.*;
import interfaces.*;
import items.*;


public class LockedDoor extends Door implements Lockable, CanTakeItem {

    private boolean isLock;
    
    /**
     * @param P1 the first place it give access to
     * @param P2 the second place it give access to
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
     * unlock the door kiven a key
     * @param k a key to unlock the Door
     */
    public void unlock(Key k) {
        if (k instanceof DoorKey) {
            this.unlock();
        }
    }
    
    /**
     * 
     * @return if the door is locked
     */
    @Override
    public boolean getIsLocked() {
        return this.isLock;
    }

}
