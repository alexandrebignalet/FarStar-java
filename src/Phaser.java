
public class Phaser extends Weapon {
	private static int nbInstances = 0;

	public Phaser(double volume, double mass) {
		super(volume, mass);
		this.setName("P-" + ++Phaser.nbInstances);
	}
}
