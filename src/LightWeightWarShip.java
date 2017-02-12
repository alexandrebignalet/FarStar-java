
public class LightWeightWarShip extends WarShip {
    private static int instanceNbr = 0;

    public LightWeightWarShip(double volume, double mass, int maxWeapons){
        super(volume, mass, maxWeapons);
        this.name = "Light WarShip" + ++LightWeightWarShip.instanceNbr;
    }

    public void load(Equipment equipment) {
        if ( !(equipment instanceof Phaser) ){
            throw new IllegalArgumentException("Only Phaser objects can be loaded by a LightWeightWarShip");
        }

        super.load(equipment);
    }
}
