package interactions;

public class Armor extends Ennemy {

	private static int DEFAULT_HP_ARMOR;
	private static int DEFAULT_DAMAGE_ARMOR;

          
        /**
         * 
         * @param hp
         * @param damage 
         */
        public Armor(int hp, int damage) {
            super(DEFAULT_HP_ARMOR, DEFAULT_DAMAGE_ARMOR);
        }
        
        /**
         * 
         * @param damage 
         */
        @Override
        public void attacked(int damage) {
            super.attacked(damage); //To change body of generated methods, choose Tools | Templates.
        }

        /**
         * 
         * @return 
         */
        @Override
        public int attack() {
            return super.attack(); //To change body of generated methods, choose Tools | Templates.
        }
        
}