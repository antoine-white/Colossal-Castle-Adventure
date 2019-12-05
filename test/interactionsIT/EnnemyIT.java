package interactionsIT;

import org.junit.Test;
import static org.junit.Assert.*;

import interactions.*;

public class EnnemyIT {

    @Test
    public void attack() {
        int dmg = 90;      
        Ennemy e = new Skeleton(1,dmg);
        Ennemy e1 = new Skeleton(0,dmg);
        assertEquals(e.attack(),dmg);
        assertEquals(e1.attack(),0);
    }
    
    @Test
    public void attacked() {
        int hp = 90;      
        Ennemy e = new Skeleton(hp,0);
        e.attacked(10);
        assertEquals(e.attacked(0),80);
    }
}
