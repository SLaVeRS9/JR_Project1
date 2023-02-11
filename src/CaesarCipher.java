import AlphabetsForCiper.AlphabetForCiper;
import AlphabetsForCiper.CyrillicAlphabetForCipher;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class CaesarCipher {
    AlphabetForCiper alphabetForCipher;
    private static int shift;

    private CaesarCipher(){}

    static void encoder(int shift, String pathToEncodingFile){
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(pathToEncodingFile, "r");
                FileChannel channel = randomAccessFile.getChannel()) {
            Path path = Path.of(pathToEncodingFile);
            path.getFileName();
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
            channel.read(byteBuffer);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CyrillicAlphabetForCipher cyrillicAlphabetForCipher = CyrillicAlphabetForCipher.getInstance();
    }
    static void decoder(){

    }

    public static void startEncode(){
        System.out.println("Enter a file which you want to encode");
    }

    public static void startDecode(){

    }
}
