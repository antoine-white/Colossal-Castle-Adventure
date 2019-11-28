package game;

import java.util.Arrays;

public class Interpreter {

	public static void interpreter(Game g, String str) {
		String[] words = str.split(" ");
		Command c = Command.strToCmd(words[0]);
		if (c == null) {
			Printer.printError("cannot find command " + words[0]);
		} else {
			if (Command.hasCorrectParameters(c, words.length - 1)) {
				Command.runCommand(g, c, Arrays.copyOfRange(words, 1, words.length));
			} else {
				Printer.printError("incorrect number of parameters for command " + words[0]);
			}
		}
	}

}