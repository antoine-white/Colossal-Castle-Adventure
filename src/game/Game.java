package game;

import java.util.*;

import items.*;
import place.Place;
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
	 * put isGameOver to true and stoped the game
	 */
	public void quitGame() {
		this.isGameOver = true;
	}

	/**
	 * the method where all the game takes place
	 */
	public void runGame() {
		do {
			Printer.printMessage("Enter next command : ");
			Interpreter.interpreter(this, this.scanner.nextLine());
			this.testGameOver();
		} while (!this.isGameOver);
	}

	/**
	 * change isGameOver if the player is dead (he has 0 hp or less)
	 */
	public void testGameOver() {
		if (!this.isGameOver) {
			if (this.PLAYER.getHp() <= 0){
				this.isGameOver = true;
				Printer.printMessage("You are dead 😭😭");
			} else if(this.PLAYER.hasTresor()){
				this.isGameOver = true;
				Printer.printMessage("You have won🎉🎉🏆🏆. You found the tresor");
			}
		}
	}

	/**
	 * replace playerActualRoom by newRoom and lauch a combat with
	 * the ennemy of the newRoom if there is one
	 * @param place the new room the player has entered
	 */
	public void newRoomEntered(Place place) {
		this.playerActualRoom = ((Room)place);
		Ennemy ennemy = this.playerActualRoom.getEnnemy();
		if (ennemy != null && ennemy.attacked(0) > 0) {
			this.handleCombat(this.playerActualRoom.getEnnemy());
		}
	}

	/**
	 * 
	 * @param e the ennemy the player is fighting against
	 */
	private void handleCombat(Ennemy e) {
		Printer.printMessage("⚔ You encontered an ennemy " + e.toString() + " ⚔");
		do {
			this.PLAYER.attacked(e.attack());
			Printer.printMessage("The ennemy attacked you and dealt " + e.attack() + " damage you have " + 
				(this.PLAYER.getHp() > 0 ? this.PLAYER.getHp() : 0 ) +"hp remaininig");
			if (this.PLAYER.getHp() > 0){
				Printer.printMessage("you attack the ennemy and dealt " + this.PLAYER.attack() + " damage");
				e.attacked(this.PLAYER.attack());
			}
		} while (e.attacked(0) > 0 && this.PLAYER.getHp() > 0);
		if (this.PLAYER.getHp() > 0){
			Printer.printMessage("You have slayed the ennemy 💪");
		}
	}

	public boolean playerLampIsOn() {
		return this.PLAYER.getLampIsOn();
	}

	public int getPlayerHp(){
		return this.PLAYER.getHp();
	}

	public void addItemToBag(TakeableItem takeableItem){
		this.PLAYER.getBAG().addItem(takeableItem);
	}

	public Collection<TakeableItem> getBagItems(){
		return this.PLAYER.getBAG().getItems();
	}

	public Room getPlayerActualRoom() {
		return this.playerActualRoom;
	}

	public Weapon getPlayerWeapon(){
		return this.PLAYER.getWeapon();
	}

	public void removeItemBag(TakeableItem tItem){
		this.PLAYER.getBAG().removeItem(tItem);
	}

	public boolean useItemOnPlayer(TakeableItem tItem){
		return tItem.use(this.PLAYER);
	}

	/**
	 * put the lamp of the player on if it's off
	 * and vice versa
	 */
	public void changeLampStatus(){
		this.PLAYER.changeLampStatus();
	}
}
