package game;

/**
 * Printer
 * this class does all the System.out.println of the game
 */
public class Printer {

    private static final String BACKGROUND_COLOR = "\033[30m";//Black (background)
    private static final String RESET = "\u001B[0m";//reset color
    private static final String MESSAGE_COLOR = "\u001B[37m"; //white
    private static final String ERROR_COLOR = "\u001B[31m"; //red

    /**
     * initialize the background
     * warning it does work on all terminal 
     */
    public static void initBackground(){
        System.out.print(Printer.BACKGROUND_COLOR);
    }

    /**
     * print the message with for background color Printer.BACKGROUND_COLOR
     * and Printer.MESSAGE_COLOR for the foreground color
     * @param msg the message to print 
     */
    public static void printMessage(String msg){
        Printer.initBackground();
        System.out.println(Printer.MESSAGE_COLOR + msg + Printer.RESET);
    }

    /**
     * print the error message with for background color Printer.BACKGROUND_COLOR
     * and Printer.ERROR_COLOR for the foreground color and the line starts with a 🛑
     * @param msg the message to print 
     */
    public static void printError(String msg){
        Printer.initBackground();
        System.out.println("🛑 " + Printer.ERROR_COLOR + msg + Printer.RESET);
    }
}