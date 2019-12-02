package items;

public class Stick extends Weapon {

    private static int DEFAULT_DAMAGE;

    /**
     * 
     * @param damage
     * @param VOLUME
     * @param name
     * @param description
     */
    public Stick(int damage, int VOLUME, String name, String description) {
        super(damage, VOLUME, name, description);
    }
    
    public Stick(int VOLUME, String name, String description){
        this(Stick.DEFAULT_DAMAGE,VOLUME,name,description);
    }
}
