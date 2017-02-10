import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class WeaponTest {

    private Blaster blaster;
    private Phaser phaser;

    public WeaponTest() {
        this.blaster = new Blaster(1,1, 45);
        this.phaser = new Phaser(1, 1);
    }

    @Test
    public void test_weapon_constructor() {

        assertFalse("Weapon not equipped after creation", this.blaster.isEquipped());
        assertFalse("Weapon not equipped after creation", this.phaser.isEquipped());

        assertEquals(this.blaster.getLocation(), null);
        assertEquals(this.blaster.getVolume(), 1, 0.01);
        assertEquals(this.blaster.getMass(), 1, 0.01);
        assertEquals(this.blaster.getGazLevel(), 45, 0.01);

        assertEquals(this.phaser.getVolume(), 1, 0.01);
        assertEquals(this.phaser.getMass(), 1, 0.01);
        assertEquals(this.phaser.getLocation(), null);
    }
}
