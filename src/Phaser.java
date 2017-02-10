
public class Phaser extends Weapon {
<<<<<<< HEAD
	private static int nbInstances = 0;

	public Phaser(double volume, double mass) {
		super(volume, mass);
		this.name = "P-" + ++Phaser.nbInstances;
=======
	public static int instanceNbr=0;
	public Phaser(double mass, double volume)
	{
		super(mass, volume);
		this.name="Phaser" + ++instanceNbr;
>>>>>>> eef0c545085b0f489848dfa0a0b0372bb98bc172
	}
}
