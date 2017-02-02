import java.util.ArrayList;

public class WarShip extends Ship implements War{
	private int maxWeapons;
	private ArrayList<Weapon> weapons;
	
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
