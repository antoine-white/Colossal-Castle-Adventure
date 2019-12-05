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
	 * @param beforePlace the only place where the Player can come from he cannot take the door the other way
	 * @param P2 
	 */
	public OneWayDoor(Place beforePlace, Place P2) {
		super(beforePlace,P2);
		this.beforePlace = beforePlace;
	}

	/**
	 * 
	 * @param actualPlace the place you are 
	 * @return null if you cannot access the room
	 */
	public Place getNextPlace(Place actualPlace) {
		if (actualPlace == this.beforePlace) {
			return super.getNextPlace(actualPlace);
		} else {
			return null;
		}
	}

} 
