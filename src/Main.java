import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;





public class Main {




    public static void main(String[] args) throws Exception {




        prntIntro();
        // Create character
        CharacterCreation.crtChar(Player.getPlayer());
        Map.mapReader();
        Map.findStart();
        Map.tellNewLocation();
        Map.moveLoop();
    }

    private static void prntIntro() {
        System.out.println("Epic intro here");
    }




    /*public static void mapReader() throws Exception {

        Scanner sc = new Scanner(new BufferedReader(new FileReader("C:\\Users\\james\\ideaprojects\\txtgame\\startmap.txt")));

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
        mapReader();
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

    public static String getCommandInput() {

        System.out.println("Where do you want to move?");
        System.out.println("Use WASD keys to move.");
        Scanner scanInput = new Scanner(System.in);
        String userInput = scanInput.next();
        return userInput;
    }

    public static void playerMove() {
        String userInput = getCommandInput();

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
    }*/
    }

