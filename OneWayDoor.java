package exit;

public class OneWayDoor extends Door {

	/**
	 * the only place where the Player can come from
	 * He cannot take the door the other way
	 */
	private Place beforePlace;

	/**
	 * 
	 * @param actualPlace
	 * @param lampOn
	 */
	public Place getNextPlace(Place actualPlace, boolean lampOn) {
		// TODO - implement OneWayDoor.getNextPlace
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param beforePlace
	 * @param p2
	 */
	public OneWayDoor(Place beforePlace, Place p2) {
		// TODO - implement OneWayDoor.OneWayDoor
		throw new UnsupportedOperationException();
	}
}