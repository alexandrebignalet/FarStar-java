public class WarShip extends Ship implements WeaponEquipper {

	private static int nbInstances = 0;
	protected int maxWeapons;


	public WarShip(double volume, double mass, int maxWeapons){
		super(volume, mass);
		this.maxWeapons = maxWeapons;
		this.name = "Warship" + ++WarShip.nbInstances;
	}

	public int getMaxWeapons() {
		return maxWeapons;
	}

	public void equip(Weapon weapon) {
		WeaponEquipper.super.equip(weapon);
		weapon.setLocation(this);
		weapon.setEquipped(true);
	}

	public void unequip(Weapon weapon) {
		WeaponEquipper.super.unequip(weapon);
		weapon.setLocation(null);
		weapon.setEquipped(false);
	}
}
