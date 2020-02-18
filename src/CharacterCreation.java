import java.util.ArrayList;
import java.util.Scanner;

public class CharacterCreation {


    public static void crtChar(Player player) {

        // Character creation walk through

        // Prompt for, retrieve, and set player name
        System.out.println("Guard: What is you're name, traveler?");
        Scanner inputName = new Scanner(System.in);
        String charName = inputName.nextLine();
        player.setName(charName);

        // Prompt for, retrieve, and set player profession
        System.out.println("Guard: Excellent. What is your profession, " + player.getName() + "?");
        System.out.println("Wizard or Knight?");
        Scanner inputProfession = new Scanner(System.in);
        String charProfession = inputProfession.next();
        player.setProfession(charProfession);

        // Wizard starting traits and inventory
        if (player.getProfession().toLowerCase().equals("wizard")) {
            System.out.println("Guard: Oh...Well, just keep your hokus pokus to yourself in our town.");
            player.setHp(5);
            ArrayList<Item> inventory = new ArrayList<>();
            inventory.add(new Armor("robe", 5, 1, 0, 2,
                    "none" ));
            inventory.add(new Weapon("staff", 20, 1, 2, 2,
                    "cast spells", true));
            player.setEquipedWeapon((Weapon) inventory.get(1));
            inventory.add(new Item("Spellbook", 10, 0,
                    0, 1, "store known spells"));
            inventory.add(new Item("component pouch", 2,
                    0, 0, 1, "hold ingredients" ));
            player.setInventory(inventory);

        }

        // Knight starting traits and inventory
        else if(player.getProfession().toLowerCase().equals("knight")) {
            System.out.println("Guard: Oh...um...Welcome to our humble town my lord " + player.getName() +
                    ". Let me know if I can get you anything.");
            player.setHp(8);
            ArrayList<Item> inventory = new ArrayList<>();
            inventory.add(new Armor("plate armor", 30, 5, 2, 10,
                    "none"));
            inventory.add(new Sword());
            player.setEquipedWeapon((Weapon) inventory.get(1));
            inventory.add(new Armor("shield", 5, 3, 2, 4,
                    "block"));
            inventory.add(new Item("shoulder pouch", 2, 0, 0, 2,
                    "cary items"));
            player.setInventory(inventory);

        }

        // Print HP and inventory
        System.out.println("You have " + player.getHp() + " Hp.");
        System.out.println("Your inventory contains ");
        // viewInventory method is inherited from the creature class via Humanoid class
        player.viewInventory();

    }

}
