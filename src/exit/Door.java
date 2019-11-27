package exit;

import place.Place;

public class Door extends Exit {

	/**
	 * 
	 * @param P1
	 * @param P2
	 */
	public Door(Place P1, Place P2) {
            super(P1, P2);
	}

        @Override
        public String toString() {
            return "Door{" + '}';
        }

        
}
