
public class Blaster extends Weapon{
	private static int nbInstances = 0;
	private double gazLevel;
	
	public Blaster(double volume, double mass, double gazLevel) throws IllegalArgumentException {
		super(volume, mass);

		if ( gazLevel > 100 || gazLevel < 0 ) {
			throw new IllegalArgumentException("Gaz level must be set in percent.");
		}
		this.name = "B-" + ++Blaster.nbInstances;
		this.gazLevel = gazLevel;
	}
	void recharge(){
		this.gazLevel = 100;
	}
	
	double getGazLevel() {
		return gazLevel;
	}
}
