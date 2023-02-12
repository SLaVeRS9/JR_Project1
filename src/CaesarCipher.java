import AlphabetsForCiper.AlphabetForCiper;
import AlphabetsForCiper.CyrillicAlphabetForCipher;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.util.Scanner;

public class CaesarCipher {
    AlphabetForCiper alphabetForCipher;
    //private static int cipherStep; - скорее всего убрать из параметров класса

    private CaesarCipher(){}

    //Sheme for future
    static void encoder(int shift, String pathToEncodingFile){}

    static void encoder(int shift, byte[] encodingData){
        byte[] encodeData = new byte[encodingData.length];
        
        //Перекодировать побитово
        for (int i = 0; i < encodingData.length; i++) {
            char temp = (char) encodingData[i];
            encodeData[i] = encodingData[i];
        }
        for (byte b : encodingData) {
            
        }
        //вернуть массив закодированный
        
        
    } 

    static void decoder(){

    }

    public static void startEncode(){

        //Get path to file
        System.out.println("Enter path to file which you want to encode");
        Scanner input = new Scanner(System.in);
        String inputPath = input.nextLine();
        WorkWithFiles.validatePath(inputPath);

        //Get data from file
        byte[] dataFromFile = WorkWithFiles.readDataFromFile(Path.of(inputPath));
        
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

        //Start encoding
        encoder(cipherStep, dataFromFile);
        
    }

    public static void startDecode(){

    }
}
