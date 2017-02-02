import java.util.ArrayList;

public class Hybrid extends TransportShip implements War{
	
	private int maxWeapons;
	private ArrayList<Weapon> weapons;
	
	public Hybrid(double mass, double volume, double massCapacity, double volumetricCapacity, int maxWeapons) {
		super(mass, volume, massCapacity, volumetricCapacity);
		this.setMaxWeapons(maxWeapons);
		
	}
	
	int getMaxWeapons() {
		return maxWeapons;
	}
	void setMaxWeapons(int maxWeapons) {
		this.maxWeapons = maxWeapons;
	}
	ArrayList<Weapon> getWeapons() {
		return weapons;
	}
	void equipWeapon(Weapon weapon) {
		if (this.weapons.size()<2)
		{
		this.weapons.add(weapon);
		}
	}
	void unequipWeapon(Weapon weapon) {
		
		this.weapons.remove(weapon);
	}
}
