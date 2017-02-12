public class HybridShip extends TransportShip implements WeaponEquipper {

    private static int nbInstances = 0;
    private int maxWeapons;

    public HybridShip(double volume, double mass, double volumeCapacity, double weightCapacity, int maxWeapons) {
        super(volume, mass, volumeCapacity, weightCapacity);
        this.maxWeapons = maxWeapons;
        this.name = "MR-" + ++HybridShip.nbInstances;
    }

    public int getMaxWeapons() {
        return this.maxWeapons;
    }

    public void equip(Weapon weapon) {
        WeaponEquipper.super.equip(weapon);
        weapon.setLocation(this);
    }

    public void unequip(Weapon weapon) {
        WeaponEquipper.super.unequip(weapon);
        weapon.setLocation(null);
    }
}
