package game;

import java.util.*;
import items.*;
import player.Player;
import storage.Bag;

public class Game {

	private boolean isGameOver;
	private final Player PLAYER;
	private final List<Room> ROOMS;
	private Room playerActualRoom;

	public Game() {
		this.ROOMS = CastleGenerator();
		this.PLAYER = new Player(new Lamp(),new Bag());
		this.isGameOver = false;
	}

	public Game(String path) {
		this.ROOMS = CastleGenerator(path);
		this.PLAYER = new Player(new Lamp(),new Bag());
		this.isGameOver = false;
	}
	
	private void quitGame(){
		this.isGameOver = true;
	}

	private void runGame() {
		// TODO - implement Game.runGame
		throw new UnsupportedOperationException();
	}

	private boolean assertArg(Command c,int nbArg){
		if(Command.hasCorrectParameters(c, nbArg)){
			return true;
		} else {
			// TODO : make error message
			return false;
		}
	}

	public void actions(Command command,int nbArg,List<String> args){
		switch (command) {
			case GO:
				if (assertArg(command, nbArg)){
					this.go(args.get(0));
				}
				break;
			case LOOK:
				if (assertArg(command, nbArg)){
					this.look(args.get(0));
				}
				break;
			case TAKE:
				if (assertArg(command, nbArg)){
					this.take(args.get(0));
				}
				break;
			case QUIT:
				this.quitGame();
				break;
			case USE:
				if (assertArg(command, nbArg)){
					this.use(args);
				}
				break;
			case SEARCH:
				if (assertArg(command, nbArg)){
					this.search();
				}
				break;
			case SEARCH_EXITS:
				if (assertArg(command, nbArg)){
					this.searchExits();
				}
				break;
			case HELP:
				// TODO : print help
				Command.getHelp();
				break;
			default:
				// TODO : error message
				break;
		}
	}

	private void go(String placeStr){

	}

	private void look(String itemStr){

	}

	private void take(String itemStr){
		
	}

	private void use(List<String> args){
		
	}

	private void search(){
		
	}

	private void searchExits(){
		
	}
}
