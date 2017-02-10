
<<<<<<< HEAD
public abstract class Weapon extends Equipment{
    protected boolean equipped;

    Weapon(double volume, double mass) {
        super(volume, mass);
        this.equipped = false;
    }

    boolean isEquipped() {
        return equipped;
    }

    void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }
}
=======
public class Weapon extends Equipment{
    private boolean is_equiped=false;
    public Weapon(double mass, double volume)
    {
    super(mass,volume);
    }

    public boolean getIs_equiped() {
        return is_equiped;
    }

    public void setIs_equiped(boolean is_equiped) {
        this.is_equiped = is_equiped;
    }
}
>>>>>>> eef0c545085b0f489848dfa0a0b0372bb98bc172
