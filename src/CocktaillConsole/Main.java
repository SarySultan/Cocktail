package CocktaillConsole;

import java.awt.Color;
import java.util.Scanner;

// Main class to control the cocktail mixing process
public class Main {

    private static Ingredient[] ingredients;

    // Method to initialize ingredients
    public static void initializeIngredients() {
        
        int sizeOfArray = 15;
        ingredients = new Ingredient[sizeOfArray];
        // Initialize ingredients
        ingredients[0] = new Fruit("Banana", 89, 118.3, "Sweet", true, 3, new Color(255, 251, 201));
        ingredients[1] = new Fruit("Strawberry", 32, 100.0, "Sweet", true, 3, new Color(186, 42, 71));
        ingredients[2] = new Fruit("Lemon", 29, 108.0, "Sour", false, -3, new Color(255, 250, 200));
        ingredients[3] = new Fruit("Orange", 47, 131.0, "Sweet", true, 3, new Color(247, 202, 5));
        ingredients[4] = new Fruit("Mango", 60, 135.0, "Sweet", true, 4, new Color(255, 191, 52));
        ingredients[5] = new Fruit("Apple", 52, 100.4, "Sweet", true, 3, new Color(245, 154, 64));
        ingredients[6] = new Fruit("Guava", 68, 100.0, "Sweet", true, 3, new Color(217, 203, 160));
        ingredients[7] = new Fruit("Grapes", 69, 151.0, "Sweet", true, 4, new Color(104, 41, 97));
        ingredients[8] = new Fruit("Berries", 43, 100.0, "Sweet", true, 3, new Color(153, 15, 75));
        ingredients[9] = new Fruit("Pineapple", 50, 100.0, "Sweet", true, 3, new Color(254, 234, 99));
        ingredients[10] = new Fruit("Kiwi", 61, 100.0, "Sour", false, -3, new Color(122, 150, 15));
        ingredients[11] = new Liquid("Milk", 42, 240.0, "Neutral", false, 0, new Color(255, 255, 240));
        ingredients[12] = new Liquid("Strawberry Milk", 60, 240.0, "Sweet", true, 3, new Color(255, 182, 193));
        ingredients[13] = new Liquid("Honey", 304, 355.0, "Sweet", true, 5, new Color(231, 154, 63));
        ingredients[14] = new Sugar("Sugar", 16, 10.2, "Sweet", true, 5);
    }
  public static Ingredient[] getArray() {
        return ingredients;
    }
    public static void main(String[] args) {
        
       
        // Initialize ingredients
        initializeIngredients();

        // Create a blender and cups
        FileLogger fileLogger = new FileLogger("FileLoggerForConsole.txt"); // Initialize logger with a file path

        Blender blender = new Blender(1000,fileLogger); // Pass logger to Blender
        Cup[] cup = new Cup[3];
        cup[0] = new Cup(350.0, 0, fileLogger);
        cup[1] = new Cup(250.0, 0, fileLogger);
        cup[2] = new Cup(150.0, 0, fileLogger);

        Cocktail cocktail = new Cocktail();
        Scanner input = new Scanner(System.in);
        boolean isAdd = true;
        int choice;
        // Main menu loop
        do {
            // Display menu options
            System.out.println("1. Go to menu");
            System.out.println("2. Mix the ingredient");
            System.out.println("3. Pour into cups");
            System.out.println("4. Cocktail information");
            System.out.println("5. Clean the blender");
            System.out.println("6. Exit");
            System.out.println("...............................");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            // Process user choice
            switch (choice) {
                case 1:
                    // Menu for selecting ingredients
                    int menuChoice;
                    int index;
                    do {
                        // Display ingredient menu
                        int i;
                        for (i = 0; i < ingredients.length; ++i) {
                            System.out.println((i + 1) + ". " + ingredients[i].getName());
                        }
                        System.out.println("                      " + (++i) + ". View ingredient information");
                        System.out.println("                      " + (++i) + ". Back");
                        System.out.println("....................................");
                        System.out.println("Enter your choice: ");
                        menuChoice = input.nextInt();
                        index = menuChoice - 1;

                        // Determine user selection and perform actions
                        if (menuChoice == (i)) {
                            menuChoice = 3;
                        } else if (menuChoice == (i - 1)) {
                            menuChoice = 2;
                        } else if (menuChoice <= (i - 2) && menuChoice > 0) {
                            menuChoice = 1;
                        }

                        switch (menuChoice) {
                            case 1:
                                try {
                                    isAdd = true;
                                    blender.addIngredient(ingredients[index]);
                                } catch (BlenderOverflowException ex) {
                                    System.out.println(ex.getMessage(blender));
                                }
                                break;

                            case 2:
                                for (int indexOfIngredient = 0; indexOfIngredient < ingredients.length; ++indexOfIngredient) {
                                    System.out.println((indexOfIngredient + 1) + ". " + ingredients[indexOfIngredient].getInfo());
                                }
                                break;

                            case 3:
                                break;

                            default:
                                System.out.println("Invalid choice!");
                        }
                    } while (menuChoice != 3);
                    break;

                case 2:
                    try {
                        // Mix the ingredients to create a cocktail
                        if (isAdd) {
                            cocktail = blender.mix();
                            isAdd = false;
                        } else {
                            System.out.println("Please enter new ingredients.");
                        }
                    } catch (BlenderIsEmptyException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case 3:
                    // Pour into cups
                    int cupChoice;
                    try {
                        do {
                            System.out.println("What size cup do you want? \n"
                                    + "1. Large(350 milliliters) \n"
                                    + "2. Medium(250 milliliters)\n"
                                    + "3. Small(150 milliliters)\n"
                                    + "4. Finished\n"
                                    + "............................\n"
                                    + "Enter your choice:");
                            cupChoice = input.nextInt();
                            switch (cupChoice) {
                                case 1:
                                    System.out.println(cup[0].pourCocktail(cocktail, blender));
                                    break;

                                case 2:
                                    System.out.println(cup[1].pourCocktail(cocktail, blender));
                                    break;

                                case 3:
                                    System.out.println(cup[2].pourCocktail(cocktail, blender));
                                    break;

                                case 4:
                                    break;

                                default:
                                    System.out.println("Invalid Choice!");
                            }
                        } while (cupChoice != 4);
                    } catch (BlenderIsEmptyException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case 4:
                    // Display cocktail information
                    System.out.println(cocktail.getInfo());
                    break;

                case 5:
                    // Clean the blender
                    blender.cleanBlender(cocktail, blender);
                    break;

                case 6:
                    // Exit the program and clean the logger
                    fileLogger.clearLog();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }
}
