<<<<<<< HEAD
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

=======


public class WarShip extends Ship implements War{
	public static int instanceNbr=0;
	protected int maxWeapons;


	public WarShip(double mass, double volume, int maxWeapons){
		super(mass, volume);
		this.maxWeapons = maxWeapons;
		this.name = "Warship" + ++instanceNbr;

	}

	int getMaxWeapons() {
		return maxWeapons;
	}
	void setMaxWeapons(int maxWeapons) {
		this.maxWeapons = maxWeapons;
	}

	void setShipment(Weapon weapon) {
		if (this.shipment.size()<maxWeapons && !weapon.getIs_equiped())
		{
		    weapon.setIs_equiped(true);
		    this.shipment.add(weapon);
		    weapon.setLocation(this);
		}
	}

    protected void unloadShipment(Weapon weapon) {
        this.shipment.remove(weapon);
        weapon.setLocation(null);
        weapon.setIs_equiped(false);
    }
>>>>>>> eef0c545085b0f489848dfa0a0b0372bb98bc172

}
