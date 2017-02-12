public interface WeaponEquipper extends Transporter {

    int getMaxWeapons();

    default void load(Equipment equipment) {

        Transporter.super.load(equipment);

        if ( !(equipment instanceof Weapon)) {
            throw new IllegalArgumentException("WarShip can only equip Weapon object.");
        }
        if ( this.getEquipments().size() >= this.getMaxWeapons() )  {
            throw new IllegalArgumentException("Max weapon loaded reached on this WarShip object.");
        }

        this.getEquipments().add(equipment);
        ((Weapon)equipment).setEquipped(true);
    }

    default void unload(Equipment equipment) {
        Transporter.super.unload(equipment);
        ((Weapon)equipment).setEquipped(false);
    }
}
