package game;

import java.util.*;

import items.*;
import place.Room;
import interactions.Ennemy;
import player.Player;
import storage.*;

public class Game {

	private boolean isGameOver;
	private final Player PLAYER;
	private Room playerActualRoom;
	private Scanner scanner;

	/**
	 * create a new Game with a the default castle see CastleGenerator.generateCastle()
	 */
	public Game() {
		this.playerActualRoom = CastleGenerator.generateCastle();
		this.PLAYER = new Player(new Lamp(), new Bag());
		this.isGameOver = false;
		this.scanner = new Scanner(System.in);
	}

	/**
	 * 
	 * @param path the path of the file the castle is loaded from
	 */
	public Game(String path) {
		this.playerActualRoom = CastleGenerator.generateCastle(path);
		this.PLAYER = new Player(new Lamp(), new Bag());
		this.isGameOver = false;
		this.scanner = new Scanner(System.in);
	}

	/**
	 * put isGameOver to true and stoped the game
	 */
	public void quitGame() {
		this.isGameOver = true;
	}

	/**
	 * the method where all the game takes place
	 */
	public void runGame() {
		//TEMP: System.out.println("hello there");
		do {
			Interpreter.interpreter(this, this.scanner.nextLine());
			this.testGameOver();
		} while (!this.isGameOver);
	}

	/**
	 * change isGameOver if the player is dead (he has 0 hp or less)
	 */
	public void testGameOver() {
		if (!this.isGameOver) {
			this.isGameOver = this.PLAYER.getHp() < 0;// TODO : test if the player has the tresor
		}
	}

	/**
	 * replace playerActualRoom by newRoom and lauch a combat with
	 * the ennemy of the newRoom if there is one
	 * @param newRoom the new room the player has entered
	 */
	public void newRoomEntered(Room newRoom) {
		this.playerActualRoom = newRoom;
		if (this.playerActualRoom.getEnnemy() != null) {
			this.handleCombat(this.playerActualRoom.getEnnemy());
		}
	}

	/**
	 * 
	 * @param e the ennemy the player is fighting against
	 */
	private void handleCombat(Ennemy e) {
		Printer.printMessage("⚔ You encontered an ennnemy " + e.toString() + "⚔");
		//TODO do ennemy toString
		do {
			this.PLAYER.attacked(e.attack());
			Printer.printMessage("The ennemy attacked you and dealt" + e.attack() + "damage you have " + this.PLAYER.getHp() +"hp remaininig");
			if (this.PLAYER.getHp() > 0){
				Printer.printMessage("you attack the ennemy and dealt" + this.PLAYER.attack() + "damage");
				e.attacked(this.PLAYER.attack());
			}
		} while (e.attacked(0) > 0 || this.PLAYER.getHp() > 0);
		if (this.PLAYER.getHp() < 0){
			Printer.printMessage("You have slayed the ennemy 💪");
		}
	}

	public boolean playerLampIsOn() {
		return this.PLAYER.getLampIsOn();
	}

	public Room getPlayerActualRoom() {
		return this.playerActualRoom;
	}
}
