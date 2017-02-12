
public class LightWeightWarShip extends WarShip {

    public LightWeightWarShip(double volume, double mass, int maxWeapons){
        super(volume, mass, maxWeapons);
    }

    public void load(Equipment equipment) {
        if ( !(equipment instanceof Phaser) ){
            throw new IllegalArgumentException("Only Phaser objects can be loaded by a LightWeightWarShip");
        }

        super.load(equipment);
    }
}
