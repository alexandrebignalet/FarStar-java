public class WarShip extends Ship {
	private int maxNbWeapons;

	WarShip(double volume, double mass, int maxNbWeapon) {
		super(volume, mass);
		this.maxNbWeapons = maxNbWeapon;
	}

	int getMaxNbWeapons() {
		return maxNbWeapons;
	}

	void setMaxWeapons(int maxWeapons) {
		this.maxNbWeapons = maxWeapons;
	}


}
