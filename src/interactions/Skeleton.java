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

        @Override
        public String toString() {
            return "Skeleton "; 
        }

        

}