package exitIT;

import org.junit.Test;
import static org.junit.Assert.*;

import exit.*;
import place.*;
import items.*;

public class LockedDoorIT {

    @Test
    public void lock() {
        Place p = new Room(null,null,0,null,null);
        Place p2 = new Room(null,null,0,null,null);
        LockedDoor e = new LockedDoor(p,p2);
        assertTrue(e.getIsLocked());
        e.unlock(new TrunkKey("",""));
        assertTrue(e.getIsLocked());
        e.unlock(new DoorKey("",""));
        assertFalse(e.getIsLocked());
    }
}