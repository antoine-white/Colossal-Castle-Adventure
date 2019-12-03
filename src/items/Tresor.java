
package items;
import interfaces.CanTakeItem;

/**
 *
 * @author mziar01
 */
public class Tresor extends TakeableItem{

    public Tresor(int VOLUME, String name, String description) {
        super(VOLUME, name, description);
    }

    
    
    @Override
    public boolean use(CanTakeItem o){
        return false; 
    }

    
    
    
}
