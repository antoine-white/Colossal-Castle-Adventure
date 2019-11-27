package place;


import interactions.Ennemy;
import interactions.TalkPaint;
import storage.Storage;

public class Room extends Place implements Describable {

    private Storage storage;
    private Ennemy ennemy;
    private TalkPaint talkPaints;
    private int level;
    private String description;
    
    /**
     * 
     * @param description
     * @param name
     * @param level
     * @param store
     * @param paints
     * @param ennemies 
     */
    public Room(String description, String name, int level, 
        Storage store, TalkPaint paints, Ennemy ennemies) {
        super(name);
        this.level = level;
        this.talkPaints = paints;
        this.ennemy = ennemies;
        this.storage = store;
        this.description = description;
    }

    /**
     * 
     * @return 
     */
    public Storage getStorage() {
        return this.storage;
    }

    /**
     *
     * @return
     */
    public Ennemy getEnnemy() {
        return this.ennemy;
    }

    /**
     *
     * @return
     */
    public int getLevel() {
    	return this.level;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String readDescription() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
