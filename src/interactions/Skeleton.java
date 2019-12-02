package interactions;

public class Skeleton extends Ennemy {

	private static int DEFAULT_DAMAGE_S = 5;
	private static int DEFAULT_HP_SKE = 30;

        /**
         * 
         * @param hp
         * @param damage 
         */
        public Skeleton(int hp, int damage) {
            super(hp,damage);
        }
	
	public Skeleton(){
		this(Skeleton.DEFAULT_HP_SKE,Skeleton.DEFAULT_DAMAGE_S);
	}

        @Override
        public String toString() {
            return "Skeleton "; 
        }

        

}
