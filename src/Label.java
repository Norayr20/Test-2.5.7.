import java.util.Arrays;

public enum Label {
    SPAM, NEGATIVE_TEXT, TOO_LONG, OK
}

interface TextAnalyzer {
    Label processText(String text);
}

class SpamAnalyzer implements TextAnalyzer {
    private String[] keywords;

    public SpamAnalyzer(String[] keywords) {
        this.keywords = keywords;
    }

    @Override
    public Label processText(String text) {
        for (String keyword : keywords) {
            if (text.contains(keyword)) {
                return Label.SPAM;
            }
        }
        return Label.OK;
    }
}

class NegativeTextAnalyzer implements TextAnalyzer {
    @Override
    public Label processText(String text) {
        if (text.contains("😦") || text.contains("😔") || text.contains(":|")) {
            return Label.NEGATIVE_TEXT;
        }
        return Label.OK;
    }
}

class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxLength;

    public TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public Label processText(String text) {
        if (text.length() > maxLength) {
            return Label.TOO_LONG;
        }
        return Label.OK;
    }
}
