package exit;

import java.util.*;
import place.Place;

public abstract class Exit {

	private Collection<Place> PLACES;

	/**
	 * 
	 * @param P1 the first place it give access to
	 * @param P2 the second place it give access to
	 */
	public Exit(Place P1, Place P2) {
		this.PLACES = new ArrayList<>();
		this.PLACES.add(P1);
		this.PLACES.add(P2);
	}

	/**
	 * 
	 * @param actualPlace the place you are at the moment you take the exit
	 * @return the place you should go given your actual place return null it fails to find a place
	 */
	public Place getNextPlace(Place actualPlace) {
		for (Place p : this.PLACES) {
			if (p != actualPlace) {
				return p;
			}
		}
		return null;
	}
}
