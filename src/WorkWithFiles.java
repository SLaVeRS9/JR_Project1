import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Arrays;

public class WorkWithFiles {
    
    //TODO Создать собственное исключение для работы с файлами
    public static byte[] readDataFromFile(String stringPath){
        try {
            RandomAccessFile accessFile = new RandomAccessFile(stringPath, "r");
            FileChannel channel = accessFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(2);
            int noOfBytesRead = channel.read(byteBuffer);
            CharBuffer charBuffer = CharBuffer.allocate(100);
            Charset charset = StandardCharsets.UTF_8;
            while (channel.read(byteBuffer) != -1){
                //channel.read(byteBuffer);
                System.out.println("Number of bytes read: " + noOfBytesRead);
                System.out.println("In arr" + Arrays.toString(byteBuffer.array()));
                byteBuffer.flip();
                //charBuffer.put(byteBuffer.asCharBuffer().array());
                System.out.println(charset.decode(byteBuffer));
                byteBuffer.clear();
            }
            System.out.println(charBuffer.length());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new byte[0];

        /*BufferedWriter newBufferedWriter = Files.newBufferedWriter(pathToEncodingFile, StandardCharsets.UTF_8)) {
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

    //TODO Создать собственное исключение для работы с файлами
    public static void validatePath(Path path){
            path.isAbsolute();
    }

    //TODO Создать собственное исключение для работы с файлами
    public static void validatePath(String stringPath){
        Path path = Path.of(stringPath);
        path.isAbsolute();
}



}
