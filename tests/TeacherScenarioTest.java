import javafx.scene.effect.Light;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TeacherScenarioTest {

    private ArrayList<Phaser> phasers = new ArrayList<>();
    private HybridShip mr63 = new HybridShip(200, 150, 180, 600, 5);
    private TransportShip vt2 = new TransportShip(100, 100, 90, 300);
    private LightWeightWarShip vc1 = new LightWeightWarShip(10, 50, 2);

    public TeacherScenarioTest(){

        this.print("Soit un vaisseau de combat léger " + this.vc1.getName() + " (volume=10, masse=50, 2 armes max)");
        this.print("On équipe " + this.vc1.getName() + " avec deux phasers (volume=1, masse=1)");

        Phaser p1 = new Phaser(1,1);
        Phaser p2 = new Phaser(1,1);

        this.phasers.add(p1);
        this.phasers.add(p2);

        this.vc1.equip(p1);
        this.vc1.equip(p2);

        this.print("Soit un vaisseau de transport " + this.vt2.getName() + " (volume=100, masse=100, cap_volume=90, cap_masse=300)");

        this.print("On charge " + this.vt2.getName() + " avec 5 conteneurs (volume=1, mass=1)");

        Container c;
        int i;

        for ( i = 0 ; i < 5 ; i++) {
            c = new Container(1,1);
            this.vt2.load(c);
        }

        this.print("On charge " + this.vt2.getName() + " avec " + this.vc1.getName());
        this.vt2.load(vc1);

        this.print("On déséquipe un des phasers de " + this.vc1.getName() +
                   " et on le charge dans " + this.vt2.getName() + " comme du fret");
        this.vc1.unequip(p1);
        this.vt2.load(p1);

        this.print("Soit " + this.mr63.getName() + " un vieux modèle de vaisseau de transport lourd " +
                   "capable de se battre (volume=200, masse=150, cap_volume=180, cap_masse=600, 5 armes max)");

        this.print("On équipe " + this.mr63.getName() + " avec deux blasters (volume=2, masse=2, gaz=50%), " +
                   "deux phasers (volume=1, masse=1), le vaisseau VT-2, et 4 conteneurs (volume=10, masse=100)");
        Phaser p3 = new Phaser(1,1);
        Phaser p4 = new Phaser(1,1);

        this.phasers.add(p3);
        this.phasers.add(p4);

        Blaster b1 = new Blaster(2,2, 50);
        Blaster b2 = new Blaster(2,2, 50);

        this.mr63.load(p3);
        this.mr63.load(p4);

        this.mr63.load(b1);
        this.mr63.load(b2);

        this.mr63.load(this.vt2);

        for ( i = 0 ; i < 4 ; i++ ) {
            c = new Container(10, 100);
            this.mr63.load(c);
        }
    }

    @Test
    public void test_teacher_scenario() {
        this.print("On veut savoir quelle est la masse totale de " + this.mr63.getName() + " (un bon gros 713) " +
                   "et quel est le volume disponible dans " + this.mr63.getName() + " (il en reste pour 34)");

        this.print("Masse de " + this.mr63.getName() + ": " + this.mr63.getMass());
        this.print("Volume disponible de " + this.mr63.getName() + ": " + this.mr63.getVolumeCapacityRemaining());


        this.print("On veut savoir où est chacun des phasers (deux sont dans " + this.mr63.getName() +
                   ", un est dans la soute de " + this.vt2.getName() +
                   ", le dernier est équipé par " + this.vc1.getName() + " qui est dans la soute de " +
                   this.vt2.getName() + ")");

        for (Phaser phaser: this.phasers) {
            this.resolveLocation(phaser);
        }

        this.print("On veut connaitre le niveau de gaz des blasters équipés par " +
                   this.mr63.getName() + ", puis les recharger");

        for (Equipment equipment: this.mr63.getEquipments()) {
            if ( equipment instanceof Blaster ) {
                this.print("Niveau de charge du blaster " + equipment.getName() +
                        ": " + ((Blaster) equipment).getGazLevel());
                ((Blaster) equipment).recharge();
                this.print("Niveau de charge du blaster " + equipment.getName() +
                        " après rechargement: " + ((Blaster) equipment).getGazLevel());
            }
        }
    }

    private void resolveLocation(Equipment equipment) {
        if (equipment.getLocation() == null ) {
            return;
        }

        if ( equipment instanceof Weapon && ((Weapon)equipment).isEquipped() ) {
            this.print(equipment.getName() + " est équipé par " + equipment.getLocation().getName());
        } else {
            this.print(equipment.getName() + " est dans la soute de " + equipment.getLocation().getName());
        }

        this.resolveLocation(equipment.getLocation());
    }

    private void print(String string) {
        System.out.println(string);
    }
}
