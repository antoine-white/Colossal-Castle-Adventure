package exit;

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
     */
    @Override
    public void unlock() {
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
