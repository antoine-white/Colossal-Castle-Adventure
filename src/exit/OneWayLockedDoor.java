package exit;

import place.Place;
import interfaces.Lockable;
import items.*;

public class OneWayLockedDoor extends OneWayDoor implements Lockable {

    private boolean isLock;

    /**
     * 
     * @param beforePlace the only place where the Player can come from he cannot
     *                    take the door the other way
     * @param P2
     */
    public OneWayLockedDoor(Place beforePlace, Place P2) {
        super(beforePlace, P2);
        this.isLock = true;
    }

    public void unlock() {
        this.isLock = false;
    }

    /**
     * @param k the key given to unlock the door
     */
    public void unlock(Key k) {
        if (k instanceof DoorKey) {
            this.unlock();
        }
    }

    @Override
    public boolean getIsLocked() {
        return this.isLock;
    }

}
