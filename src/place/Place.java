package place;

import exit.Exit;
import exit.SecretExit;
import java.util.*;

public abstract class Place {

    private String name;
    private Collection<Exit> EXITS;

    /**
     * 
     * @param name 
     */
    public Place(String name) {
        this.name = name;
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
     * @param lampOn
     * @return
     */
    private Collection<Exit> getExits(boolean lampOn){
        if(lampOn){
            return this.EXITS;
        } else {
            Collection<Exit> res = new ArrayList<>();
            for(Exit e : this.EXITS){
                if (!(e instanceof SecretExit)){
                    res.add(e);
                }
            }
            return res;
        }
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
     * @param s
     * @param lampOn
     * @return 
     */
    public Map<String,Exit> getPlaceFromString(String s, boolean lampOn) {
        Collection<Exit> ext = getExits(lampOn);
    	Map<String,Exit> res = new HashMap<>();
        int i;
        for (i=0; i < ext.size(); i++){
            res.put("",ext.get(i));
        }
        return res;
    }
}
