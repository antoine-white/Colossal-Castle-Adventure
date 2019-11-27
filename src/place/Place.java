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
     * @return le nom de la place
     */
    public String getName() {
	return this.name;
    }
    
    /**
     * 
     * @param lampOn regarde si la lampe est allumé pour savoir si on voit les sorties secrettes
     * @return la Map<String,Exit> de sortie de la piece
     */
    public Map<String,Exit> getExits(boolean lampOn){
        Map<String,Exit> tmp = new HashMap<>();
        if(lampOn){
            for(Exit e : this.EXITS){
                tmp.put(e.getNextPlace(this).name, e);
            }
        } else {
            for(Exit e : this.EXITS){
                if (!(e instanceof SecretExit)){
                    tmp.put(e.getNextPlace(this).name, e);
                }
            }
            
        }
        return tmp;
    }
    
    /**
     *
     * @param e ajoute une sortie à la place
     */
    public void setExit(Exit e){
            this.EXITS.add(e);
    }
}
