package exit;

import items.DoorKey;
import items.Key;
import place.Place;
import place.Lockable;

public class OneWayLockedDoor extends OneWayDoor implements Lockable {

    private boolean isLock;
    
    /**
     * 
     * @param beforePlace
     * @param P2 
     */
    public OneWayLockedDoor(Place beforePlace, Place P2) {
        super(beforePlace, P2);
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
     * 
     */
    protected void unlock() {
	this.isLock = false;
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
