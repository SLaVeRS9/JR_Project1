import java.nio.file.Files;
import java.nio.file.Path;

public class WorkWithFiles {
    
    //TODO ������� ����������� ���������� ��� ������ � �������
    public static byte[] readDataFromFile(Path path){
        validatePath(path);
        byte[] data = Files.readAllBytes(path);
        return data;
    }

    //TODO ������� ����������� ���������� ��� ������ � �������
    public static void validatePath(Path path){
            path.isAbsolute();
    }

    //TODO ������� ����������� ���������� ��� ������ � �������
    public static void validatePath(String stringPath){
        Path path = Path.of(stringPath);
        path.isAbsolute();
}



}
