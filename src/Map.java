import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Map {

    public static int rows = 10;
    public static int columns = 10;
    public static char[][] mazeMap = new char[rows][columns];
    public static int y = 0;
    public static int x = 0;

    private static ArrayList<Creature> presentCreatures = new ArrayList<>();


    public static void mapReader() throws Exception {

        // Read map from text file
        Scanner sc = new Scanner(new BufferedReader(new FileReader("C:\\Users\\james\\ideaprojects\\txtgame\\startmap.txt")));

        for (int i = 0; i < mazeMap.length; i++) {
            String line = sc.nextLine(); //Reads rows from maze.txt as long as "i" is less than the number of rows
            for (int j = 0; j < line.length(); j++) {
                mazeMap[i][j] = line.charAt(j); //For each line "i" in maze.txt read the character at index "j"
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

    //
    public static void moveLoop() throws Exception {
        mapReader();
        //placeP();
        findPossibleMove();
        PlayerCommand.getCommandInput();
        //printMap();
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

    /*public static String getUserInput() {
        System.out.println("What do you want to do?");
        System.out.println("Use WASD keys to move.");

        Scanner scanInput = new Scanner(System.in);
        String userInput = scanInput.next();

        return userInput;
    }*/

    public static void playerMove(String userInput) throws Exception {


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
            PlayerCommand.getCommandInput();
        }
    }

    public static void tellNewLocation() {


        if (mazeMap[y][x] == 'M') {
            System.out.println("You see majestic mountains.");
        }
        else if (mazeMap[y][x] == 'E') {
            Creature enemy = new Monster();
            presentCreatures.add(enemy);
            System.out.println("You see a " + enemy.getName() + ". What do you want to do?");
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

    public static ArrayList<Creature> getPresentCreatures() {
        return presentCreatures;
    }

}
