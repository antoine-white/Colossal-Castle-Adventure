package StorageIT;

import org.junit.Test;
import static org.junit.Assert.*;


import storage.*;
import items.*;

public class StorageIT {
    
    @Test
    public void capacity() {
        int cap = 10;
        Storage s = new Bag(cap);
        assertEquals(s.getCAPACITY(),cap);
    }
    
    @Test
    public void canAddItem() {
        int cap = 10;
        Storage s = new Bag(cap);
        for (int i = 0; i < cap ;i++){
            s.addItem(new TresorKey(""+i,""));
        }
        assertFalse(s.canAddItem(1));
    }
    
    @Test
    public void addAndRemoveItem() {
        Storage s = new Bag(10);
        TresorKey k = new TresorKey("","");
        s.addItem(k);
        assertEquals(k,s.getItems().iterator().next());
        s.removeItem(k);
        assertEquals(s.getCurrentVol(),0);
    }
}
