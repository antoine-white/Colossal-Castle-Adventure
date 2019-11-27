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
		switch (str) {
			case :
		
			default:
				break;
		}
		return GO;
	}

	public static boolean hasCorrectParameters(Command c, int nbParam){
		// TODO - implement it
		throw new UnsupportedOperationException();
	}

	public static String getHelp(){
		// TODO - implement it
		throw new UnsupportedOperationException();
	}
	//TODO:
	public static void interpret(Game g,String string){
		
	}

	public static void go(Game g, String placeStr){
		List<Exit> exits = g.getPlayerActualRoom().getEXITS();
		Exit[] es = stream.collect(exits.stream().filter((e)->{return Objects.equals(e.getNextPlace(g.getPlayerActualRoom(),true).getName(),placeStr);}).toArray());
		if (es.length == 0) {
			// TODO: error message
		} else {
			Room newRoom = es[0].getNextPlace(g.getPlayerActualRoom(), true);
			if (newRoom == null) {
				//TODO : error message about key and all that stuff
			} else {
				g.newRoomEntered(newRoom);
			}
		}
	}

	public static void look(Game g){
		//TODO : print it
		g.getPlayerActualRoom().readDescription();
	}

	//TODO: 
	public static void look(Game g, String itemStorageStr){
		List<Storage> storages = g.getPlayerActualRoom().getStorages();
	}

	//TODO: 
	public static void take(Game g, String itemStr){
		
	}

	//TODO: 
	public static void use(Game g, List<String> args){
		
	}

	//TODO: 
	public static void search(Game g){
		
	}

	//TODO: 
	public static void searchExits(Game g){
		
	}

}