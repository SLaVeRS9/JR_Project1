class HackAnalyzer {
    private static final String HACK_PATTERN_1 = ". ";
    private static final String HACK_PATTERN_2 = ", ";
    private static final String HACK_PATTERN_3 = "\\w\\.\\w";
    private static final String HACK_PATTERN_4 = "\\.\\w\\.";


    //return -1 if there are no matches
    //return 0 if there is one match
    //return 1 if there are more than one matches
    static int analyzeForComplianceWithTheMainPatterns(StringBuilder analyzedText){
        return analyzeForFirstPattern(analyzedText);
    }

    //return -1 if there are no matches
    //return 0 if there is one match
    //return 1 if there are more than one matches
    private static int analyzeForFirstPattern(StringBuilder analyzedText){
        int count = -1;
        String stringAnalyzedText = analyzedText.toString();
        if (stringAnalyzedText.contains(HACK_PATTERN_1) && !stringAnalyzedText.matches(HACK_PATTERN_3)
                && !stringAnalyzedText.matches(HACK_PATTERN_4)) {
            count++;
        }
        if (stringAnalyzedText.toString().contains(HACK_PATTERN_2) && !stringAnalyzedText.matches(HACK_PATTERN_3)
                && !stringAnalyzedText.matches(HACK_PATTERN_4)){
            count++;
        }
        return count;
    }
}
