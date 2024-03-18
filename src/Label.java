import java.awt.*;

abstract class KeywordAnalyzer implements TextAnalyzer {
    abstract protected String[] getKeywords();

    abstract protected Label getLabel();

    public Label processText(String text) {
        String[] keywords = getKeywords();
        for (int i = 0; i < keywords.length; i++) {
            if (text.indexOf(keywords[i]) != -1) {
                return getLabel();
            }
        }
        return Label.OK;
    }
}

class SpamAnalyzer extends KeywordAnalyzer {
    private String[] keywords;
    private Label label = Label.SPAM;

    public SpamAnalyzer(String[] keywords) {
        this.keywords = keywords;
    }

    protected String[] getKeywords() {
        return keywords;
    }

    protected Label getLabel() {
        return label;
    }
}

class NegativeTextAnalyzer extends KeywordAnalyzer {
    private String[] keywords = {":(", "=(", ":|"};
    private Label label = Label.NEGATIVE_TEXT;

    protected String[] getKeywords() {
        return keywords;
    }

    protected Label getLabel() {
        return label;
    }
}

class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxLength;

    public TooLongTextAnalyzer(int length) {
        this.maxLength = length;
    }

    public Label processText(String text) {
        return text.length() > maxLength ? Label.TOO_LONG : Label.OK;
    }

    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer anal : analyzers) {
            Label result;
            if ((result = anal.processText(text)) != Label.OK) {
                return result;
            }
        }
        return Label.OK;
    }
}
