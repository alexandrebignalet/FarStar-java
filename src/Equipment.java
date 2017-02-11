
public abstract class Equipment {
	
	protected double mass;
	protected double volume;
	protected Ship location;
	protected String name;

	Equipment(double volume, double mass) {
		this.volume = volume;
		this.mass = mass;
		this.location = null;
		this.name = null;
	}

	String getName() {
		return name;
	}

	double getMass() {
		return mass;
	}

	double getVolume() {
		return volume;
	}

	Equipment getLocation() {
		return location;
	}

	void setLocation(Ship location) {
		this.location = location;
	}

}
