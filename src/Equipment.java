
public class Equipment {
	
	private String name;
	private double mass;
	private double volume;
	private Equipment location;
	
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	double getMass() {
		return mass;
	}
	void setMass(double mass) {
		this.mass = mass;
	}
	double getVolume() {
		return volume;
	}
	void setVolume(double volume) {
		this.volume = volume;
	}
	Equipment getLocation() {
		return location;
	}
	void setLocation(Ship location) {
		this.location = location;
	}

}
