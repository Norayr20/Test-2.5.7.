package ForTest;

public class NegativeTextAnalyzer extends KeywordAnalyzer{
    private final String[] keywords = {":(",":|","=("};
    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
    @Override
    protected String[] getKeywords(){
        return keywords;
    }
}