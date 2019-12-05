package exitIT;

import org.junit.Test;
import static org.junit.Assert.*;

import exit.*;
import place.*;

public class ExitIT {

    @Test
    public void getNextPlace() {
        Place p = new Room(null,null,0,null,null);
        Place p2 = new Room(null,null,0,null,null);
        Exit e = new Door(p,p2);
        assertEquals(e.getNextPlace(p2),p);
        assertEquals(e.getNextPlace(p),p2);
    }
}