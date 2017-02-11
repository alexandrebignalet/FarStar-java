
public class Hybrid extends TransportShip {

	private static int nbInstances = 0;
//	private int maxWeapons;

	
	public Hybrid(double volume, double mass, double massCapacity, double volumetricCapacity, int maxWeapons) {
		super(volume, mass, massCapacity, volumetricCapacity);

//		this.maxWeapons = maxWeapons;
		this.name= "Hybrid Ship"+ ++Hybrid.nbInstances;
	}

	void equip(Weapon weapon) {

	}
	public void unequip(Equipment equipment){

	}
}
