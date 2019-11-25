package interactions;

public class Skeleton extends Ennemy {

	private static int DEFAULT_DAMAGE_S;
	private static int DEFAULT_HP_SKE;

        /**
         * 
         * @param hp
         * @param damage 
         */
        public Skeleton(int hp, int damage) {
            super(DEFAULT_HP_SKE, DEFAULT_DAMAGE_S);
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
            return super.attack();
        }
}