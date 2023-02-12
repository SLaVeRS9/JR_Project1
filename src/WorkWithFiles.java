import java.nio.file.Files;
import java.nio.file.Path;

public class WorkWithFiles {
    
    //TODO Создать собственное исключение для работы с файлами
    public static byte[] readDataFromFile(Path path){
        validatePath(path);
        Files.newInputStream(path)
        byte[] data = Files.readAllBytes(path);
        return data;
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
