package game;

import java.util.*;
import java.util.stream.Collectors;

import exit.Exit;
import items.*;
import storage.Storage;
import place.*;

public enum Command {
    GO("help go","GO",1,1,(g,args)->Command.go(g,args[0])),
    HELP("help help","HELP",0,0,(g,args)->Printer.printMessage(Command.getHelp())),
    LOOK("help look","LOOK",0,1,(g,args)->Command.look(g,args)),
    TAKE("help take : ","TAKE",1,1,(g,args)->Command.take(g,args[0])),
    QUIT("help quit","QUIT",0,0,(g,args)->Command.quit(g)),
    USE("help use","USE",1,2,(g,args)->Command.quit(g)),
    SEARCH("help search","SEARCH",0,0,(g,args)->Command.search(g)),
    SEARCH_EXITS("help search exits","SEARCH_EXITS",0,0,(g,args)->Command.searchExits(g));
    
    private final String HELP_STR;
    private final String COMMAND_STR;
    private final int MIN_PARAM;
    private final int MAX_PARAM;
    private CommandFunction function;

    Command(String hELP_STR, String cOMMAND_STR, int mIN_PARAM, int mAX_PARAM, CommandFunction fct) {
        this.HELP_STR = hELP_STR;
        this.COMMAND_STR = cOMMAND_STR;
        this.MIN_PARAM = mIN_PARAM;
        this.MAX_PARAM = mAX_PARAM;
        this.function = fct;
    }

    public static Command strToCmd(String str) {
        Command tCommand = null;
        for(Command c: Command.values()){
            if ( Objects.equals(c.COMMAND_STR , str) || Objects.equals(c.COMMAND_STR.toLowerCase() , str)) {
                tCommand = c;
            }
        }
        return tCommand;
    }

    public static boolean hasCorrectParameters(Command c, int nbParam) {
        return nbParam >= c.MIN_PARAM && nbParam <=c.MAX_PARAM;
    }

    public static String getHelp() {
        String returnString = "";
        for(Command c: Command.values()){
            returnString += '\n' + c.HELP_STR;
        }
        return returnString;
    }

    public static void runCommand(Game g, Command c, String[] args) {
        c.function.runCommand(g,args);
    }

    public static void go(Game g, String placeStr) {
        Map<String,Exit> exits = g.getPlayerActualRoom().getExits(g.playerLampIsOn());
        for (Map.Entry<String, Exit> exit : exits.entrySet()) {
            if (Objects.equals(exit.getKey(),placeStr)){
                g.newRoomEntered(exit.getValue().getNextPlace(((Room)g.getPlayerActualRoom())));
                return;
            }
        }
        Printer.printError("Could not find a exit to a place named " + placeStr + " in this room"); 
    }

    public static void look(Game g, String[] itemStr) {
        if (itemStr.length == 0){
            Printer.printMessage(g.getPlayerActualRoom().readDescription());
        } else {
            boolean foundItem = false;
            Storage tmp = g.getPlayerActualRoom().getStorage();
            if (tmp != null) {
                for (TakeableItem item : tmp.getItems()) {
                    if (Objects.equals(itemStr[0],item.getNAME())) {
                        Printer.printMessage(item.readDescription());
                        foundItem = true;
                    }
                }   
            }
            if (!foundItem) {
                Printer.printError("Could not find a item with the named " + itemStr[0] + " in this room"); 
            }
        }
    }

    public static void quit(Game g){
        g.quitGame();
    }

    // TODO:
    public static void take(Game g, String itemStr) {

    }

    // TODO:
    public static void use(Game g, String[] args) {

    }

    // TODO:
    public static void search(Game g) {

    }

    // TODO:
    public static void searchExits(Game g) {
        Printer.printMessage("Exits visible in this room : ");
        Map<String,Exit> exits = g.getPlayerActualRoom().getExits(g.playerLampIsOn());
        for (Map.Entry<String, Exit> exit : exits.entrySet()) {
            Printer.printMessage(exit.getKey());
        }
    }

    

}