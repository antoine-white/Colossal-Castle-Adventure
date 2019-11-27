package exit;

import java.util.*;
import place.Place;

public abstract class Exit {

	private Collection<Place> PLACES;

	/**
	 * 
	 * @param P1
	 * @param P2
	 */
	public Exit(Place P1, Place P2) {
            this.PLACES = new ArrayList<>();
            this.PLACES.add(P1);
            this.PLACES.add(P2);
	}

	/**
	 * 
	 * @param actualPlace
         * @return 
	 */
	public Place getNextPlace(Place actualPlace) {
            for(Place p : this.PLACES){
                if (p != actualPlace){
                    return p;
                }
            }
            return null;
	}
}
