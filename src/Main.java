import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;




public class Main {

    public static int rows = 10;
    public static int columns = 10;
    public static char[][] mazeMap = new char[rows][columns];
    public static int y = 0;
    public static int x = 0;
    public static Player player = new Player();

    public static void main(String[] args) throws Exception {
        prntIntro();
        crtChar();
        reader();
        findStart();
        tellNewLocation();
        moveLoop();
    }

    private static void prntIntro() {
        System.out.println("Epic intro here");
    }

    private static void crtChar() {

        System.out.println("Guard: What is you're name, traveler?");
        Scanner inputName = new Scanner(System.in);
        String charName = inputName.nextLine();
        player.setName(charName);
        System.out.println("Guard: Excellent. What is your profession, " + player.getName() + "?");
        System.out.println("Wizard or Knight?");
        Scanner inputProfession = new Scanner(System.in);
        String charProfession = inputProfession.next();
        player.setProfession(charProfession);
        if (player.getProfession().toLowerCase().equals("wizard")) {
            System.out.println("Guard: Oh...Well, just keep your hokus pokus to yourself in our town.");
            player.setHp(5);
            ArrayList<Item> inventory = new ArrayList<>();
            inventory.add(new Armor("robe", 5, 1, 0, 2,
                    "none" ));
            inventory.add(new Weapon("staff", 20, 1, 2, 2,
                    "cast spells", true));
            inventory.add(new Item("Spellbook", 10, 0,
                    0, 1, "store known spells"));
            inventory.add(new Item("component pouch", 2,
                    0, 0, 1, "hold ingredients" ));
             player.setInventory(inventory);

        }
        else if(player.getProfession().toLowerCase().equals("knight")) {
            System.out.println("Guard: Oh...um...Welcome to our humble town my lord " + player.getName() +
                    ". Let me know if I can get you anything.");
            player.setHp(8);
            ArrayList<Item> inventory = new ArrayList<>();
            inventory.add(new Armor("plate armor", 30, 5, 2, 10,
                    "none"));
            inventory.add(new Sword());
            inventory.add(new Armor("shield", 5, 3, 2, 4,
                    "block"));
            inventory.add(new Item("shoulder pouch", 2, 0, 0, 2,
                    "cary items"));
            player.setInventory(inventory);

        }
            System.out.println("You have " + player.getHp() + " Hp.");
            System.out.println("Your inventory contains ");
            player.viewInventory();

        }


    public static void reader() throws Exception {

        Scanner sc = new Scanner(new BufferedReader(new FileReader("C:\\Users\\james\\txtgame\\startmap.txt")));

        for (int i = 0; i < mazeMap.length; i++) {
            String line = sc.nextLine(); //Reads rows from maze.txt as long as "y" is less than the number of rows
            for (int j = 0; j < line.length(); j++) {
                mazeMap[i][j] = line.charAt(j); //For each line "y" in maze.txt read the character at index "x"
            }
        }
    }

    public static void printMap() {

        for (int i = 0; i < mazeMap.length; i++) {
            for (int j = 0; j < mazeMap.length; j++) {
                System.out.print(mazeMap[i][j]); //Print the character at index [y][x]
            }
            System.out.println();

        }
    }

    public static void findStart() {
        for (int i = 0; i < mazeMap.length; i++) {
            for (int j = 0; j < mazeMap.length; j++) {
                if (mazeMap[i][j] == 'S') {
                    x = j;
                    y = i;
                    placeP();
                }
            }
        }
    }


    public static void moveLoop() throws Exception {
        reader();
        placeP();
        printMap();
        findPossibleMove();
        playerMove();
        moveLoop();
    }

    private static void findPossibleMove() {
        System.out.println("You can move");

        if (mazeMap[y - 1][x] != 'W' ) {
            System.out.println("North");
        }
        if (mazeMap[y + 1][x] != 'W' ) {
            System.out.println("South");
        }
        if (mazeMap[y][x + 1] != 'W' ) {
            System.out.println("East");
        }
        if (mazeMap[y][x - 1] != 'W' ) {
            System.out.println("West");
        }
    }

    public static String getUserInput() {

        System.out.println("Where do you want to move?");
        System.out.println("Use WASD keys to move.");
        Scanner scanInput = new Scanner(System.in);
        String userInput = scanInput.next();
        return userInput;
    }

    public static void playerMove() {
        String userInput = getUserInput();

        if (userInput.equals("n") || userInput.equals("north") || userInput.equals("North")) {
            if (mazeMap[y - 1][x] != 'W') {
                y--;
                tellNewLocation();
            } else {
                System.out.println("You can't walk through walls!");
            }
        } else if (userInput.equals("s") || userInput.equals("south") || userInput.equals("South")) {
            if (mazeMap[y +1][x] != 'W') {
                y++;
                tellNewLocation();
            } else {
                System.out.println("You can't walk through walls!");
            }
        } else if (userInput.equals("w") || userInput.equals("west") || userInput.equals("West")) {
            if (mazeMap[y][x - 1] != 'W') {
                x--;
                tellNewLocation();
            } else {
                System.out.println("You can't walk through walls!");
            }
        } else if (userInput.equals("e") || userInput.equals("east") || userInput.equals("East")) {
            if (mazeMap[y][x + 1] != 'W') {
                x++;
                tellNewLocation();
            } else {
                System.out.println("You can't walk through walls!");
            }
        }  else {
            System.out.println("Sorry, that is not a valid command.");
            System.out.println("Please enter w, a, s, or d, then press enter to move through the maze");
            playerMove();
        }
    }

    public static void tellNewLocation() {


        if (mazeMap[y][x] == 'M') {
            System.out.println("You see majestic mountains.");
        }
        else if (mazeMap[y][x] == 'E') {
            System.out.println("You see an enemy! What do you want to do?");
        }
        else if (mazeMap[y][x] == 'W') {
            System.out.println("You are standing in a wall!");
        }
        else {
            System.out.println("You see nothing of interest.");
        }

    }
    public static void placeP() {
        mazeMap[y][x] = 'P';
    }
    }

