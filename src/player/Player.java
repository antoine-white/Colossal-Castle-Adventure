package player;

import interfaces.CanTakeItem;
import interfaces.CanTakeWeapon;
import items.*;
import storage.Bag;

public class Player implements Healable , CanTakeItem, CanTakeWeapon{

    private Weapon activeWeapon;
    private Lamp LAMP;
    private Bag BAG;
    private int hp;
    private final int MAX_HP = 100;
    private static final int NO_WEAPON_DAMAGE = 15;

    /**
     * 
     * @param LAMP the lamp the player use
     * @param BAG his bag
     */
    public Player(Lamp LAMP, Bag BAG) {
        this.LAMP = LAMP;
        this.BAG = BAG;
        this.hp = MAX_HP;
        this.activeWeapon = null;
    }

    /**
     * 
     * @return the damage the player does at each hit
     */
    public int attack() {
        if (activeWeapon != null) {
            return this.activeWeapon.attack();
        } else {
            return NO_WEAPON_DAMAGE;
        }
    }

    /**
     * 
     * @param damage damage taken
     * @return his hp after the attack
     */
    public int attacked(int damage) {
        this.hp -= damage;
        return this.hp;
    }

    /**
     * 
     * @return his current hp
     */
    public int getHp() {
        return this.hp;
    }

    public boolean getLampIsOn() {
        return this.LAMP.getIsOn();
    }

    /**
     * @return the BAG
     */
    public Bag getBAG() {
        return this.BAG;
    }

    public Weapon getWeapon(){
        return this.activeWeapon;
    }

    @Override
    public void heal(int nbHp) {
        this.hp += nbHp;
    }

    @Override
    public void switchWeapon(Weapon w) {
        if (this.activeWeapon == null) {
            this.activeWeapon = w;
        } else {
            this.BAG.addItem(this.activeWeapon);
            this.activeWeapon = w;
        } 
    }
    
    /**
     * 
     * @return if the player has the tresor in his bag
     */
    public boolean hasTresor(){
        return this.BAG.getItems().stream().filter(e->e instanceof Tresor).count() > 0;
    }

	public void changeLampStatus() {
        if (this.LAMP.getIsOn()) {
            this.LAMP.switchOffLamp();
        } else {
            this.LAMP.switchOnLamp();
        }
	}

}
