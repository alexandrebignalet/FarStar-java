import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.management.remote.TargetedNotification;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class WarShipTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {
                        2,
                        2,
                        1
                },
                {
                        10.0012,
                        10,
                        4
                },
                {
                        100.123,
                        100.125,
                        9
                },
        });
    }

    private double expectedVolume;
    private double expectedMass;
    private int expectedmaxWeapons;

    public WarShipTest(double volume, double mass, int maxWeapons){
        this.expectedVolume = volume;
        this.expectedMass = mass;
        this.expectedmaxWeapons = maxWeapons;
    }

    @Test
    public void test_war_ship_constructor() {
        WarShip warShip = new WarShip(this.expectedVolume, this.expectedMass, this.expectedmaxWeapons);

        assertEquals(this.expectedVolume, warShip.getVolume(), 0.001);
        assertEquals(this.expectedMass, warShip.getMass(), 0.001);
        assertEquals(this.expectedmaxWeapons, warShip.getMaxWeapons());
    }

    @Test
    public void test_can_equip_only_weapons() {
        Phaser p = new Phaser(1,1);

        WarShip warShip = new WarShip(this.expectedVolume, this.expectedMass, this.expectedmaxWeapons);
        warShip.load(p);
        assertTrue(warShip.getEquipments().contains(p));
    }

    @Test(expected=IllegalArgumentException.class)
    public void test_cannot_equip_more_weapons_than_max_weapons_limit() {
        Phaser p;

        WarShip warShip = new WarShip(this.expectedVolume, this.expectedMass, this.expectedmaxWeapons);
        for (int i = 0; i < warShip.getMaxWeapons() ; i++) {
            p = new Phaser(1,1);
            warShip.load(p);
        }
        // Will throw because max weapons reached
        Blaster b = new Blaster(1,1,56);
        warShip.load(b);
    }

    @Test(expected=IllegalArgumentException.class)
    public void test_cannot_equip_weapons_already_equipped() {
        Phaser p = new Phaser(1,1);
        WarShip ws = new WarShip(this.expectedVolume, this.expectedMass, this.expectedmaxWeapons);
        ws.load(p);
        WarShip warShip = new WarShip(this.expectedVolume, this.expectedMass, this.expectedmaxWeapons);
        warShip.load(p);
    }

    @Test(expected=IllegalArgumentException.class)
    public void test_cannot_equip_weapons_already_loaded() {
        Phaser p = new Phaser(1,1);
        TransportShip ts = new TransportShip(this.expectedVolume, this.expectedMass,
                this.expectedVolume - 1, 200);
        ts.load(p);
        WarShip warShip = new WarShip(this.expectedVolume, this.expectedMass, this.expectedmaxWeapons);
        warShip.load(p);
    }

    @Test
    public void test_can_unequip_weapons() {
        Phaser p = new Phaser(1,1);
        WarShip warShip = new WarShip(this.expectedVolume, this.expectedMass, this.expectedmaxWeapons);
        warShip.load(p);
        warShip.unload(p);
        assertFalse(warShip.getEquipments().contains(p));
    }

    @Test(expected=IllegalArgumentException.class)
    public void test_cannot_unequip_weapon_not_equipped() {
        Phaser p = new Phaser(1,1);
        WarShip warShip = new WarShip(this.expectedVolume, this.expectedMass, this.expectedmaxWeapons);
        warShip.unload(p);
    }

    @Test(expected=IllegalArgumentException.class)
    public void test_cannot_unequip_weapon_equipped_elsewhere() {
        Phaser p = new Phaser(1,1);

        WarShip warShip = new WarShip(this.expectedVolume, this.expectedMass, this.expectedmaxWeapons);
        WarShip ws= new WarShip(this.expectedVolume, this.expectedMass, this.expectedmaxWeapons);

        warShip.load(p);
        ws.unload(p);
    }

    @Test(expected=IllegalArgumentException.class)
    public void test_cannot_unequip_weapon_loaded_elsewhere() {
        Phaser p = new Phaser(1,1);

        WarShip warShip = new WarShip(this.expectedVolume, this.expectedMass, this.expectedmaxWeapons);
        TransportShip ts = new TransportShip(this.expectedVolume, this.expectedMass,
                this.expectedVolume - 1, 200);

        ts.load(p);
        warShip.unload(p);
    }
}
