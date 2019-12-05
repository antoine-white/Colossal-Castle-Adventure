package playerIT;

import org.junit.Test;
import static org.junit.Assert.*;

import items.*;
import player.*;
import storage.*;

public class PlayerIT {
    @Test
    public void weapon() {
        final int playerWithoutWeapon = 15;// corespond to Player.NO_WEAPON_DAMAGE
        Stick s = new Stick(15,0,"","");
        Stick s2 = new Stick(35,0,"","");
        Player p = new Player(new Lamp(),new Bag());
        assertEquals(playerWithoutWeapon,p.attack());
        p.switchWeapon(s);
        assertEquals(s.attack(),p.attack());
        p.switchWeapon(s2);
        assertEquals(s2.attack(),p.attack());
    }
    
    @Test
    public void Lamp() {
        Player p = new Player(new Lamp(true,"",""),new Bag());
        assertTrue(p.getLampIsOn());
        p.changeLampStatus();
        assertFalse(p.getLampIsOn());
        p.changeLampStatus();
        assertTrue(p.getLampIsOn());
    }
    
}
