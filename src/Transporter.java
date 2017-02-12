import java.util.ArrayList;

public interface Transporter {

    ArrayList<Equipment> getEquipments();

    default void load(Equipment equipment) throws IllegalArgumentException {
        if (equipment.getLocation() != null)
        {
            throw new IllegalArgumentException("This equipment cannot be loaded. It is loaded elsewhere.");
        }
    }

    default void unload(Equipment equipment) throws IllegalArgumentException {
        if ( !this.getEquipments().remove(equipment) ) {
            throw new IllegalArgumentException("Equipement cannot be removed because it's not in the equipments.");
        }
    }
}
