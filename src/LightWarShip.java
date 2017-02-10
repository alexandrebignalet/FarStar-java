
public class LightWarShip extends WarShip {
    private static int instanceNbr = 0;

    public LightWarShip(double volume, double mass, int maxWeapons){
        super(volume, mass, maxWeapons);
        this.name = "Light WarShip" + ++LightWarShip.instanceNbr;
    }
    void setShipment(Weapon weapon) {
        if (weapon instanceof Blaster ){
            throw new IllegalArgumentException("Cannot equip a Blaster on a light warship");
        }

        if (this.shipment.size()<this.maxWeapons && !weapon.getIs_equiped())
        {
            weapon.setIs_equiped(true);
            this.shipment.add(weapon);
            weapon.setLocation(this);
        }
    }
}
