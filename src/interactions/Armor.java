package interactions;

public class Armor extends Ennemy {

    private static int DEFAULT_HP_ARMOR = 50;
    private static int DEFAULT_DAMAGE_ARMOR = 5;

    /**
     * 
     * @param hp the health point of the new Armor 
     * @param damage the damage the armor gives each time he hits
     */
    public Armor(int hp, int damage) {
        super(hp, damage);
    }

    /**
     * create a new Armor with Armor.DEFAULT_HP_ARMOR and 
     * Armor.DEFAULT_DAMAGE_ARMOR
     */
    public Armor() {
        this(Armor.DEFAULT_HP_ARMOR, Armor.DEFAULT_DAMAGE_ARMOR);
    }

    @Override
    public String toString() {
        return "Armor ";
    }

}