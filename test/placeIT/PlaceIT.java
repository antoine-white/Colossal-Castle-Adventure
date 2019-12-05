package placeIT;

import org.junit.Test;
import static org.junit.Assert.*;


import exit.*;
import place.*;
import items.*;
import java.util.Map;
import player.*;
import storage.*;

public class PlaceIT {

    @Test
    public void getExits() {
        String b = "b";
        String c = "c";
        Place p = new Room("a","",0,null,null);
        Place p1 = new Room("",b,0,null,null);
        Place p2 = new Room("",c,0,null,null);
        Exit e = new Door(p,p1);
        Exit e2 = new Door(p,p2);
        p.setExit(e);
        p.setExit(e2);
        Map<String,Exit> tmp = p.getExits(true);
        assertTrue(tmp.containsKey(b));
        assertTrue(tmp.containsKey(c));
    }
}
