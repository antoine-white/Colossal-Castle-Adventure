package game;

import java.util.*;
import items.*;
import place.Room;
import exit.*;
import player.Player;
import storage.*;

public class Game {

	private boolean isGameOver;
	private final Player PLAYER;
	private final List<Room> ROOMS;
	private Room playerActualRoom;
	private Scanner scanner;
	/*public static void main(String[] args) {
		Game g = new Game();
		g.runGame();
	}*/

	public Game() {
		this.ROOMS = CastleGenerator.generateCastle();
		this.PLAYER = new Player(new Lamp(),new Bag());
		this.isGameOver = false;	
		this.scanner = new Scanner(System.in);
	}

	public Game(String path) {
		this.ROOMS = CastleGenerator.generateCastle(path);
		this.PLAYER = new Player(new Lamp(),new Bag());
		this.isGameOver = false;
		this.scanner = new Scanner(System.in);
	}

	public void quitGame(){
		this.isGameOver = true;
	}

	public void runGame() {
		do {
			//TODO : asked to type a command
			Interpreter.interpreter(this,this.scanner.nextLine());
			this.testGameOver();
		} while (!this.isGameOver);
	}

	public void testGameOver(){
		if ( ! this.isGameOver) {
			this.isGameOver = this.PLAYER.getHp() < 0;//TODO : test if the player has the tresor
		}
	}

	public void newRoomEntered(Room newRoom){
		this.playerActualRoom = newRoom;
	}

	/*private boolean assertArg(Command c,int nbArg){
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
					if (args.size() == 1) {
						this.look(args.get(0));
					} else {
						this.look();
					}					
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
	}*/

	public boolean playerLampIsOn(){
		return this.PLAYER.getLampIsOn();
	}

	public Room getPlayerActualRoom(){
		return this.playerActualRoom;
	}
}
