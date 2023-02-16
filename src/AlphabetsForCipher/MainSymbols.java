package AlphabetsForCipher;

import java.util.ArrayList;

public class MainSymbols extends AlphabetForCipherDecorator {
    AlphabetForCipher alphabetForCipher;
    public MainSymbols(AlphabetForCipher alphabetForCipher){
        this.alphabetForCipher = alphabetForCipher;
    }

    @Override
    public ArrayList<Integer> getAlphabetCodesAndSymbols(){
        return alphabetForCipher.getAlphabetCodesAndSymbols();
    }
}
