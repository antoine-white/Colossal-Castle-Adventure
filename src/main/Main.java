package main;

import game.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome in our game Collosal Castle Adventure.\nUse HELP command to get all available command\n" +
                           "You are an explorer in a massive haunted castle looking for a treasure...\n");
        Game g = new Game();
        g.runGame();        
    }
}
