package game;

import java.util.*;
import java.util.stream.Collectors;

import exit.Exit;

public enum Command {
    GO("help go","GO",1,1,(g,args)->Command.go(g,args[0])),
    HELP("help help","HELP",0,0,(g,args)->Printer.printMessage(Command.getHelp())),
    LOOK("help look","LOOK",0,0,(g,args)->Command.look(g,args)),
    TAKE("help take : ","TAKE",1,1,(g,args)->Command.take(g,args[0])),
    QUIT("help quit","QUIT",0,0,(g,args)->Command.quit(g)),
    USE("help use","USE",1,2,(g,args)->Command.quit(g)),
    SEARCH("help search","SEARCH",0,0,(g,args)->Command.search(g)),
    SEARCH_EXITS("help search exits","SEARCH EXITS",0,0,(g,args)->Command.searchExits(g));
    
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
        //TODO : rewrite this whole mess with the new getExits
        /*
        List<Exit> exits = g.getPlayerActualRoom().getEXITS(g.playerLampIsOn());
        Exit[] es = stream.collect(exits.stream().filter((e) -> {
            return Objects.equals(e.getNextPlace(g.getPlayerActualRoom(), true).getName(), placeStr);
        }).toArray());
        if (es.length == 0) {
            // TODO: error message
        } else {
            Room newRoom = es[0].getNextPlace(g.getPlayerActualRoom(), true);
            if (newRoom == null) {
                // TODO : error message about key and all that stuff
            } else {
                g.newRoomEntered(newRoom);
            }
        }*/
    }

    // TODO:
    public static void look(Game g, String[] itemStr) {
        if (itemStr.length == 0){
            Printer.printMessage(g.getPlayerActualRoom().readDescription());
        } else {

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
        for (Map.Entry<String, Exit> entry : exits.entrySet()) {
            Printer.printMessage(entry.getKey());
        }
    }

    

}