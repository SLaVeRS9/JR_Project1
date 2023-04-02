import AlphabetsForCipher.Alphabet;
import AlphabetsForCipher.CyrillicAlphabet;
import AlphabetsForCipher.MainSymbols;
import java.util.Scanner;

class Menu {

    public static void startProgram(){
        printWelcomeMessage();
        printMainMenu();
        Scanner input = new Scanner(System.in);
        String selectedItem = input.nextLine();
        while (!isMenuItemCorrect(selectedItem)){
            System.out.println("\nWrong menu item\nTry again\n");
            printMainMenu();
            selectedItem = input.nextLine();
        }
        if (selectedItem.equalsIgnoreCase("4")){
            System.exit(0);
        }
        printAlphabetMenu();
        String selectedAlphabetItem = input.nextLine();
        while (!isAlphabetItemCorrect(selectedAlphabetItem)){
            System.out.println("\nWrong menu item\nTry again\n");
            printMainMenu();
            selectedAlphabetItem = input.nextLine();
        }
        if (selectedAlphabetItem.equalsIgnoreCase("2")){
            System.exit(0);
        }
        startSelectedOption(selectedItem, selectedAlphabetItem);

        input.close();
        System.out.println("\nThank you for choosing our solution!");
    }

    private static void printWelcomeMessage() {
        System.out.println("""
                Hello! Its your personal files encoder and decoder!
                Also you can break encoder file
                *This program works with cyrillic text and with caesar cipher
                """);
    }

    private static void printMainMenu() {
        System.out.println("""
                Choose the number of option:
                1. Encode file
                2. Decode file with key
                3. Decode file with brute force
                4. Exit
                Enter value:
                """);
    }

    private static void printAlphabetMenu() {
        System.out.println("""
                Choose the language used in your file:
                1. Cyrillic
                2. Exit
                Enter value:
                """);
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
            case "3" -> BrutForceForCaesarCipher.startBrutForce(alphabetSelectedOption(selectedAlphabetItem));
            default -> System.exit(0);
        }
    }

    private static Alphabet alphabetSelectedOption(String selectedItem){
        Alphabet alphabet = switch(selectedItem){
            case "1" -> {
                alphabet = new MainSymbols(CyrillicAlphabet.getInstance());
                yield alphabet;
            }
            default -> {
                System.exit(0);
                yield null;
            }
        };
        return alphabet;
    }
}
