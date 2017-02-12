
public abstract class Equipment {
	
	private double mass;
	private double volume;
	private Ship location;
	private String name;


	Equipment(double volume, double mass) {
		this.volume = volume;
		this.mass = mass;
		this.location = null;
		this.name = null;
	}

	String getName() {
		return this.name;
	}

	void setName(String name) {
		this.name = name;
	}

	double getMass() {
		return this.mass;
	}

	double getVolume() {
		return this.volume;
	}

	Ship getLocation() {
		return this.location;
	}

	void setLocation(Ship location) {
		this.location = location;
	}

}
