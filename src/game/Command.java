package game;

import java.util.*;

import exit.*;
import interfaces.CanTakeItem;
import interfaces.Lockable;
import items.*;
import storage.*;
import place.*;

public enum Command {
    GO("help go : You have to write go + the name of the room you want to go. Exemple -> go ballroom", "GO", 1, 1, (g, args) -> Command.go(g, args[0])),
    HELP("help help", "HELP", 0, 0, (g, args) -> Printer.printMessage(Command.getHelp())),
    LOOK("help look : This command shows you all items in the room you are ", "LOOK", 0, 1, (g, args) -> Command.look(g, args)),
    TAKE("help take : You have to write take + the name of the item you want to take.It will put it in your bag. Exemple -> take axe", "TAKE", 1, 1, (g, args) -> Command.take(g, args[0])),
    QUIT("help quit : This command is here to quit the game", "QUIT", 0, 0, (g, args) -> Command.quit(g)),
    USE("help use : This command allows you to use an item in your bag.You have to write use + the name of the item. Exemple -> use axe. You can also use this command to open a locked door or a locked trunk, so you have to write use + name of the item + name of the room of use + name of the item + trunk. Exemple -> use doorkey ballroom, use trunkkey trunk", "USE", 1, 2, (g, args) -> Command.use(g, args)),
    SEARCH("help search : This command shows you all items in the room", "SEARCH", 0, 0, (g, args) -> Command.search(g)),
    SEARCH_EXITS("help search exits : This command shows you all room that you can go next the place you are ", "SEARCH_EXITS", 0, 0, (g, args) -> Command.searchExits(g)),
    INVENTORY("help inventory : This command shows you your hp, the state of your lamp, the weapon equiped, and all the key do you have", "INVENTORY", 0, 0, (g, args) -> Command.printInventory(g)),
    LAMP("help lamp : This command switch on or switch off your lamp. IMPORTANT, if your lamp is on, you can find secret access like secret room.","LAMP",0,0,(g,args) -> g.changeLampStatus());

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
        for (Command c : Command.values()) {
            if (Objects.equals(c.COMMAND_STR, str) || Objects.equals(c.COMMAND_STR.toLowerCase(), str)) {
                tCommand = c;
            }
        }
        return tCommand;
    }

    public static boolean hasCorrectParameters(Command c, int nbParam) {
        return nbParam >= c.MIN_PARAM && nbParam <= c.MAX_PARAM;
    }

    public static String getHelp() {
        String returnString = "";
        for (Command c : Command.values()) {
            returnString += '\n' + c.HELP_STR;
        }
        return returnString;
    }

    public static void runCommand(Game g, Command c, String[] args) {
        c.function.runCommand(g, args);
    }

    public static void go(Game g, String placeStr) {
        Map<String, Exit> exits = g.getPlayerActualRoom().getExits(g.playerLampIsOn());
        for (Map.Entry<String, Exit> exit : exits.entrySet()) {
            if (Objects.equals(exit.getKey(), placeStr)) {
                try {
                    if (((Lockable) exit.getValue()).getIsLocked()) {
                        Printer.printMessage("This room is Locked");
                        return;
                    } else {
                        g.newRoomEntered(exit.getValue().getNextPlace(((Room) g.getPlayerActualRoom())));
                    }
                } catch (Exception e) {
                    g.newRoomEntered(exit.getValue().getNextPlace(((Room) g.getPlayerActualRoom())));
                }
                return;
            }
        }
        Printer.printError("Could not find a exit to a place named " + placeStr + " in this room");
    }

    public static void look(Game g, String[] itemStr) {
        if (itemStr.length == 0) {
            Printer.printMessage(g.getPlayerActualRoom().readDescription() + " at the "+ g.getPlayerActualRoom().getLevel() + " floor");
        } else {
            boolean foundItem = false;
            Storage tmp = g.getPlayerActualRoom().getStorage();
            if (tmp != null) {
                for (TakeableItem item : tmp.getItems()) {
                    if (Objects.equals(itemStr[0], item.getNAME())) {
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

    public static void quit(Game g) {
        g.quitGame();
    }

    public static void take(Game g, String itemStr) {
        Storage tmp = g.getPlayerActualRoom().getStorage();
        if (tmp != null) {
            try {
                if (((Lockable) tmp).getIsLocked()) {
                    Printer.printMessage("The Trunk is locked you cannot pick item");
                    return;
                }
            } catch (Exception e) {
            }
            Printer.printMessage("Items in this room : ");
            for (TakeableItem item : tmp.getItems()) {
                if (Objects.equals(item.getNAME(), itemStr)) {
                    g.addItemToBag(item);
                    Printer.printMessage("the item has been added to your bag");
                }
            }
        } else {
            Printer.printMessage("Any Item in this room");
        }

    }

    public static void use(Game g, String[] args) {
        Collection<TakeableItem> tItems = g.getBagItems();
        TakeableItem selectedItem = null;
        for (TakeableItem takeableItem : tItems) {
            if (Objects.deepEquals(args[0], takeableItem.getNAME())) {
                selectedItem = (TakeableItem) takeableItem;
            }
        }
        if (selectedItem != null) {
            // it's on the player
            if (args.length == 1) {
                g.useItemOnPlayer(selectedItem);
                g.removeItemBag(selectedItem);
            } else {
                if (args[1].contains("trunk")){
                    try {
                        selectedItem.use(((CanTakeItem)g.getPlayerActualRoom().getStorage()));
                    } catch (Exception e) {
                        Printer.printError("Can not use item on the storage");
                    }                    
                } else{
                    Map<String, Exit> exits = g.getPlayerActualRoom().getExits(g.playerLampIsOn());
                    for (Map.Entry<String, Exit> exit : exits.entrySet()) {
                        if (exit.getKey().contains(args[1])) {
                            try {
                                selectedItem.use((CanTakeItem)exit.getValue());
                            } catch (Exception e) {
                                Printer.printError("Can not use item on this exit");
                            }
                            return;
                        }
                    }
                    Printer.printMessage("can not find something to use this item on that is called " + args[1]);
                }
                g.removeItemBag(selectedItem);
            }
        } else {
            Printer.printMessage("Can not found this item in your bag");
        }

    }

    public static void search(Game g) {
        Storage tmp = g.getPlayerActualRoom().getStorage();
        if (tmp != null) {
            try {
                if (((Lockable) tmp).getIsLocked()) {
                    Printer.printMessage("The Trunk is locked");
                    return;
                }
            } catch (Exception e) {
            }
            Printer.printMessage("Items in this room : ");
            for (TakeableItem item : tmp.getItems()) {
                Printer.printMessage("name = " + item.getNAME());
            }
        } else {
            Printer.printMessage("Any Item in this room");
        }
    }

    public static void searchExits(Game g) {
        Printer.printMessage("Exits visible in this room : ");
        Map<String, Exit> exits = g.getPlayerActualRoom().getExits(g.playerLampIsOn());
        for (Map.Entry<String, Exit> exit : exits.entrySet()) {
            Printer.printMessage(exit.getKey());
        }
    }

    public static void printInventory(Game g) {
        Printer.printMessage("You have " + g.getPlayerHp() + "hp.");
        Weapon weapon = g.getPlayerWeapon();
        if (weapon != null) {
            Printer.printMessage("weapon : " + weapon.getNAME() + "; damage = " + weapon.attack());
        }        
        Printer.printMessage("Your lamp is " + (g.playerLampIsOn() ? "on" : "off"));
        Collection<TakeableItem> items = g.getBagItems();
        if (items.size() == 0) {
            Printer.printMessage("You have nothing in your bag");
        } else {
            Printer.printMessage("You have those items in your bag : ");
            for (TakeableItem tItem : items) {
                Printer.printMessage("name = " + tItem.getNAME() + " description = " + tItem.readDescription());
            }
        }
    }

}
