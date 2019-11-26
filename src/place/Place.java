package place;

import exit.Exit;
import java.util.*;

public abstract class Place {

    private String name;
    private Collection<Exit> EXITS;
    private String description;

    /**
     * 
     * @param name
     */
    public Place(String name, String description) {
        this.name = name;
        this.description = description;
        this.EXITS = new ArrayList<>();
    }
    
    

    /**
     *
     * @return
     */
    public String getName() {
		return this.name;
	}
        
    /**
     *
     * @return
     */
    public Collection<Exit> getExit(){
            return this.EXITS;
        }
    
    /**
     *
     * @param e
     */
    public void setExit(Exit e){
            this.EXITS.add(e);
    }

    /**
     * 
     * @param String
     */
    public Place getPlaceFromString(int String) {
    	// TODO - implement Place.getPlaceFromString
    	throw new UnsupportedOperationException();
    }
}
