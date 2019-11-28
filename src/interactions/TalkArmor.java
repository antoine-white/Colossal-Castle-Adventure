package interactions;

public class TalkArmor extends Armor implements Talkable {

       
	private final static String DEFAULT_DIALOG = "I'll kill you"; 
        private final String DIALOG; 
	
        
        /**
         * 
         * @param hp
         * @param damage 
         */
        public TalkArmor(int hp, int damage) {
            super(hp, damage);
            this.DIALOG = TalkArmor.DEFAULT_DIALOG; 
        }

        /**
         * 
         * @return 
         */    
        @Override
        public String talk() {
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