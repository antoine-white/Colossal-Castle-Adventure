package items;

public class Axe extends Weapon {

  private static final int DEFAULT_DAMAGE = 20;

  /**
   * 
   * @param damage
   * @param VOLUME
   * @param name
   * @param description
   */
  public Axe(int damage, int VOLUME, String name, String description) {
    super(damage, VOLUME, name, description);
  }

  /**
   * 
   * @param VOLUME
   * @param name
   * @param description
   */
  public Axe(int VOLUME, String name, String description) {
    this(Axe.DEFAULT_DAMAGE, VOLUME, name, description);
  }

}