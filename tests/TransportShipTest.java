import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class TransportShipTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {
                        2,
                        2,
                        1,
                        10
                },
                {
                        10.0012,
                        10,
                        9,
                        20
                },
                {
                        100.123,
                        100.125,
                        90,
                        100
                },
        });
    }

    private double expectedVolume;
    private double expectedMass;
    private double expectedVolumeCapacity;
    private double expectedWeightCapacity;

    public TransportShipTest(double volume, double mass, double volumeCapacity, double weightCapacity){
        this.expectedVolume = volume;
        this.expectedMass = mass;
        this.expectedVolumeCapacity = volumeCapacity;
        this.expectedWeightCapacity = weightCapacity;
    }

    @Test
    public void test_transport_ship_constructor() {
        TransportShip ts = new TransportShip(this.expectedVolume, this.expectedMass,
                this.expectedVolumeCapacity, this.expectedWeightCapacity);

        assertEquals(this.expectedVolume, ts.getVolume(), 0.001);
        assertEquals(this.expectedMass, ts.getMass(), 0.001);
        assertEquals(this.expectedVolumeCapacity, ts.getVolumeCapacity(), 0.001);
        assertEquals(this.expectedWeightCapacity, ts.getWeightCapacity(), 0.001);
        assertEquals(this.expectedVolumeCapacity, ts.getVolumeCapacityRemaining(), 0.001);
        assertEquals(this.expectedWeightCapacity, ts.getWeightCapacityRemaining(), 0.001);
    }

    @Test(expected=IllegalArgumentException.class)
    public void test_load_throw_if_volume_capacity_exceed() {
        TransportShip ts = new TransportShip(this.expectedVolume, this.expectedMass,
                this.expectedVolumeCapacity, this.expectedWeightCapacity);

        Container container = new Container(1000,1);

        ts.load(container);
    }

    @Test(expected=IllegalArgumentException.class)
    public void test_load_throw_if_weight_capacity_exceed() {
        TransportShip ts = new TransportShip(this.expectedVolume, this.expectedMass,
                this.expectedVolumeCapacity, this.expectedWeightCapacity);

        Container container = new Container(1,1000);

        ts.load(container);
    }

    @Test
    public void test_load_decrease_volume_capacity_remaining_by_the_equipment_volume() {
        TransportShip ts = new TransportShip(this.expectedVolume, this.expectedMass,
                this.expectedVolumeCapacity, this.expectedWeightCapacity);

        Container container = new Container(1,1);
        double baseVolumeRemaining = ts.getVolumeCapacityRemaining();

        ts.load(container);
        assertTrue(baseVolumeRemaining > ts.getVolumeCapacityRemaining());
    }

    @Test
    public void test_unload_increase_volume_capacity_remaining_by_the_equipment_volume() {
        TransportShip ts = new TransportShip(this.expectedVolume, this.expectedMass,
                this.expectedVolumeCapacity, this.expectedWeightCapacity);

        Container container = new Container(1,1);
        ts.load(container);
        double baseVolumeRemaining = ts.getVolumeCapacityRemaining();
        ts.unload(container);
        assertTrue(baseVolumeRemaining < ts.getVolumeCapacityRemaining());
    }

    @Test
    public void test_load_decrease_weight_capacity_remaining_by_the_equipment_mass() {
        TransportShip ts = new TransportShip(this.expectedVolume, this.expectedMass,
                this.expectedVolumeCapacity, this.expectedWeightCapacity);

        Container container = new Container(1,1);
        double baseWeightRemaining = ts.getWeightCapacityRemaining();

        ts.load(container);
        assertTrue(baseWeightRemaining > ts.getWeightCapacityRemaining());
    }

    @Test
    public void test_unload_increase_weight_capacity_remaining_by_the_equipment_mass() {
        TransportShip ts = new TransportShip(this.expectedVolume, this.expectedMass,
                this.expectedVolumeCapacity, this.expectedWeightCapacity);

        Container container = new Container(1,1);
        ts.load(container);
        double baseWeightRemaining = ts.getWeightCapacityRemaining();
        ts.unload(container);
        assertTrue(baseWeightRemaining < ts.getWeightCapacityRemaining());
    }
}
