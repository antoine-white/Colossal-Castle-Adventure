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
	private Room playerActualRoom;
	private Scanner scanner;
	/*public static void main(String[] args) {
		Game g = new Game();
		g.runGame();
	}*/

	public Game() {
		this.playerActualRoom = CastleGenerator.generateCastle();
		this.PLAYER = new Player(new Lamp(),new Bag());
		this.isGameOver = false;	
		this.scanner = new Scanner(System.in);
	}

	public Game(String path) {
		this.playerActualRoom = CastleGenerator.generateCastle(path);
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

	public boolean playerLampIsOn(){
		return this.PLAYER.getLampIsOn();
	}

	public Room getPlayerActualRoom(){
		return this.playerActualRoom;
	}
}
