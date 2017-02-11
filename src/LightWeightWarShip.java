
public class LightWeightWarShip extends WarShip {
    private static int instanceNbr = 0;

    public LightWeightWarShip(double volume, double mass, int maxWeapons){
        super(volume, mass, maxWeapons);
        this.name = "Light WarShip" + ++LightWeightWarShip.instanceNbr;
    }

    public void equip(Weapon weapon) {
        if ( !(weapon instanceof Phaser) ){
            throw new IllegalArgumentException("Only Phaser objects can be loaded by a LightWeightWarShip");
        }

        super.equip(weapon);
    }
}
