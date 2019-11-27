package game;

public class Interpreter {

	public static void interpreter(Game g, String str) {
		String[] words = str.split(" ");
		Command c = Command.strToCmd(words[0]);
		if (c == null) {
			// TODO : error message
		} else {
			if (Command.hasCorrectParameters(c, words.length - 1)) {
				Command.runCommand(g, c, Arrays.copyOfRange(words, 1, words.length));
			} else {
				// TODO : error message
			}
		}
	}

}