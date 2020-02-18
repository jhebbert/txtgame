import java.util.ArrayList;
import java.util.Random;

public abstract class Creature {

    private int hp = 10;
    private ArrayList<Item> inventory;
    private String name = "monster";
    private int armorClass = 10;
    private ArrayList<Item> equipedItems;
    private int strength = 10;
    private int dexterity = 10;
    private Weapon equipedWeapon = new Claws();



    // Print complete inventory to console
    public void viewInventory() {
        for(int i = 0; i < inventory.size(); i++) {
            System.out.println(inventory.get(i).getName());
        }
    }

    public void equipItem(Item newItem) {
        equipedItems.add(newItem);
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public  ArrayList<Item> getInventory() {
        return  inventory;
    }

    public void setInventory(ArrayList inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public ArrayList<Item> getEquipedItems() {
        return equipedItems;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setEquipedWeapon(Weapon equipedWeapon) {
        this.equipedWeapon = equipedWeapon;
    }

    public Weapon getEquipedWeapon() {
        return equipedWeapon;
    }
}
