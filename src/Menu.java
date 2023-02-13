import AlphabetsForCiper.AlphabetForCiper;
import AlphabetsForCiper.CyrillicAlphabetForCipher;

import java.util.Scanner;

public class Menu {

    public static void startProgram(){
        printWelcomeMessage();
        printMainMenu();
        Scanner input = new Scanner(System.in);
        String selectedItem = input.nextLine();
        while (!isMenuItemCorrect(selectedItem)){
            if (selectedItem.equalsIgnoreCase("4")){
                System.exit(0);
            }
            System.out.println("\nWrong menu item\nTry again\n");
            printMainMenu();
            selectedItem = input.nextLine();
        }
        printAlphabetMenu();
        String selectedAlphabetItem = input.nextLine();
        while (!isAlphabetItemCorrect(selectedAlphabetItem)){
            if (selectedAlphabetItem.equalsIgnoreCase("2")){
                System.exit(0);
            }
            System.out.println("\nWrong menu item\nTry again\n");
            printMainMenu();
            selectedAlphabetItem = input.nextLine();
        }

        startSelectedOption(selectedItem, selectedAlphabetItem);
    }

    private static void printWelcomeMessage() {
        System.out.println("Hello! Its your personal files encoder and decoder!\n"
                .concat("Also you can break encoder file\n")
                .concat("*This program works with cyrillic text and with caesar cipher\n"));
    }

    private static void printMainMenu() {
        System.out.println("Choose the number of option: ");
        System.out.println("1. Encode file");
        System.out.println("2. Decode file with key");
        System.out.println("3. Decode file with brute force");
        System.out.println("4. Exit\n");
        System.out.print("Enter value: ");
    }

    private static void printAlphabetMenu() {
        System.out.println("Choose the language used in your file: ");
        System.out.println("1. Cyrillic");
        System.out.println("2. Exit\n");
        System.out.print("Enter value: ");
    }

    private static boolean isMenuItemCorrect(String input){
        boolean result = switch (input.toLowerCase()){
            case "1", "2", "3", "4" ->  true;
            default -> false;
        };
        return result;
    }

    private static boolean isAlphabetItemCorrect(String input){
        boolean result = switch (input.toLowerCase()){
            case "1", "2" ->  true;
            default -> false;
        };
        return result;
    }

    private static void startSelectedOption(String selectedItem, String selectedAlphabetItem){
        switch(selectedItem){
            case "1" -> {
                CaesarCipher.startEncode(alphabetSelectedOption(selectedAlphabetItem));
            }
            case "2" -> CaesarCipher.startDecode(alphabetSelectedOption(selectedAlphabetItem));
            //case "3" -> ; TODO Write option for brut force
            case "4" -> System.exit(0);
        }
    }

    private static AlphabetForCiper alphabetSelectedOption(String selectedItem){
        AlphabetForCiper alphabet = switch(selectedItem){
            case "1" -> CyrillicAlphabetForCipher.getInstance();
            default -> {
                System.exit(0);
                yield null;}
        };
        return alphabet;
    }
}
