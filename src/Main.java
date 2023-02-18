import java.io.BufferedReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        //Menu.startProgram();
        String str = "G:\\MyProjects\\Java\\JR_Project1\\src\\NewTestFile2.txt";
        String str2 = "G:\\MyProjects\\Java\\JR_Project1\\src\\TestFile.txt";
        //StringBuilder stringBuilder = WorkWithFiles.readDataFromFile(str);
        Path path = Path.of(str);
        /*try (RandomAccessFile accessFile = new RandomAccessFile(str, "r");
             FileChannel channel = accessFile.getChannel()) {
            CharBuffer charBuffer = CharBuffer.allocate((int)channel.size());
            Charset charset = StandardCharsets.UTF_8;
            while (true){

            }
        } catch (Exception e) {

        }*/
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            while (bufferedReader.ready()){
                int res = bufferedReader.read();
                System.out.println(res);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
