import java.util.ArrayList;

public abstract class Ship extends Equipment {

    protected ArrayList<Equipment> equipments;

    Ship(double volume, double mass) {
        super(volume, mass);
        this.equipments = new ArrayList<>();
    }
}
