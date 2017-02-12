import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class HeavyWarShipTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {
                        4,
                        4,
                        3
                },
                {
                        10.0012,
                        10,
                        4
                },
                {
                        100.123,
                        100.125,
                        90
                },
        });
    }

    private double expectedVolume;
    private double expectedMass;
    private int expectedMaxWeapons;

    public HeavyWarShipTest(double volume, double mass, int maxWeapons){
        this.expectedVolume = volume;
        this.expectedMass = mass;
        this.expectedMaxWeapons = maxWeapons;
    }

    @Test
    public void test_heavy_war_ship_ship_constructor() {
        HeavyWarShip heavyWarShip = new HeavyWarShip(this.expectedVolume, this.expectedMass,
                this.expectedMaxWeapons);

        assertEquals(this.expectedVolume, heavyWarShip.getVolume(), 0.001);
        assertEquals(this.expectedMass, heavyWarShip.getMass(), 0.001);
        assertEquals(this.expectedMaxWeapons, heavyWarShip.getMaxWeapons());
    }

    @Test
    public void test_can_equip_any_weapons() {
        Phaser p = new Phaser(1,1);
        Blaster b = new Blaster(1,1, 56);

        HeavyWarShip heavyWarShip = new HeavyWarShip(this.expectedVolume, this.expectedMass,
                this.expectedMaxWeapons);

        heavyWarShip.equip(p);
        assertTrue(heavyWarShip.getEquipments().contains(p));

        heavyWarShip.equip(b);
        assertTrue(heavyWarShip.getEquipments().contains(b));
    }
}
