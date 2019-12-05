package exitIT;

import org.junit.Test;
import static org.junit.Assert.*;

import exit.*;
import place.*;

public class OneWayDoorIT {

    @Test
    public void getNextPlace() {
        Place p = new Room(null,null,0,null,null);
        Place p2 = new Room(null,null,0,null,null);
        OneWayDoor e = new OneWayDoor(p,p2);
        assertNull(e.getNextPlace(p2));
        assertEquals(e.getNextPlace(p),p2);
    }
}