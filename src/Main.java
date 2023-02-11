import AlphabetsForChiper.CyrillicAlphabetForCipher;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CyrillicAlphabetForCipher cyrillicAlphabetForCipher = CyrillicAlphabetForCipher.getInstance();
        ArrayList<Integer> integers = cyrillicAlphabetForCipher.getCyrillicAlphabetCodesAndSymbols();
        System.out.println(integers);
        int size = integers.size();
        System.out.println(integers.get(0));
        System.out.println(integers.get(0)+1);
        integers.set(0, 10);
        System.out.println(integers.get(0));
        /*Character[] chars = {'А', 'Б', 'а', 'б', 122};
        char[] chars2 = {'А', 'Б', 'а', 'б', 122};
        char res = 1041;
        char A = 'А';
        char a = 'а';
        int res2 = String.valueOf(a).getBytes()[0];
        int res3 = a;
        System.out.println((int)a);
        System.out.println((int)A);
        System.out.println(res);*/

    }
}
