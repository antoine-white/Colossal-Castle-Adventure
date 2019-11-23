package player;

public class Player implements ItemReceiver{

	private Weapon activeWeapon;
	private Lamp LAMP;
	private Bag BAG;
	private int hp;
	private static int NO_WEAPON_DAMAGE;

	public int attack() {
		// TODO - implement Player.attack
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param damage
	 */
	public int attacked(int damage) {
		// TODO - implement Player.attacked
		throw new UnsupportedOperationException();
	}

	public int getHp() {
		return this.hp;
	}

	public boolean receiveItem(TakeableItem tItem){

	}
}