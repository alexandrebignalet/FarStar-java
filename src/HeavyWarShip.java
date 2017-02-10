
public class HeavyWarShip extends WarShip {
    private static int instanceNbr = 0;

    public HeavyWarShip(double volume, double mass, int maxWeapons){
        super(volume, mass, maxWeapons);
        this.name = "Heavy WarShip" + ++HeavyWarShip.instanceNbr;
    }
}
