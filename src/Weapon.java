public abstract class Weapon extends Equipment{
    private boolean equipped;

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
