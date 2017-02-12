public interface WeaponEquipper extends Transporter {

    int getMaxWeapons();

    default void equip(Weapon weapon) {
        Transporter.super.canLoad(weapon);

        if ( this.getEquipments().size() >= this.getMaxWeapons() )  {
            throw new IllegalArgumentException("Max weapon loaded reached on this WarShip object.");
        }

        this.getEquipments().add(weapon);
        weapon.setEquipped(true);
    }

    default void unequip(Weapon weapon) {
        Transporter.super.canUnload(weapon);
        weapon.setEquipped(false);
    }
}
