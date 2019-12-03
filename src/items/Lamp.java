package items;

public class Lamp extends Item {

    private boolean isOn;
    private final static boolean DEFAULT_STATE = false;
    private final static String  DEFAULT_NAME = "Lamp";
    private final static String DEFAULT_DESCRIPTION = "A Lamp that allows you to see hidden things...";

    /**
     * create a lamp with default state,name and description
     */
    public Lamp(){
        this(Lamp.DEFAULT_NAME, Lamp.DEFAULT_DESCRIPTION);
    }

    /**
     * create a lamp with the parameters given and
     * the default state
     * @param name the name of the lamp
     * @param description the description of the lamp
     */
    public Lamp(String name, String description) {
        this(Lamp.DEFAULT_STATE, name, description);
    }

    /**
     * 
     * @param isOn the initial state of the lamp
     * @param name the name of the lamp
     * @param description the description of the lamp
     */
    public Lamp(boolean isOn, String name, String description) {
        super(name, description);
        this.isOn = isOn;
    }

    /**
     * 
     * @return if the lamp is on
     */
    public boolean getIsOn() {
        return this.isOn;
    }

    /**
     * put the lamp on 
     */
    public void switchOnLamp() {
        this.isOn = true;
    }

    /**
     * put the lamp off
     */
    public void switchOffLamp() {
        this.isOn = false;
    }

}