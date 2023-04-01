package AlphabetsForCipher;
import java.util.ArrayList;
import java.util.List;

public class MainSymbols extends AlphabetDecorator {
    private static final int START_SYMBOLS_CODE = 32;
    private static final int END_SYMBOLS_CODE = 47;
    private final List<Integer> symbols = new ArrayList<>();
    private final List<Integer> immutableAlphabetWithSymbols;
    private Alphabet alphabet;
    public MainSymbols(Alphabet alphabet){
        setSymbolsCodes();
        this.alphabet = alphabet;
        List<Integer> alphabetWithSymbols = new ArrayList<>();
        alphabetWithSymbols.addAll(this.alphabet.getAlphabetCodes());
        alphabetWithSymbols.addAll(symbols);
        immutableAlphabetWithSymbols = List.copyOf(alphabetWithSymbols);
    }

    //Get immutable alphabet plus symbols codes
    @Override
    public List<Integer> getAlphabetCodes(){
        return immutableAlphabetWithSymbols;
    }

    //Fill in general symbols codes
    private void setSymbolsCodes(){
        for (int i = START_SYMBOLS_CODE; i <= END_SYMBOLS_CODE; i++) {
            symbols.add(i);
        }
    }
}
