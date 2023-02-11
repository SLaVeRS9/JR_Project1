import java.lang.System.Logger;
import java.util.Scanner;

public class Menu {
    //TODO Maybe delete this parametr
    private final static int MENU_ITEMS_COUNT = 4;

    public static void menu(){
        printWelcomeMessage();
        printMenu();
        Scanner input = new Scanner(System.in);
        String choosenItem = input.nextLine();
        while (!isMenuItemCorrect(choosenItem)){
            if (choosenItem.equalsIgnoreCase("4")){
                System.exit(0);
            }
            System.out.println("\nWrong menu item\nTry again\n");
            Logger logger;
            logger.log("\nWrong menu item\nTry again\n");
            printMenu();
            choosenItem = input.nextLine();
        }
        System.out.println(choosenItem);
    }

    private static void printWelcomeMessage() {
        System.out.println("Hello! Its your personal files encoder and decoder!\n"
                .concat("Also you can break encoder file\n")
                .concat("*This program works with cyrillic text and with caesar cipher\n"));
    }

    private static void printMenu() {
        System.out.println("Choose the number of option: ");
        System.out.println("1. Encode file");
        System.out.println("2. Decode file with key");
        System.out.println("3. Decode file with brute force");
        System.out.println("4. Exit");
    }

    private static boolean isMenuItemCorrect(String input){
        boolean result = switch (input.toLowerCase()){
            case "1", "2", "3", "4" ->  true;
            default -> false;
        };
        return result;
    }

    private static void startChoosenOption(String choosenItem){
        switch(choosenItem){
            case "1" -> CaesarCipher.startEncode();
            case "2" -> CaesarCipher.startDecode();
            case "3" -> ;
            case "4" -> System.exit(0);
        }
    }
}
