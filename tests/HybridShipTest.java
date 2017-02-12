import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class HybridShipTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {
                        4,
                        4,
                        3,
                        12,
                        5
                },
                {
                        10.0012,
                        10,
                        4,
                        14,
                        2
                },
                {
                        100.123,
                        100.125,
                        90,
                        200,
                        10
                },
        });
    }

    private double expectedVolume;
    private double expectedMass;
    private double expectedVolumeCapacity;
    private double expectedWeightCapacity;
    private int expectedMaxWeapons;

    public HybridShipTest(double volume, double mass, double volumeCapacity, double weightCapacity, int maxWeapons){
        this.expectedVolume = volume;
        this.expectedMass = mass;
        this.expectedVolumeCapacity = volumeCapacity;
        this.expectedWeightCapacity = weightCapacity;
        this.expectedMaxWeapons = maxWeapons;
    }

    @Test
    public void test_hybrid_ship_constructor() {
        HybridShip hybridShip = new HybridShip(this.expectedVolume, this.expectedMass,
                this.expectedVolumeCapacity, this.expectedWeightCapacity, this.expectedMaxWeapons);

        assertEquals(this.expectedVolume, hybridShip.getVolume(), 0.001);
        assertEquals(this.expectedMass, hybridShip.getMass(), 0.001);
        assertEquals(this.expectedVolumeCapacity, hybridShip.getVolumeCapacity(), 0.001);
        assertEquals(this.expectedWeightCapacity, hybridShip.getWeightCapacity(), 0.001);
        assertEquals(this.expectedVolumeCapacity, hybridShip.getVolumeCapacityRemaining(), 0.001);
        assertEquals(this.expectedWeightCapacity, hybridShip.getWeightCapacityRemaining(), 0.001);
        assertEquals(this.expectedMaxWeapons, hybridShip.getMaxWeapons());
    }

    @Test(expected=IllegalArgumentException.class)
    public void test_throw_if_volume_lt_volume_capacity() {
        HybridShip hybridShip = new HybridShip(10, 10, 50, 9, 2);
    }

    @Test
    public void test_can_equip_any_weapons() {
        HybridShip hybridShip = new HybridShip(this.expectedVolume, this.expectedMass,
                this.expectedVolumeCapacity, this.expectedWeightCapacity, this.expectedMaxWeapons);

        Phaser p = new Phaser(1,1);
        Blaster b = new Blaster(1,1, 45);

        hybridShip.equip(p);
        assertTrue(hybridShip.getEquipments().contains(p));

        hybridShip.equip(b);
        assertTrue(hybridShip.getEquipments().contains(b));
    }

    @Test(expected=IllegalArgumentException.class)
    public void test_cannot_equip_more_weapons_than_max_weapons_limit() {
        HybridShip hybridShip = new HybridShip(10, 10, 9, 9, 2);

        Phaser p = new Phaser(1,1);
        Phaser p2 = new Phaser(1,1);
        Blaster b = new Blaster(1,1, 45);

        hybridShip.equip(p);
        assertTrue(hybridShip.getEquipments().contains(p));

        hybridShip.equip(b);
        assertTrue(hybridShip.getEquipments().contains(b));

        hybridShip.equip(p);
    }

    @Test(expected=IllegalArgumentException.class)
    public void test_cannot_load_more_volume_than_volume_capacity() {
        HybridShip hybridShip = new HybridShip(10, 10, 5, 9, 2);

        Container c = new Container(1,1);

        hybridShip.load(c);
        assertTrue(hybridShip.getEquipments().contains(c));

        TransportShip bigTransportShip = new TransportShip(10, 10, 9, 3);
        hybridShip.load(bigTransportShip);
    }

    @Test(expected=IllegalArgumentException.class)
    public void test_cannot_load_more_weight_than_weight_capacity() {
        HybridShip hybridShip = new HybridShip(10, 10, 5, 9, 2);

        Container c = new Container(1,1);

        hybridShip.load(c);
        assertTrue(hybridShip.getEquipments().contains(c));

        TransportShip bigTransportShip = new TransportShip(10, 10, 9, 30);
        hybridShip.load(bigTransportShip);
    }

    @Test
    public void test_can_load_any_equipments() {
        HybridShip hybridShip = new HybridShip(this.expectedVolume, this.expectedMass,
                this.expectedVolumeCapacity, this.expectedWeightCapacity, this.expectedMaxWeapons);

        Container c = new Container(1,1);
        Blaster b = new Blaster(1,1, 45);
        WarShip ws = new WarShip(1,2,5);

        hybridShip.load(ws);
        assertTrue(hybridShip.getEquipments().contains(ws));

        hybridShip.load(b);
        assertTrue(hybridShip.getEquipments().contains(b));

        hybridShip.load(c);
        assertTrue(hybridShip.getEquipments().contains(c));
    }
}
