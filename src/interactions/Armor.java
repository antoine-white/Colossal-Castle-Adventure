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

        @Override
        public String toString() {
            return "Armor ";
        }
        
        
}