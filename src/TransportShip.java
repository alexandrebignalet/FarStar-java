public class TransportShip extends Ship implements EquipmentTransporter {
	private static int nbInstances = 0;

	protected double weightCapacity;
	protected double volumeCapacity;
	protected double volumeCapacityRemaining;
	protected double weightCapacityRemaining;

	public TransportShip(double volume, double mass, double volumeCapacity, double weightCapacity){

		super(volume, mass);

		if (volume <= volumeCapacity) {
			throw new IllegalArgumentException("volumetric capacity must be greater than volume");
		}

		this.volumeCapacity = volumeCapacity;
		this.weightCapacity = weightCapacity;

		this.volumeCapacityRemaining = volumeCapacity;
		this.weightCapacityRemaining = weightCapacity;

		this.name ="VT-" + ++TransportShip.nbInstances;
	}

	public void load(Equipment equipment) {
		super.load(equipment);
		EquipmentTransporter.super.load(equipment);
		equipment.setLocation(this);
		this.volumeCapacityRemaining -= equipment.getVolume();
		this.weightCapacityRemaining -= equipment.getMass();
	}

	public void unload(Equipment equipment) {

		super.unload(equipment);
		equipment.setLocation(null);
		this.volumeCapacityRemaining += equipment.getVolume();
		this.weightCapacityRemaining += equipment.getMass();
	}


	public double getWeightCapacity() {
		return weightCapacity;
	}

	public double getVolumeCapacity() {
		return volumeCapacity;
	}

	public double getVolumeCapacityRemaining() {
		return this.volumeCapacityRemaining;
	}

	public double getWeightCapacityRemaining() {
		return this.weightCapacityRemaining;
	}
}
