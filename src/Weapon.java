public class Weapon extends Item {

    private boolean isTwoHanded;

    public Weapon() {

    }

    public Weapon(String name, int value, int armorRating, int damage, int weight, String specialUse,
                  boolean isTwoHanded) {
        setName(name);
        setValue(value);
        setArmorRating(armorRating);
        setDamage(damage);
        setWeight(weight);
        setSpecialUse(specialUse);
        this.isTwoHanded = isTwoHanded;
    }

    public boolean isTwoHanded() {
        return isTwoHanded;
    }

    public void setIsTwoHanded(boolean twoHanded) {
        isTwoHanded = twoHanded;
    }
}
