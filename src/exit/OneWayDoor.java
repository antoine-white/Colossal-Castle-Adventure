package exit;

import place.Place;

public class OneWayDoor extends Door {

	/**
	 * the only place where the Player can come from
	 * He cannot take the door the other way
	 */
	private Place beforePlace;
        
        
    	/**
	 * 
	 * @param beforePlace
	 * @param P2
	 */
	public OneWayDoor(Place beforePlace, Place P2) {
            super(beforePlace, P2);
	}

}
