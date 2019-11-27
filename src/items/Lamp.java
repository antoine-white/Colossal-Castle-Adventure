package items;

public class Lamp extends Item {

    private boolean isOn;
    private final static boolean DEFAULT_STATE = false;
    private final static String  DEFAULT_NAME = "Lamp";
    private final static String DEFAULT_DESCRIPTION = "A Lamp that allows you to see hidden things...";

    /**
     * 
     */
    public Lamp(){
        this(Lamp.DEFAULT_NAME, Lamp.DEFAULT_DESCRIPTION);
    }

    /**
     * 
     * @param name
     * @param description
     */
    public Lamp(String name, String description) {
        this(Lamp.DEFAULT_STATE, name, description);
    }

    /**
     * 
     * @param isOn
     * @param name
     * @param description
     */
    public Lamp(boolean isOn, String name, String description) {
        super(name, description);
        this.isOn = isOn;
    }

    /**
     * 
     * @return
     */
    public boolean getIsOn() {
        return this.isOn;
    }

    /**
     * 
     */
    public void switchOnLamp() {
        this.isOn = true;
    }

    /**
     * 
     */
    public void switchOffLamp() {
        this.isOn = false;
    }

}