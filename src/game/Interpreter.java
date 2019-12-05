package game;

import java.util.Arrays;

public class Interpreter {

	/**
	 * given a string it split it into substrings with space and 
	 * lauch a command with the first substring as the command and 
	 * the other as arguments, if the command exists and the number 
	 * of parameters is correct for this command
	 * @param g
	 * @param str
	 */
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