public interface EquipmentTransporter extends Transporter {

    double getVolumeCapacity();

    double getWeightCapacity();

    double getVolumeCapacityRemaining();

    double getWeightCapacityRemaining();

    default void load(Equipment equipment) {
        Transporter.super.load(equipment);

        if (this.getVolumeCapacityRemaining() < equipment.getVolume() )
        {
            throw new IllegalArgumentException("Cannot be added to the shipment, not enought volume capacity remaining");
        }
        if (this.getWeightCapacityRemaining() < equipment.getMass() )
        {
            throw new IllegalArgumentException("Cannot be added to the shipment, not enought mass capacity remaining");
        }

        this.getEquipments().add(equipment);
    }

    default void unload(Equipment equipment) {
        Transporter.super.unload(equipment);
    }
}
