import AlphabetsForCipher.Alphabet;
import java.io.*;
import java.nio.charset.CharacterCodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

class CaesarCipher {
    private static Alphabet alphabet;

    private CaesarCipher(){}

    //General encode method
    public static void startEncode(Alphabet settedAlphabet){
        alphabet = settedAlphabet;

        System.out.println("Enter path to file which you want to encode");
        Path path = WorkWithFiles.getFilePath();

        //Get shift for encoder
        System.out.println("Enter step to file which you want to encode");
        int cipherStep = getShiftToEncodeOrDecode();

        //Create new file for encoding data
        Path pathToEncodingFile = WorkWithFiles.createFile(path, "Encoded_");

        try {
            String dataFromFile = Files.readString(path);
            Files.writeString(pathToEncodingFile, encoder(cipherStep, dataFromFile));
            System.out.println("File has been encoded: ".concat(pathToEncodingFile.getFileName().toString()));
        } catch (CharacterCodingException e) {
            throw new RuntimeException("Check that the coding file in encoding UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //General decode method
    public static void startDecode(Alphabet settedAlphabet){
        alphabet = settedAlphabet;
        System.out.println("Enter path to file which you want to decode");
        Path path = WorkWithFiles.getFilePath();

        //Get shift for decoder
        System.out.println("Enter step which file has been encoded");
        int cipherStep = getShiftToEncodeOrDecode();

        //Create new file for encoding data
        Path pathToDecodingFile = WorkWithFiles.createFile(path, "Decoded_");

        try {
            String dataFromFile = Files.readString(path);
            Files.writeString(pathToDecodingFile, decoder(cipherStep, dataFromFile));
            System.out.println("File has been decoded with name: ".concat(pathToDecodingFile.getFileName().toString()));
        } catch (CharacterCodingException e) {
            throw new RuntimeException("Check that the coding file in encoding UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Encode data in String format
    static StringBuilder encoder(int shift, String encodingString){
        char[] chars = encodingString.toCharArray();
        StringBuilder newEncodingString = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (alphabet.getAlphabetCodes().contains((int)chars[i])){
                newEncodingString.append((char)encoder(shift, chars[i]));
            } else {
                newEncodingString.append(chars[i]);
            }
        }
        return newEncodingString;
    }

    //Encode int-char element format
    static int encoder(int shift, int encodingElement){

        int usingAlphabetSize = alphabet.getAlphabetCodes().size();
        int indexEncodingElementInAlphabet = alphabet.getAlphabetCodes().indexOf(encodingElement);
        int newElementIndex = (indexEncodingElementInAlphabet + (shift % usingAlphabetSize)) % usingAlphabetSize;
        int newElement = alphabet.getAlphabetCodes().get(newElementIndex);
        return newElement;
    } 

    private static StringBuilder decoder(int shift, String decodingString){
        char[] chars = decodingString.toCharArray();
        StringBuilder newEncodingString = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (alphabet.getAlphabetCodes().contains((int)chars[i])){
                newEncodingString.append((char)decoder(shift, chars[i]));
            } else {
                newEncodingString.append(chars[i]);
            }
        }
        return newEncodingString;
    }

    protected static StringBuilder decoder(int shift, String decodingString, Alphabet alphabet){
        CaesarCipher.alphabet = alphabet;
        return decoder(shift,decodingString);
    }

    private static int decoder(int shift, int encodingElement){
        int usingAlphabetSize = alphabet.getAlphabetCodes().size();
        int indexEncodingElementInAlphabet = alphabet.getAlphabetCodes().indexOf(encodingElement);
        int newElementIndex = ((indexEncodingElementInAlphabet + usingAlphabetSize) - (shift % usingAlphabetSize)) % usingAlphabetSize;
        int newElement = alphabet.getAlphabetCodes().get(newElementIndex);
        return newElement;
    }

    //TODO Add custom exception (>0)
    private static int getShiftToEncodeOrDecode(){
        Scanner input = new Scanner(System.in);
        while(!input.hasNextInt()){
            if (input.nextLine().equalsIgnoreCase("exit")){
                System.exit(0);
            }
            System.out.println("Entered incorrect value (it must be a positive integer)\n" +
                    "Try again or write 'exit' to quit: ");
        }
        int cipherStep = input.nextInt();
        return cipherStep;
    }
}
