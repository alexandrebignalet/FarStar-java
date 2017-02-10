
public class Hybrid extends TransportShip {
	private static int instanceNbr=0;
	private int maxWeapons;

	
	public Hybrid(double volume, double mass, double massCapacity, double volumetricCapacity, int maxWeapons) {
		super(volume, mass, massCapacity, volumetricCapacity);

		this.maxWeapons = maxWeapons;
		this.name= "Hybrid Ship"+ ++Hybrid.instanceNbr;
		this.remainingVolCapacity = volumetricCapacity;
		
	}


	int getMaxWeapons() {
		return maxWeapons;
	}
	void setMaxWeapons(int maxWeapons) {
		this.maxWeapons = maxWeapons;
	}



	void equip(Weapon weapon) {
		int alreadyEquiped=0;
		for (Equipment eq : this.shipment)
		{
			if (eq instanceof Weapon ){
				if(((Weapon)eq).getIs_equiped())
				{
					alreadyEquiped++;
				}
			}
		}
		if (alreadyEquiped<this.maxWeapons && !weapon.getIs_equiped())
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
}
