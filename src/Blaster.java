public class Blaster extends Weapon{

	private final int MAX_GAZ_LEVEL_PERCENT = 100;

	private static int nbInstances = 0;
	private double gazLevel;
	
	public Blaster(double volume, double mass, double gazLevel) throws IllegalArgumentException {
		super(volume, mass);

		if ( gazLevel > MAX_GAZ_LEVEL_PERCENT || gazLevel < 0 ) {
			throw new IllegalArgumentException("Gaz level must be set in percent.");
		}
		this.name = "B-" + ++Blaster.nbInstances;
		this.gazLevel = gazLevel;
	}
	void recharge(){
		this.gazLevel = MAX_GAZ_LEVEL_PERCENT;
	}
	
	double getGazLevel() {
		return gazLevel;
	}
}
