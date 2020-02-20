import java.util.Scanner;

public class Player extends Humanoid {

    private static Player player = null;

    private Player() {

    }

    public static Player getPlayer() {

        if (player == null) {
            player = new Player();
        }
        return player;
    }

    public void lootBody() {

        if (Map.getPresentCreatures().isEmpty()) {
            System.out.println("There is nothing to loot.");
        } else {
            Creature body = Map.getPresentCreatures().get(0);
            if (body.getInventory().isEmpty()) {
                System.out.println("There is nothing you can take");
            } else {
                Map.getPresentCreatures().get(0).viewInventory();
                System.out.println("What would you like to take?");
                System.out.println("Enter the number of the item you would like to take, type \"all\"");
                Scanner selectionInput = new Scanner(System.in);
                // FIXME: select items to take from body, and add them to player.inventory.
            }
        }
    }
}
