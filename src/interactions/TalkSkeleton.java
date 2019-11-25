package interactions;

public class TalkSkeleton extends Skeleton implements Talkable {

	private final static String DEFAULT_DIALOG = "MEURS !"; 
        private final String DIALOG; 
	
        
        /**
         * 
         * @param hp
         * @param damage 
         */
        public TalkSkeleton(int hp, int damage) {
            super(hp, damage);
            this.DIALOG = TalkSkeleton.DEFAULT_DIALOG; 
        }
        
        /**
         * 
         * @return 
         */
        @Override
        public String talk(){
            return this.DIALOG; 
        }

        /**
         * 
         * @return 
         */
        @Override
        public int attack() {
            this.talk(); 
            return super.attack(); 
        }
}