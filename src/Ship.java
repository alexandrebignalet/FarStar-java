import java.util.ArrayList;

public abstract class Ship extends Equipment implements Transporter {
    private ArrayList<Equipment> equipments;

    public Ship(double volume, double mass) {
        super(volume, mass);
        this.equipments = new ArrayList<>();
    }

    public ArrayList<Equipment> getEquipments() {
        return equipments;
    }

//    public void load(Equipment equipment) {
//        Transporter.super.load(equipment);
//        equipment.setLocation(this);
//    }
//
//    public void unload(Equipment equipment) {
//        Transporter.super.unload(equipment);
//        equipment.setLocation(null);
//    }

    double getMass(){
        double total = this.mass;

        for (Equipment equipment : this.equipments) {
            total += equipment.getMass();
        }

        return total;
    }
}
