import AlphabetsForCipher.AlphabetForCipher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class BrutForceForCaesarCipher {
    private static AlphabetForCipher alphabetForCipher;
    public static void startBrutForce(AlphabetForCipher setAlphabetForCipher){
        alphabetForCipher = setAlphabetForCipher;
        int usingAlphabetSize = setAlphabetForCipher.getCyrillicAlphabetCodesAndSymbols().size();
        System.out.println("BrutForce starting...");
        //Получить файл для декодирования
        System.out.println("Enter path to file which you want to decode with BrutForce");
        Path path = WorkWithFiles.getFilePath();

        //Прочитать строку (часть данных)
        StringBuilder decodedDataFromFile = mvpBrutForce(path, usingAlphabetSize);

        Path pathToEncodingFile = WorkWithFiles.createFile(path, "Decoded_by_BrutForce");

        try {
            Files.writeString(pathToEncodingFile, decodedDataFromFile);
            System.out.printf("Decoded file created: %s %n", pathToEncodingFile.getFileName().toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static StringBuilder mvpBrutForce(Path path, int usingAlphabetSize){
        try {
            List<String> dataFromFile = Files.readAllLines(path);
            int counter = 0;
            int lineNumberToRead = dataFromFile.size() > 1 ? 1 : 0;
            while (counter < usingAlphabetSize){
                StringBuilder decodedLineFromFile = CaesarCipher.decoder(counter, dataFromFile.get(lineNumberToRead), alphabetForCipher);
                System.out.printf("Iteration %d of %d%n".concat("Is this text correct?%n"), counter, usingAlphabetSize);
                System.out.println(decodedLineFromFile);
                String chosenOption = evaluateBrutForceResult();
                if(chosenOption.equalsIgnoreCase("1")){
                    break;
                }
                counter++;
            }
            return CaesarCipher.decoder(counter,dataFromFile.toString(), alphabetForCipher);
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
            System.out.println("\nWrong menu item\nTry again\n");
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
