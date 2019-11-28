package place;

import interactions.*;
import storage.Storage;

public class HiddenRoom extends Room {
    
	/**
         * 
         * @param description
         * @param name
         * @param level
         * @param store
         * @param ennemies 
         */
	public HiddenRoom(String description, String name, int level, 
                Storage store, Ennemy ennemies) {
            super(description, name, level, store, ennemies);
	}
}
