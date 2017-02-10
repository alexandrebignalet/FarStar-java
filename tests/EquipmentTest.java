import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class EquipmentTest {
<<<<<<< HEAD
=======

>>>>>>> eef0c545085b0f489848dfa0a0b0372bb98bc172
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {
                        1,
                        1
                },
                {
<<<<<<< HEAD
                        10,
                        10
                },
                {
                        100,
                        100
=======
                        10.0012,
                        10
                },
                {
                        100.123,
                        100.125
>>>>>>> eef0c545085b0f489848dfa0a0b0372bb98bc172
                },
        });
    }

    private double expectedMass;
    private double expectedVolume;
<<<<<<< HEAD
    private Ship expectedLocation;
=======
    private Equipment expectedLocation;
>>>>>>> eef0c545085b0f489848dfa0a0b0372bb98bc172

    public EquipmentTest(double mass, double volume){
        this.expectedMass = mass;
        this.expectedVolume = volume;
        this.expectedLocation = null;
    }

    @Test
<<<<<<< HEAD
    public void test_equipment_constructor() {
        Equipment c = new Container(this.expectedVolume, this.expectedMass);
        Equipment p = new Phaser(this.expectedVolume, this.expectedMass);

        assertEquals(this.expectedVolume, c.getVolume(), 0.001);
        assertEquals(this.expectedMass, c.getMass(), 0.001);
        assertEquals(this.expectedLocation, c.getLocation());

        assertEquals(this.expectedVolume, p.getVolume(), 0.001);
        assertEquals(this.expectedMass, p.getMass(), 0.001);
        assertEquals(this.expectedLocation, p.getLocation());
    }
}
=======
    public void testEquipmentConstructor() {
        Equipment p = new Phaser(this.expectedMass, this.expectedVolume);

        assertEquals(this.expectedMass, p.getMass(), 0.001);
        assertEquals(this.expectedVolume, p.getVolume(), 0.001);
        assertEquals(this.expectedLocation, p.getLocation());

        Equipment ts = new TransportShip(this.expectedMass, this.expectedVolume, this.expectedMass, this.expectedVolume - 1);

        assertEquals(this.expectedMass, ts.getMass(), 0.001);
        assertEquals(this.expectedVolume, ts.getVolume(), 0.001);
        assertEquals(this.expectedLocation, ts.getLocation());

        Equipment c = new Container(this.expectedMass, this.expectedVolume);

        assertEquals(this.expectedMass, c.getMass(), 0.001);
        assertEquals(this.expectedVolume, c.getVolume(), 0.001);
        assertEquals(this.expectedLocation, c.getLocation());
    }
}
>>>>>>> eef0c545085b0f489848dfa0a0b0372bb98bc172
