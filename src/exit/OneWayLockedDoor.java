package exit;

import place.Place;
import interfaces.Lockable;
import items.Key;

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
     */
    @Override
    public void unlock() {
	this.isLock = false;
    }
    
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
