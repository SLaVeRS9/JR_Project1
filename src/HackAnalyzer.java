class HackAnalyzer {
    private static final String HACK_PATTERN_1 = ". ";
    private static final String HACK_PATTERN_2 = ", ";

    //return -1 if there are no matches
    //return 0 if there is one match
    //return 1 if there are more than one matches
    static int analyzeForComplianceWithTheMainPatterns(StringBuilder analyzedText){
        int count = -1;
        count = analyzeForFirstPattern(analyzedText);
        return count;
    }

    //return -1 if there are no matches
    //return 0 if there is one match
    //return 1 if there are more than one matches
    private static int analyzeForFirstPattern(StringBuilder analyzedText){
        int count = -1;
        if (analyzedText.toString().contains(HACK_PATTERN_1)) {
            count++;
        }
        if (analyzedText.toString().matches(HACK_PATTERN_2)){
            count++;
        }
        return count;
    }
}
