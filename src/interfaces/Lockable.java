package interfaces;

import items.*;

public interface Lockable{

    abstract void unlock(Key key);

    abstract boolean getIsLocked();
}
