package interfaces;

import items.*;

public interface Lockable{

    /**
     * @param key the key given to unlock the object
     */
    abstract void unlock(Key key);

    /**
     * 
     * @return if the object is locked
     */
    abstract boolean getIsLocked();
}
