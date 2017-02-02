
public class Blaster extends Weapon{
	private double gazLevel;
	
	public Blaster(double mass, double volume)
	{
		this.setMass(mass);
		this.setVolume(volume);
		
	}
	void reload(){
		setGazLevel(100);
	}
	
	double getGazLevel() {
		return gazLevel;
	}

	void setGazLevel(double gazLevel) {
		this.gazLevel = gazLevel;
	}
	
}
