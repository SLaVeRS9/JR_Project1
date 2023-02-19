package AlphabetsForCipher;
import java.util.ArrayList;
import java.util.List;

public class CyrillicAlphabet extends Alphabet {
    private static final CyrillicAlphabet CYRILLIC_ALPHABET_FOR_CIPHER = new CyrillicAlphabet();
    private static final int YO_IN_LOWER_CODE = 1105;
    private static final int YO_IN_UPPER_CODE = 1025;
    private static final int START_CYRILLIC_ALPHABET_CODE = 1040;
    private static final int END_CYRILLIC_ALPHABET_CODE = 1103;
    private final List<Integer> cyrillicAlphabetCodes = new ArrayList<>();
    private final List<Integer> immutableCyrillicAlphabetCodes;

    //Fill cyrillicAlphabetCodes and create immutableCyrillicAlphabetCodes
    private CyrillicAlphabet(){
        setCyrillicAlphabetCodes();
        immutableCyrillicAlphabetCodes = List.copyOf(cyrillicAlphabetCodes);
    }
    //Create one object instance of cyrillic alphabet
    public static CyrillicAlphabet getInstance(){
        return CYRILLIC_ALPHABET_FOR_CIPHER;
    }

    //Get immutable cyrillic alphabet codes
    public List<Integer> getAlphabetCodes(){
        return immutableCyrillicAlphabetCodes;
    }

    //Fill in cyrillic alphabet codes
    private void setCyrillicAlphabetCodes(){
        cyrillicAlphabetCodes.add(YO_IN_UPPER_CODE);
        cyrillicAlphabetCodes.add(YO_IN_LOWER_CODE);
        for (int i = START_CYRILLIC_ALPHABET_CODE; i <= END_CYRILLIC_ALPHABET_CODE; i++) {
            cyrillicAlphabetCodes.add(i);
        }
    }
}
