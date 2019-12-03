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
    private static int NO_WEAPON_DAMAGE = 15;

    /**
     * 
     * @param LAMP
     * @param BAG
     */
    public Player(Lamp LAMP, Bag BAG) {
        this.LAMP = LAMP;
        this.BAG = BAG;
        this.hp = MAX_HP;
        this.activeWeapon = null;
    }

    /**
     * 
     * @return
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
     * @param damage
     * @return
     */
    public int attacked(int damage) {
        this.hp -= damage;
        return this.hp;
    }

    /**
     * 
     * @return
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
