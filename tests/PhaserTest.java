import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PhaserTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {
                        1,
                        1
                },
                {
                        10,
                        10
                },
                {
                        100,
                        100
                },
        });
    }

    private double expectedMass;
    private double expectedVolume;

    public PhaserTest(double mass, double volume){
        this.expectedMass = mass;
        this.expectedVolume = volume;
    }

    @Test
    public void testPhaserConstructor() {
        Phaser p = new Phaser(this.expectedMass, this.expectedVolume);

        assertEquals(this.expectedMass, p.getMass(), 0.001);
        assertEquals(this.expectedVolume, p.getVolume(), 0.001);
    }
}