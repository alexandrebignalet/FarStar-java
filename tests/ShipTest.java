import org.junit.Test;

import static org.junit.Assert.*;

public class ShipTest {

    private TransportShip transportShip;
    private WarShip warShip;

    public ShipTest(){
        this.transportShip = new TransportShip(100, 200, 90, 1000);
        this.warShip = new WarShip(10, 20, 5);
    }

    @Test
    public void test_ship_constructor() {

        assertEquals(this.transportShip.getVolume(), 100, 0.001);
        assertEquals(this.transportShip.getMass(), 200, 0.001);

        assertEquals(this.warShip.getVolume(), 10, 0.001);
        assertEquals(this.warShip.getMass(), 20, 0.001);
    }

    @Test
    public void test_ship_can_load_an_equipment_not_loaded_elsewhere() {

        Container container = new Container(1,1);
        Phaser phaser = new Phaser(1,1);

        this.transportShip.load(container);
        this.warShip.equip(phaser);

        assertTrue(this.transportShip.getEquipments().contains(container));
        assertTrue(this.warShip.getEquipments().contains(phaser));
    }

    @Test(expected=IllegalArgumentException.class)
    public void test_ship_load_an_equipment_already_loaded_elsewhere_must_throw() {

        Phaser phaser = new Phaser(1,1);

        this.transportShip.load(phaser);

        this.warShip.equip(phaser);
    }

    @Test(expected=IllegalArgumentException.class)
    public void test_ship_canot_unload_an_equipment_which_is_loaded_and_must_throw() {

        Phaser phaser = new Phaser(1,1);

        this.transportShip.unload(phaser);
    }

    @Test
    public void test_ship_can_unload_an_equipment_loaded_some_time_before() {

        Container container = new Container(1,1);
        Phaser phaser = new Phaser(1,1);

        this.transportShip.load(container);
        this.warShip.equip(phaser);

        int baseEquipmentsSizeTS = this.transportShip.getEquipments().size();
        int baseEquipmentsSizeWS = this.warShip.getEquipments().size();

        this.transportShip.unload(container);
        this.warShip.unequip(phaser);

        assertTrue(this.transportShip.getEquipments().size() < baseEquipmentsSizeTS);
        assertTrue(this.warShip.getEquipments().size() < baseEquipmentsSizeWS);
    }

    @Test
    public void test_load_equipment_set_this_location() {
        Container container = new Container(1,1);
        Phaser phaser = new Phaser(1,1);

        assertNull(container.getLocation());
        assertNull(phaser.getLocation());

        this.transportShip.load(container);
        this.warShip.equip(phaser);

        assertNotNull(container.getLocation());
        assertNotNull(phaser.getLocation());
    }

    @Test
    public void test_unload_equipment_set_this_location_to_null() {
        Container container = new Container(1,1);
        Phaser phaser = new Phaser(1,1);

        this.transportShip.load(container);
        this.warShip.equip(phaser);

        assertNotNull(container.getLocation());
        assertNotNull(phaser.getLocation());

        this.transportShip.unload(container);
        this.warShip.unequip(phaser);

        assertNull(container.getLocation());
        assertNull(phaser.getLocation());
    }
}
