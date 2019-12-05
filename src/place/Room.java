package place;


import interfaces.Describable;
import interactions.Ennemy;
import storage.Storage;

public class Room extends Place implements Describable {

    private final Storage STORAGE;
    private final Ennemy ENEMY;
    private final int LEVEL;
    private final String DESCRIPTION;
    
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
        this.LEVEL = level;
        this.ENEMY = ennemies;
        this.STORAGE = store;
        this.DESCRIPTION = description;
    }

    /**
     * 
     * @return le coffre s'il y en a un dans la piece
     */
    public Storage getStorage() {
        return this.STORAGE;
    }

    /**
     *
     * @return l'ennemie s'il y en a un dans la piece
     */
    public Ennemy getEnnemy() {
        return this.ENEMY;
    }

    /**
     *
     * @return le niveau de l'étage où se trouve la room
     */
    public int getLevel() {
    	return this.LEVEL;
    }

    /**
     * 
     * @return the description of the room
     */
    @Override
    public String readDescription() {
        return this.DESCRIPTION;
    }
}
