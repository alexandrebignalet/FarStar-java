import java.util.ArrayList;

public class TransportShip extends Ship {
	private static int instanceNbr=0;

	private double massCapacity;
	private double volumetricCapacity;
	protected double remainingVolCapacity;
	
	public TransportShip(double volume, double mass, double volumetricCapacity, double massCapacity){

		super(volume, mass);

		if (volume < volumetricCapacity) {
			throw new IllegalArgumentException("volumetric capacity must be greater than volume");
		}

		this.volumetricCapacity = volumetricCapacity;
		this.massCapacity = massCapacity;

		this.volumetricCapacity = volumetricCapacity;
		this.remainingVolCapacity = volumetricCapacity;

		this.name ="TransportShip" + ++TransportShip.instanceNbr;
	}

	public void setShipment(Equipment equipment){
		if (equipment.getLocation() != null)
		{
			throw new IllegalArgumentException("Location isn t null for this equipment");
		}
		if (this.remainingVolCapacity - equipment.getVolume() < 0 )
		{
			throw new IllegalArgumentException("Cannot be added to the shipment, not enought volume capacity remaining");
		}
		if (this.getMass() - equipment.getMass() < 0 )
		{
			throw new IllegalArgumentException("Cannot be added to the shipment, not enought mass capacity remaining");
		}
		this.remainingVolCapacity -=equipment.getVolume();
		this.shipment.add(equipment);
		equipment.setLocation(this);
	}
	public void unloadShipment(Equipment equipment){
		this.remainingVolCapacity += equipment.getVolume();
		this.shipment.remove(equipment);
		equipment.setLocation(null);
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
		return shipment;
	}

	void load(Equipment equipment) {
		if ( getMass() + equipment.getMass() < this.massCapacity )
        {
	    	this.shipment.add(equipment);
        }

	}

	


	
}
