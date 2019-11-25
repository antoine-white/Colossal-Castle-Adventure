package game;

public enum Command {
	GO,
	HELP,
	LOOK,
	TAKE,
	QUIT,
	USE,
	SEARCH,
	SEARCH_EXITS;

	public static String toStr(Command c) {
		// TODO - implement Command.toStr
		throw new UnsupportedOperationException();
	}

	public static Command strToCmd(String str) {
		// TODO - implement Command.toStr
		throw new UnsupportedOperationException();
	}

	public static boolean hasCorrectParameters(Command c, int nbParam){
		// TODO - implement it
		throw new UnsupportedOperationException();
	}

	public static String getHelp(){
		// TODO - implement it
		throw new UnsupportedOperationException();
	}

}