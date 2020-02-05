public class Item {

    private String name;
    private int value;
    private int armorRating;
    private int damage;
    private int weight;
    private String specialUse;

    public Item() {

    }

    public Item(String name, int value, int armorRating, int damage, int weight, String specialUse) {
        this.name = name;
        this.value = value;
        this.armorRating = armorRating;
        this.damage = damage;
        this.weight = weight;
        this.specialUse = specialUse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getArmorRating() {
        return armorRating;
    }

    public void setArmorRating(int armorRating) {
        this.armorRating = armorRating;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getSpecialUse() {
        return specialUse;
    }

    public void setSpecialUse(String specialUse) {
        this.specialUse = specialUse;
    }
}
