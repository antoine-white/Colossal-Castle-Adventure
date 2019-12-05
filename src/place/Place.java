package place;

import exit.Exit;
import exit.SecretExit;
import java.util.*;

public abstract class Place {

    private String name;
    private Collection<Exit> EXITS;

    /**
     * Constructor
     * 
     * @param name
     */
    public Place(String name) {
        this.name = name;
        this.EXITS = new ArrayList<>();
    }

    /**
     *
     * @return name of the place 
     */
    public String getName() {
        return this.name;
    }

    /**
     * 
     * @param lampOn if the lamp is on find hidden room
     * @return the Map of String and Exit 
     * 
     * 
    */
    public Map<String, Exit> getExits(boolean lampOn) {
        Map<String, Exit> tmp = new HashMap<>();
        if (lampOn) {
            for (Exit e : this.EXITS) {
                tmp.put(e.getNextPlace(this).name, e);
            }
        } else {
            for (Exit e : this.EXITS) {
                // this should not be handle here
                if (!(e instanceof SecretExit)) {
                    tmp.put(e.getNextPlace(this).name, e);
                }
            }

        }
        return tmp;
    }

    /**
     *
     * @param e add an exit the place
     */
    public void setExit(Exit e) {
        this.EXITS.add(e);
    }
}
