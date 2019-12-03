package items;

public class Stick extends Weapon {

    private static int DEFAULT_DAMAGE = 30;

    /**
     * 
     * @param damage damage of the stick
     * @param VOLUME his volume
     * @param name name of the stick
     * @param description a description of the stick
     */
    public Stick(int damage, int VOLUME, String name, String description) {
        super(damage, VOLUME, name, description);
    }

    /**
     * create a stick with the given parameters and 
     * deafault damage
     * @param VOLUME his volume
     * @param name name of the stick
     * @param description a description of the stick
     */
    public Stick(int VOLUME, String name, String description) {
        this(Stick.DEFAULT_DAMAGE, VOLUME, name, description);
    }
}
