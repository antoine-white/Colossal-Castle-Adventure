package interactions;

public class TalkPaint extends Paint implements Talkable {

        
	private final static String DEFAULT_DIALOG = ""; 
        private final String DIALOG; 

        /**
         * 
         * @param dialog
         * @param description 
         */
        public TalkPaint(String dialog, String description) {
            super(description);
            this.DIALOG = TalkPaint.DEFAULT_DIALOG; 
        }
        
        /**
         * 
         * @return 
         */
        @Override
        public String talk(){
            return this.DIALOG; 
        }

	
}