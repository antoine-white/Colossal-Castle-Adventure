
package items;
import interfaces.CanTakeItem;

/**
 *
 * @author mziar01
 */
public class Tresor extends TakeableItem{

    /**
     * 
     * @param VOLUME volume of the tresor
     * @param name name of the tresor
     * @param description description of the tresor
     */
    public Tresor(int VOLUME, String name, String description) {
        super(VOLUME, name, description);
    }

    
    
    @Override
    public boolean use(CanTakeItem o){
        // return false because it make no sense to "use" the tresor
        // and the game should be finish whan the user pick up the 
        //tresor anyway
        return false; 
    } 
    
}
