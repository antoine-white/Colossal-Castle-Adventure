package game;

public enum Command {
    GO("help go"),
    HELP("help help"),
    LOOK("help look"),
    TAKE("help take"),
    QUIT("help quit"),
    USE("help use"),
    SEARCH("help search"),
    SEARCH_EXITS("help search exits");

    private String help;

    public static String toStr(Command c) {
        // TODO - implement Command.toStr
        throw new UnsupportedOperationException();
    }

    public static Command strToCmd(String str) {
        switch (str) {
        case "GO":
            return GO;
        case "HELP":
            return HELP;
        case "LOOK":
            return LOOK;
        case "TAKE":
            return TAKE;
        case "QUIT":
            return QUIT;
        case "USE":
            return USE;
        case "SEARCH":
            return SEARCH;
        case "SEARCH_EXITS":
            return SEARCH_EXITS;
        default:
            return null;
        }
    }

    public static boolean hasCorrectParameters(Command c, int nbParam) {
        switch (c) {
        case GO:
            return nbParam == 1;
        case HELP:
            return nbParam == 0;
        case LOOK:
            return nbParam == 1;
        case TAKE:
            return nbParam == 1;
        case QUIT:
            return nbParam == 0;
        case USE:
            return nbParam >= 1 && nbParam <= 2;
        case SEARCH:
            return nbParam == 0;
        case SEARCH_EXITS:
            return nbParam == 0;
        default:
            return false;
        }
    }

    public static String getHelp() {
        String returnString = "";
        for(Command c: Command.values()){
            returnString += c.help;
        }
        return returnString;
    }

    // TODO:
    public static void runCommand(Game g, Command c, String[] args) {
        switch (c) {
        case GO:
            Command.go(g, args[0]);
            break;
        case HELP:
            // TODO : print it
            Command.getHelp();
            break;
        case LOOK:
            if (args.length == 1) {
                Command.look(g);
            } else {
                Command.look(g, args[0]);
            }
            break;
        case TAKE:
            Command.take(g, args[0]);
            break;
        case QUIT:
            g.quitGame();
            break;
        case USE:
            Command.use(g, Arrays.stream(args).boxed().collect(Collectors.toList()));
            break;
        case SEARCH:
            Command.search(g);
            break;
        case SEARCH_EXITS:
            Command.searchExits(g);
            break;
        default:
        }
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

    public static void look(Game g) {
        // TODO : print it
        g.getPlayerActualRoom().readDescription();
    }

    // TODO:
    public static void look(Game g, String itemStorageStr) {
        List<Storage> storages = g.getPlayerActualRoom().getStorages();
    }

    // TODO:
    public static void take(Game g, String itemStr) {

    }

    // TODO:
    public static void use(Game g, List<String> args) {

    }

    // TODO:
    public static void search(Game g) {

    }

    // TODO:
    public static void searchExits(Game g) {
        g.getPlayerActualRoom().getEXITS(g.playerLampIsOn());
        //TODO print the map
    }

}