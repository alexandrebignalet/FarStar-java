import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class EquipmentTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {
                        1,
                        1
                },
                {
                        10.0012,
                        10
                },
                {
                        100.123,
                        100.125
                },
        });
    }

    private double expectedMass;
    private double expectedVolume;
    private Ship expectedLocation;

    public EquipmentTest(double mass, double volume){
        this.expectedMass = mass;
        this.expectedVolume = volume;
        this.expectedLocation = null;
    }

    @Test
    public void test_equipment_constructor() {
        Equipment c = new Container(this.expectedVolume, this.expectedMass);
        Equipment p = new Phaser(this.expectedVolume, this.expectedMass);
        Equipment ts = new TransportShip(this.expectedVolume, this.expectedMass,
                this.expectedVolume - 1, this.expectedMass);

        assertEquals(this.expectedVolume, c.getVolume(), 0.001);
        assertEquals(this.expectedMass, c.getMass(), 0.001);
        assertEquals(this.expectedLocation, c.getLocation());

        assertEquals(this.expectedVolume, p.getVolume(), 0.001);
        assertEquals(this.expectedMass, p.getMass(), 0.001);
        assertEquals(this.expectedLocation, p.getLocation());

        assertEquals(this.expectedVolume, ts.getVolume(), 0.001);
        assertEquals(this.expectedMass, ts.getMass(), 0.001);
        assertEquals(this.expectedLocation, ts.getLocation());
    }
}
