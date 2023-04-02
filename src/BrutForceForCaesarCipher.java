import AlphabetsForCipher.Alphabet;

import java.io.IOException;
import java.nio.charset.CharacterCodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class BrutForceForCaesarCipher {
    private static Alphabet alphabet;
    private static final String MANUAL_BRUT_FORCE = "manual";
    private static final String BRUT_FORCE_WITH_ANALYZER = "analyzer";

    public static void startBrutForce(Alphabet setAlphabet){
        alphabet = setAlphabet;
        int usingAlphabetSize = setAlphabet.getAlphabetCodes().size();
        System.out.println("BrutForce starting...");
        //Get file for decode
        System.out.println("Enter path to file which you want to decode with BrutForce");
        Path path = WorkWithFiles.getFilePath();

        //choose brut method
        String brutForceMethod = choiseOfBrutForceMethod();

        //Read data from file
        StringBuilder decodedDataFromFile = new StringBuilder();
        if (brutForceMethod.equals(MANUAL_BRUT_FORCE)){
             decodedDataFromFile = startManualBrutForce(path, usingAlphabetSize);
        } else if (brutForceMethod.equals(BRUT_FORCE_WITH_ANALYZER)){
            decodedDataFromFile = startBrutForceWithAnalyzer(path, usingAlphabetSize);
        } else {
            //TODO make this exception
            //throw invalidBrutMethodException;
        }
        
        //Create and get path to file
        Path pathToEncodingFile = WorkWithFiles.createFile(path, "Decoded_by_BrutForce");

        //Write data to file
        try {
            Files.writeString(pathToEncodingFile, decodedDataFromFile);
            System.out.printf("Decoded file created: %s %n", pathToEncodingFile.getFileName().toString());
        } catch (CharacterCodingException e) {
            throw new RuntimeException("Check that the coding file in encoding UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Manual hack
    private static StringBuilder startManualBrutForce(Path path, int usingAlphabetSize){
        try {
            //Get data from file
            List<String> dataFromFile = Files.readAllLines(path);
            int counter = 0;
            //Get line from data for validation
            int lineNumberToRead = dataFromFile.size() > 1 ? 1 : 0;
            for (int i = 0; i < usingAlphabetSize; i++) {
                //Decode data
                StringBuilder decodedLineFromFile = CaesarCipher.decoder(counter, dataFromFile.get(lineNumberToRead), alphabet);
                System.out.printf("Iteration %d of %d%n".concat("Is this text correct?%n"), counter, usingAlphabetSize);
                System.out.println("---> " + decodedLineFromFile);
                //Manual validate result
                String chosenOption = evaluateBrutForceResult();
                if(chosenOption.equalsIgnoreCase("1")){
                    break;
                }
                System.out.println("Sorry we can't encode this file :(");
            }
            //Decode all data
            return CaesarCipher.decoder(counter, String.join("\n", dataFromFile), alphabet);
        } catch (CharacterCodingException e) {
            throw new RuntimeException("Check that the coding file in encoding UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //TODO Will be done in the future when ai analyzer will be done
    private static StringBuilder startBrutForceWithAnalyzer(Path path, int usingAlphabetSize){
        try {
            String dataFromFile = Files.readString(path);
            int counter = 0;
            for (int i = 0; i < usingAlphabetSize; i++) {
                StringBuilder decodedDataFromFile = CaesarCipher.decoder(counter, dataFromFile, alphabet);
                int hackResult = HackAnalyzer.analyzeForComplianceWithTheMainPatterns(decodedDataFromFile);
                if (hackResult == 0) {
                    System.out.println("The result may be inaccurate :()\n"
                            .concat("If decoded file is incorrect y can try again decode this decoded file")
                    );
                    return decodedDataFromFile;
                } else if (hackResult > 0){
                    System.out.println("Decodering complete");
                    return decodedDataFromFile;
                }
                System.out.println("Sorry we can't encode this file :(");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String choiseOfBrutForceMethod(){
        System.out.println("Choose the brut force item method to decode:\n"
        .concat("1. Manual\n")
        .concat("2. With auto analyzer"));
        Scanner input = new Scanner(System.in);
        String selectedItem = input.nextLine();
        while (true){
            if (selectedItem.equalsIgnoreCase("1")){
                return MANUAL_BRUT_FORCE;
            } else if (selectedItem.equalsIgnoreCase("2")){
                return BRUT_FORCE_WITH_ANALYZER;
            } else {
                System.out.println("\nWrong menu item\nTry again: ");
            }
        }
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
