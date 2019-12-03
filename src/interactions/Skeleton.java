package interactions;

public class Skeleton extends Ennemy {

    private static int DEFAULT_DAMAGE_S = 5;
    private static int DEFAULT_HP_SKE = 30;

    /**
     * 
     * @param hp the health point of the new Armor
     * @param damage the damage the armor gives each time he hits
     */
    public Skeleton(int hp, int damage) {
        super(hp, damage);
    }

    /**
     * create a new skeleton with keleton.DEFAULT_HP_SKE and
     * Skeleton.DEFAULT_DAMAGE_S
     */
    public Skeleton() {
        this(Skeleton.DEFAULT_HP_SKE, Skeleton.DEFAULT_DAMAGE_S);
    }

    @Override
    public String toString() {
        return "Skeleton ";
    }

}
