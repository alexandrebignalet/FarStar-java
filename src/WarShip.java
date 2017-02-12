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

	public void load(Equipment equipment) {
		WeaponEquipper.super.load(equipment);

		equipment.setLocation(this);
	}

	public void unload(Equipment equipment) {
		WeaponEquipper.super.unload(equipment);
		equipment.setLocation(null);
	}
}
