package exit;

import items.DoorKey;
import items.Key;
import place.Place;
import projet.Lockable;

public class OneWayLockedDoor extends OneWayDoor implements Lockable {

    private boolean isLocked;
    
    /**
     * 
     * @param beforePlace
     * @param P2 
     */
    public OneWayLockedDoor(Place beforePlace, Place P2) {
        super(beforePlace, P2);
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
     * 
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
