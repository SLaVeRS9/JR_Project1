import AlphabetsForCiper.AlphabetForCiper;
import AlphabetsForCiper.CyrillicAlphabetForCipher;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class CaesarCipher {
    private static AlphabetForCiper alphabetForCipher;
    //private static int cipherStep; - скорее всего убрать из параметров класса

    private CaesarCipher(){}

    static StringBuilder encoder(int shift, String encodingString){
        char[] chars = encodingString.toCharArray();
        StringBuilder newEncodingString = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (alphabetForCipher.getCyrillicAlphabetCodesAndSymbols().contains((int)chars[i])){
                newEncodingString.append((char)encoder(shift, chars[i]));
            } else {
                newEncodingString.append(chars[i]);
            }
        }
        return newEncodingString;
    }

    static int encoder(int shift, int encodingElement){
        //Перекодировать
        int usingAlphabetSize = alphabetForCipher.getCyrillicAlphabetCodesAndSymbols().size();
        int indexEncodingElementInAlphabet = alphabetForCipher.getCyrillicAlphabetCodesAndSymbols().indexOf(encodingElement);
        int newElementIndex = (indexEncodingElementInAlphabet + (shift % usingAlphabetSize)) % usingAlphabetSize;
        int newElement = alphabetForCipher.getCyrillicAlphabetCodesAndSymbols().get(newElementIndex);
        //вернуть перекодированный элемент
        return newElement;
    } 

    static void decoder(){

    }

    public static void startEncode(AlphabetForCiper settedAlphabetForCipher){
        alphabetForCipher = settedAlphabetForCipher;

        //Get path to file
        System.out.println("Enter path to file which you want to encode");
        Scanner input = new Scanner(System.in);
        String inputPath = input.nextLine();
        WorkWithFiles.validatePath(inputPath);
        Path path = Path.of(inputPath);

        //Get shift for encoder
        System.out.println("Enter step to file which you want to encode");

        while(!input.hasNextInt()){
            if (input.nextLine().equalsIgnoreCase("exit")){
                System.exit(0);
            }
            System.out.println("Entered incorrect value (it must be a positive integer)");
            System.out.print("Try again or write 'exit' to quit: ");
        }
        int cipherStep = input.nextInt();

        //Create new file for encoding data
        String fileName = path.getFileName().toString();
        String encodingFileName = "Encoded_".concat(fileName);
        String encodingFileDirectory = path.toFile().getParent();
        Path pathToEncodingFile = Path.of(encodingFileDirectory.concat("\\").concat(encodingFileName));

        try {
            String dataFromFile = Files.readString(path);
            Files.writeString(pathToEncodingFile, encoder(cipherStep, dataFromFile));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Get data from file and sent to encode
        /*try (BufferedReader newBufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
             BufferedWriter newBufferedWriter = Files.newBufferedWriter(pathToEncodingFile, StandardCharsets.UTF_8)) {
            while (newBufferedReader.ready()){
                int inputValue = newBufferedReader.read();
                if (alphabetForCipher.getCyrillicAlphabetCodesAndSymbols().contains(inputValue)){
                    inputValue = encoder(cipherStep, inputValue);
                }
                newBufferedWriter.append((char) inputValue);
                //newBufferedWriter.write(inputValue);
            }
            //CharBuffer charBuffer = CharBuffer.allocate(1024);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        


        //Start encoding
        //encoder(cipherStep, dataFromFile);
        
    }

    public static void startDecode(){

    }
}
