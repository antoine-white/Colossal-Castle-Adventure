package player;
import items.*; 
import storage.Bag; 
import main.ItemReceiver; 

public class Player implements ItemReceiver{

	private Weapon activeWeapon;
	private Lamp LAMP;
	private Bag BAG;
	private int hp;
        private final int MAX_HP = 100;  
	private static int NO_WEAPON_DAMAGE;

        /**
         * 
         * @param LAMP
         * @param BAG
         * @param hp 
         */
        public Player(Lamp LAMP, Bag BAG, int hp) {
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
            if (activeWeapon != null){
                return this.activeWeapon.attack(); 
            } else {
                return NO_WEAPON_DAMAGE; 
            }
	}

	/**
	 * 
	 * @param damage
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

        
        
        /**
         * 
         * @param tItem
         * @return 
         */
        @Override
        public boolean receiveItem(TakeableItem tItem) {
            if(tItem instanceof HealObject && this.hp < this.MAX_HP){
                this.hp += ((HealObject)tItem).getNB_HP_HEALED(); 
                return true; 
            } else if(this.activeWeapon == null && tItem instanceof Weapon){
                this.activeWeapon = ((Weapon)tItem); 
                return true; 
            } else {
                return false; 
            }
        }

        
}