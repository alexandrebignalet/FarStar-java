import java.util.ArrayList;

public interface Transporter {

    ArrayList<Equipment> getEquipments();

    default void canLoad(Equipment equipment) throws IllegalArgumentException {
        if (equipment.getLocation() != null)
        {
            throw new IllegalArgumentException("Location isn t null for this equipment");
        }
    }

    default void canUnload(Equipment equipment) throws IllegalArgumentException {
        if ( !this.getEquipments().remove(equipment) ) {
            throw new IllegalArgumentException("Equipement cannot be removed because it's not in the equipments.");
        }
    }
}
