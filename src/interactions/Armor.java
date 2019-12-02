package interactions;

public class Armor extends Ennemy {

	private static int DEFAULT_HP_ARMOR = 50;
	private static int DEFAULT_DAMAGE_ARMOR = 5;

          
        /**
         * 
         * @param hp
         * @param damage 
         */
        public Armor(int hp, int damage) {
            super(hp,damage);
        }

        public Armor(){
            this(Armor.DEFAULT_HP_ARMOR, Armor.DEFAULT_DAMAGE_ARMOR);
        }

        @Override
        public String toString() {
            return "Armor ";
        }
        
        
}