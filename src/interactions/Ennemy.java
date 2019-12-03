package interactions;

public abstract class Ennemy {

    private int hp;    
    private int damage;

    private static int DEFAULT_HP;
    private static int DEFAULT_DAMAGE;

    /**
     * create an ennemy with Ennemy.DEFAULT_HP and
     *  Ennemy.DEFAULT_DAMAGE
     */
    public Ennemy() {
        this(Ennemy.DEFAULT_HP, Ennemy.DEFAULT_DAMAGE);
    }

    /**
     * 
     * @param hp the health point of the new Armor 
     * @param damage the damage the armor gives each time he hits
     */
    public Ennemy(int hp, int damage) {
        this.hp = hp;
        this.damage = damage;
    }

    /**
     * 
     * @return the damage the ennemy is supposed to hit unless he is dead
     * in witch case it's 0
     */
    public int attack() {
        if (this.hp > 0) {
            return this.damage;
        } else {
            return 0;
        }
    }

    /**
     * 
     * @param damage the damage he takes
     * @return the number of hp remaining after the attack
     */
    public int attacked(int damage) {
        this.hp -= damage;
        return this.hp;
    }

    @Override
    abstract public String toString();

}