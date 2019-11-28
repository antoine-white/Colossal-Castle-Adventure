package interactions;

public abstract class Ennemy {

    private int hp;
    private static int DEFAULT_HP;
    private static int DEFAULT_DAMAGE;
    private int damage;

    /**
     * 
     */
    public Ennemy() {
        this.hp = DEFAULT_HP;
        this.damage = DEFAULT_DAMAGE;
    }

    /**
     * 
     * @param hp
     * @param damage
     */
    public Ennemy(int hp, int damage) {
        this.hp = hp;
        this.damage = damage;

        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @return
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
     * @param damage
     * @return the number of hp remaining after the attack
     */
    public int attacked(int damage) {
        this.hp -= damage;
        return this.hp;
    }

    @Override
    abstract public String toString();

    

}