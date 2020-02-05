public class Armor extends Wearable {

    public Armor() {

    }

    public Armor(String name, int value, int armor, int damage, int weight, String specialUse) {
        setName(name);
        setValue(value);
        setArmorRating(armor);
        setDamage(damage);
        setWeight(weight);
        setSpecialUse(specialUse);
    }

}
