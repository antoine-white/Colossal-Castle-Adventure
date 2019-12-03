package items;

import interfaces.CanTakeItem;
import interfaces.CanTakeWeapon;

public abstract class Weapon extends TakeableItem {

    private int damage;
    private static int DEFAULT_DAMAGE = 10;
    private static int DEFAULT_VOLUME = 5;

    /**
     * 
     * @param name        name of the weapon
     * @param description a description of the weapon
     */
    public Weapon(String name, String description) {
        this(Weapon.DEFAULT_DAMAGE, Weapon.DEFAULT_VOLUME, name, description);
    }

    /**
     * 
     * @param damage      the damage the weapon deals at each hit
     * @param VOLUME      the volume the weapon takes
     * @param name        name of the weapon
     * @param description a description of the weapon
     */
    public Weapon(int damage, int VOLUME, String name, String description) {
        super(VOLUME, name, description);
        this.damage = damage;
    }

    /**
     * 
     * @return the damage the weapon deal at each damage
     */
    public int attack() {
        return this.damage;
    }

    @Override
    public boolean use(CanTakeItem o) {
        try {
            ((CanTakeWeapon) o).switchWeapon(this);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}