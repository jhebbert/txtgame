import java.util.ArrayList;

public abstract class Creature {

    private int hp;
    private ArrayList<Item> inventory;
    private String name;
    private int armorClass;
    private ArrayList<Item> equipedItems;

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
}
