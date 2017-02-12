import java.util.ArrayList;

public abstract class Ship extends Equipment implements Transporter {

    private ArrayList<Equipment> equipments = new ArrayList<>();

    public Ship(double volume, double mass) {
        super(volume, mass);
    }

    public ArrayList<Equipment> getEquipments() {
        return this.equipments;
    }

    public double getMass(){
        double total = super.getMass();

        for (Equipment equipment : this.equipments) {
            total += equipment.getMass();
        }

        return total;
    }

    public void setLocation(Ship ship) {
        if ( !(ship instanceof EquipmentTransporter)) {
            throw new IllegalArgumentException("TransportShip can be load only in EquipmentTransporter");
        }
        super.setLocation(ship);
    }
}
