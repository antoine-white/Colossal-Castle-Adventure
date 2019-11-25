package items;

public abstract class Weapon extends TakeableItem {

    private int damage;
    private static int DEFAULT_DAMAGE;
    private static int DEFAULT_VOLUME;

    /**
     * 
     * @param name
     * @param description
     */
    public Weapon(String name, String description) {
        this(Weapon.DEFAULT_VOLUME,name, description);
    }

    /**
     * 
     * @param VOLUME
     * @param name
     * @param description
     */
    public Weapon(int VOLUME, String name, String description) {
        super(Weapon.DEFAULT_DAMAGE,VOLUME, name, description);
    }

    /**
     * 
     * @param damage
     * @param VOLUME
     * @param name
     * @param description
     */
    public Weapon(int damage, int VOLUME, String name, String description) {
        super(VOLUME, name, description);
        this.damage = damage;
    }

    /**
     * 
     * @return
     */
    public int attack() {
        return this.damage;
    }
}