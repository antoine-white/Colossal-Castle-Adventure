package StorageIT;


import org.junit.Test;
import static org.junit.Assert.*;

import storage.*;
import items.*;

public class LockableTrunkIT {
    
    @Test
    public void lock() {
        LockableTrunk t = new LockableTrunk();
        assertFalse(t.canAddItem(0));
        t.unlock(null);
        assertTrue(t.getIsLocked());
        t.unlock(new TrunkKey("",""));        
        assertTrue(t.canAddItem(0));
        t.unlock(null);
        assertFalse(t.getIsLocked());
    }
}
