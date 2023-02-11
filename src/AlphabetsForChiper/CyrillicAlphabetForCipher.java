package AlphabetsForChiper;

import java.util.ArrayList;
import java.util.Collections;

public class CyrillicAlphabetForCipher {
    private static final CyrillicAlphabetForCipher CYRILLIC_ALPHABET_FOR_CIPHER = new CyrillicAlphabetForCipher();
    private static final int START_SYMBOLS_CODE = 32;
    private static final int END_SYMBOLS_CODE = 47;
    private static final int YO_IN_LOWER_CODE = 1105;
    private static final int YO_IN_UPPER_CODE = 1025;
    private static final int START_CYRILLIC_ALPHABET_CODE = 1040;
    private static final int END_CYRILLIC_ALPHABET_CODE = 1103;

    private final ArrayList<Integer> SYMBOLS = new ArrayList<>();
    private final ArrayList<Integer> CYRILLIC_ALPHABET_CODES = new ArrayList<>();
    private final ArrayList<Integer> CYRILLIC_ALPHABET_CODES_AND_SYMBOLS = new ArrayList<>();

    private CyrillicAlphabetForCipher(){
        setSymbolsCodes();
        setCyrillicAlphabetCodes();
    }

    public static CyrillicAlphabetForCipher getInstance(){
        return CYRILLIC_ALPHABET_FOR_CIPHER;
    }

    public ArrayList<Integer> getCyrillicAlphabetCodesAndSymbols(){
        CYRILLIC_ALPHABET_CODES_AND_SYMBOLS.addAll(CYRILLIC_ALPHABET_CODES);
        CYRILLIC_ALPHABET_CODES_AND_SYMBOLS.addAll(SYMBOLS);
        return new ArrayList<>(CYRILLIC_ALPHABET_CODES_AND_SYMBOLS);
    }

    private void setCyrillicAlphabetCodes(){
        CYRILLIC_ALPHABET_CODES.add(YO_IN_UPPER_CODE);
        CYRILLIC_ALPHABET_CODES.add(YO_IN_LOWER_CODE);
        for (int i = START_CYRILLIC_ALPHABET_CODE, j = 0; i <= END_CYRILLIC_ALPHABET_CODE; i++, j++) {
            CYRILLIC_ALPHABET_CODES.add(i);
        }
    }

    private void setSymbolsCodes(){
        for (int i = START_SYMBOLS_CODE; i <= END_SYMBOLS_CODE; i++) {
            SYMBOLS.add(i);
        }
    }

}
