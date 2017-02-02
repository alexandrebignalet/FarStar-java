import java.util.ArrayList;

public class TransportShip extends Ship {

	private double massCapacity;
	private double volumetricCapacity;
	private ArrayList<Equipment> equipment;
	
	public TransportShip(double mass, double volume, double massCapacity, double volumetricCapacity){
		this.setMass(mass);
		this.setVolume(volume);
		this.setMassCapacity(massCapacity);
		this.setVolumetricCapacity(volumetricCapacity);
	}
	
	double getMassCapacity() {
		return massCapacity;
	}
	void setMassCapacity(double massCapacity) {
		this.massCapacity = massCapacity;
	}
	double getVolumetricCapacity() {
		return volumetricCapacity;
	}
	void setVolumetricCapacity(double volumetricCapacity) {
		this.volumetricCapacity = volumetricCapacity;
	}
	ArrayList<Equipment> getEquipment() {
		return equipment;
	}
	void load(Equipment equipment) {
		this.equipment.add(equipment);
	}
	
	void unload(Equipment equipment) {
		this.equipment.remove(equipment);
	}
	
}
