import AlphabetsForCiper.CyrillicAlphabetForCipher;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*CyrillicAlphabetForCipher cyrillicAlphabetForCipher = CyrillicAlphabetForCipher.getInstance();
        ArrayList<Integer> integers = cyrillicAlphabetForCipher.getCyrillicAlphabetCodesAndSymbols();
        System.out.println(integers);
        int size = integers.size();
        System.out.println(integers.get(0));
        System.out.println(integers.get(0)+1);
        integers.set(0, 10);
        System.out.println(integers.get(0));*/

        System.out.println();

        Character[] chars = {'А', 'Б', 'а', 'б', 122};
        char[] chars2 = {'А', 'Б', 'а', 'б', 122};
        char res = 1041;
        char A = 'А';
        char a = 'а';
        int res2 = String.valueOf(a).getBytes()[0];
        int res3 = a;
        System.out.println((int)a);
        System.out.println((int)A);
        System.out.println(res);

        /*Scanner input = new Scanner(System.in);
        Path path = Path.of(input.nextLine());
        System.out.println(path.getFileName());*/

        /*Scanner input = new Scanner(System.in);

        while (!input.hasNextInt() || input.nextInt() > 4 || input.nextInt() < 0){
            System.out.println("Wrong menu item");
            input.nextLine();
            System.out.println("Write 'exit' or 'e' if you want to exit");
            if (input.next().equalsIgnoreCase("exit") || input.next().equalsIgnoreCase("e")){
                System.exit(0);
            }
        }*/

        /*try () {

            System.out.println(path.getFileName());



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        Menu.menu();
    }
}
