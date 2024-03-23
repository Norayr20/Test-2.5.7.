package ForTest;

abstract public class KeywordAnalyzer implements TextAnalyzer {
    public Label processText(String text) {
        StringBuilder stringBuilder = new StringBuilder(text);
        TextAnalyzer[] textAnalyzers = {new NegativeTextAnalyzer(), new SpamAnalyzer(getKeywords())};
        for (int i = 0; i < textAnalyzers.length; i++) {
            for (String spam : getKeywords()) {
                if (stringBuilder.indexOf(spam) != -1) {
                    return getLabel();
                }
            }
        }
        return Label.OK;
    }
    abstract protected Label getLabel();
    abstract protected String[] getKeywords();
}