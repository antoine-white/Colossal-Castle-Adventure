package place;


import interfaces.Describable;
import interactions.Ennemy;
import storage.Storage;

public class Room extends Place implements Describable {

    private Storage storage;
    private Ennemy ennemy;
    private int level;
    private String description;
    
    /**
     * Constructor
     * 
     * @param description 
     * @param name
     * @param level
     * @param store
     * @param ennemies 
     */
    public Room(String description, String name, int level, 
        Storage store, Ennemy ennemies) {
        super(name);
        this.level = level;
        this.ennemy = ennemies;
        this.storage = store;
        this.description = description;
    }

    /**
     * 
     * @return le coffre s'il y en a un dans la piece
     */
    public Storage getStorage() {
        return this.storage;
    }

    /**
     *
     * @return l'ennemie s'il y en a un dans la piece
     */
    public Ennemy getEnnemy() {
        return this.ennemy;
    }

    /**
     *
     * @return le niveau de l'étage où se trouve la room
     */
    public int getLevel() {
    	return this.level;
    }

    /**
     * 
     * @return the description of the room
     */
    @Override
    public String readDescription() {
        return this.description;
    }
}
