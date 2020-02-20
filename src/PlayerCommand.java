import java.util.ArrayList;
import java.util.Scanner;


public class PlayerCommand {


    public static void getCommandInput() throws Exception {
        System.out.println("What do you want to do?");
        System.out.println("Use WASD keys to move.");

        Scanner scanInput = new Scanner(System.in);
        String userInput = scanInput.next();

        selectCommand(userInput);
    }

    // Determine players entered command and call the connected methods
    public static void selectCommand(String userInput) throws Exception {
        // Switch variable
        String command = userInput.toLowerCase();
        switch (command) {
            case "n":
                Map.playerMove(command);
                break;
            case "north":
                Map.playerMove(command);
                break;
            case "s":
                Map.playerMove(command);
                break;
            case "south":
                Map.playerMove(command);
                break;
            case "w":
                Map.playerMove(command);
                break;
            case "west":
                Map.playerMove(command);
                break;
            case "e":
                Map.playerMove(command);
                break;
            case "east":
                Map.playerMove(command);
                break;
            case "attack":
                System.out.println("What do you want to attack?");
                Scanner targetInput = new Scanner(System.in);
                String targetName = targetInput.next();
                Creature target = null;

                // Find target creature from present creatures list
                ArrayList<Creature> creatures = Map.getPresentCreatures();
                for (int i = 0; i < creatures.size(); i++) {
                    if (creatures.get(i).getName().equals(targetName)) {
                        target = creatures.get(i);
                    }
                }

                Combat.attack(Player.getPlayer(), target);
                break;
            case "loot":
                Player.getPlayer().lootBody();
                break;
        }

    }

}
