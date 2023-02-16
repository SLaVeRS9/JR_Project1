import AlphabetsForCipher.Alphabet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class BrutForceForCaesarCipher {
    private static Alphabet alphabet;
    public static void startBrutForce(Alphabet setAlphabet){
        alphabet = setAlphabet;
        int usingAlphabetSize = setAlphabet.getAlphabetCodes().size();
        System.out.println("BrutForce starting...");
        //Get file for decode
        System.out.println("Enter path to file which you want to decode with BrutForce");
        Path path = WorkWithFiles.getFilePath();

        //Read data from file
        StringBuilder decodedDataFromFile = mvpBrutForce(path, usingAlphabetSize);

        //Create and get path to file
        Path pathToEncodingFile = WorkWithFiles.createFile(path, "Decoded_by_BrutForce");

        //Write data to file
        try {
            Files.writeString(pathToEncodingFile, decodedDataFromFile);
            System.out.printf("Decoded file created: %s %n", pathToEncodingFile.getFileName().toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //Manual hack
    private static StringBuilder mvpBrutForce(Path path, int usingAlphabetSize){
        try {
            //Get data from file
            List<String> dataFromFile = Files.readAllLines(path);
            int counter = 0;
            //Get line from data for validation
            int lineNumberToRead = dataFromFile.size() > 1 ? 1 : 0;
            while (counter < usingAlphabetSize){
                //Decode data
                StringBuilder decodedLineFromFile = CaesarCipher.decoder(counter, dataFromFile.get(lineNumberToRead), alphabet);
                System.out.printf("Iteration %d of %d%n".concat("Is this text correct?%n"), counter, usingAlphabetSize);
                System.out.println("---> " + decodedLineFromFile);
                //Manual validate result
                String chosenOption = evaluateBrutForceResult();
                if(chosenOption.equalsIgnoreCase("1")){
                    break;
                }
                counter++;
            }
            //Decode all data
            return CaesarCipher.decoder(counter,dataFromFile.toString(), alphabet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //TODO Will be done in the future when ai analyzer will be done
    private static void aiBrutForce(){

    }
    private static String evaluateBrutForceResult(){
        System.out.println("Choose the number of option: ");
        System.out.println("1. Text is correct");
        System.out.println("2. Text isn't readable");
        System.out.println("3. Exit\n");
        System.out.print("Enter value: ");

        Scanner input = new Scanner(System.in);
        String selectedItem = input.nextLine();
        while (!isSelectedItemIsCorrect(selectedItem)){
            System.out.print("\nWrong menu item\nTry again: ");
            selectedItem = input.nextLine();
        }
        if (selectedItem.equalsIgnoreCase("3")){
            System.exit(0);
        }
        return selectedItem;
    }

    private static boolean isSelectedItemIsCorrect(String input){
        boolean result = switch (input.toLowerCase()){
            case "1", "2", "3" ->  true;
            default -> false;
        };
        return result;
    }

}
