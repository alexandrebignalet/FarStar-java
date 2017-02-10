import java.util.ArrayList;

public class Ship extends Equipment {
    protected ArrayList<Equipment> shipment;

    public Ship(double mass, double volume){
        super(mass,volume);
        this.shipment = new ArrayList<>();
    }

    public ArrayList<Equipment> getShipment() {
        return shipment;
    }

    protected void setShipment(Equipment equipment) {
        if (equipment.getLocation() != null)
        {
            throw new IllegalArgumentException("Location isn t null for this equipment");
        }

        this.shipment.add(equipment);

        equipment.setLocation(this);
    }

    protected void unloadShipment(Equipment equipment) {
        this.shipment.remove(equipment);
        equipment.setLocation(null);
    }

    double getMass(){
        double total=this.mass;
        for (Equipment eq : this.shipment) {
            total = total+eq.getMass();
        }
        return total;
    }
}
