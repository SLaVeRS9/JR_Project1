import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

class WorkWithFiles {

     static Path getFilePath(){
        Scanner input = new Scanner(System.in);
        String inputPath = input.nextLine();
        WorkWithFiles.validatePath(inputPath);
        Path path = Path.of(inputPath);
        return path;
    }

    static Path createFile(String createdFileName){

    }

    //TODO Создать собственное исключение для работы с файлами
    //TODO ределиться с архитектурой этого решения
    private static byte[] readDataFromFile(String stringPath){
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
                System.out.println(charset.decode(byteBuffer));
                byteBuffer.clear();
            }
            System.out.println(charBuffer.length());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new byte[0];
    }

    //TODO Создать собственное исключение для работы с файлами
    static void validatePath(Path path){
            path.isAbsolute();
    }

    //TODO Создать собственное исключение для работы с файлами
    static void validatePath(String stringPath){
        Path path = Path.of(stringPath);
        path.isAbsolute();
}



}
