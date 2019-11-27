package place;

import interactions.*;
import storage.Storage;

public class HiddenRoom extends Room {

	private static String DEFAULT_DESCRIPTION;

	/**
         * 
         * @param description
         * @param name
         * @param level
         * @param store
         * @param paints
         * @param ennemies 
         */
	public HiddenRoom(String description, String name, int level, 
                Storage store, TalkPaint paints, Ennemy ennemies) {
            super(description, name, level, store, paints, ennemies);
	}
}
