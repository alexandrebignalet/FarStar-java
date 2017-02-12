import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class LightWeightWarShipTest {

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

    public LightWeightWarShipTest(double volume, double mass, int maxWeapons){
        this.expectedVolume = volume;
        this.expectedMass = mass;
        this.expectedMaxWeapons = maxWeapons;
    }

    @Test
    public void test_light_weight_war_ship_ship_constructor() {
        LightWeightWarShip lightWeightWarShip = new LightWeightWarShip(this.expectedVolume, this.expectedMass,
                this.expectedMaxWeapons);

        assertEquals(this.expectedVolume, lightWeightWarShip.getVolume(), 0.001);
        assertEquals(this.expectedMass, lightWeightWarShip.getMass(), 0.001);
        assertEquals(this.expectedMaxWeapons, lightWeightWarShip.getMaxWeapons());
    }

    @Test(expected=IllegalArgumentException.class)
    public void test_can_only_equip_phaser() {
        Phaser p = new Phaser(1,1);
        Blaster b = new Blaster(1,1, 56);

        LightWeightWarShip lightWeightWarShip = new LightWeightWarShip(this.expectedVolume, this.expectedMass,
                this.expectedMaxWeapons);

        lightWeightWarShip.load(p);
        assertTrue(lightWeightWarShip.getEquipments().contains(p));

        lightWeightWarShip.load(b);
    }
}
