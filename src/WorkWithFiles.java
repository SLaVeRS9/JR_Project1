import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

class WorkWithFiles {

     static Path getFilePath(){
        Scanner input = new Scanner(System.in);
        String inputPath = input.nextLine();
        WorkWithFiles.validatePath(inputPath);
        Path path = Path.of(inputPath);
        return path;
    }

    static Path createFile(Path path, String operationPrefix){
        String fileName = path.getFileName().toString();
        String decodingFileName = operationPrefix.concat(fileName);
        String decodingFileDirectory = path.toFile().getParent();
        Path pathToEncodingFile = Path.of(decodingFileDirectory.concat("\\").concat(decodingFileName));
        return pathToEncodingFile;
    }


    //TODO Для попытки реализовать частичное чтение файла с последующей отправкой куска на кодировку\декодировку и чтения нового
    public static StringBuilder readDataFromFile(String stringPath){
        StringBuilder dataFromFile = new StringBuilder();
        try (RandomAccessFile accessFile = new RandomAccessFile(stringPath, "r");
             FileChannel channel = accessFile.getChannel()) {
            ByteBuffer byteBuffer = ByteBuffer.allocate((int)channel.size());
            Charset charset = StandardCharsets.UTF_8;
            while (channel.read(byteBuffer) != -1){
                byteBuffer.flip();
                dataFromFile.append(charset.decode(byteBuffer));
                byteBuffer.clear();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dataFromFile;
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
