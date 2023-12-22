import java.util.Arrays;

public abstract class KeywordAnalyzer implements TextAnalyzer {
    protected abstract String[] getKeywords();
    protected abstract Label getLabel();

    @Override
    public Label processText(String text) {
        for (String keyword : getKeywords()) {
            if (text.contains(keyword)) {
                return getLabel();
            }
        }
        return Label.OK;
    }
}

public class SpamAnalyzer extends KeywordAnalyzer {
    private String[] keywords;

    public SpamAnalyzer(String[] keywords) {
        this.keywords = keywords;
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.SPAM;
    }
}

public class NegativeTextAnalyzer extends KeywordAnalyzer {
    private static final String[] NEGATIVE_KEYWORDS = {":(", "=(", ":|"};

    @Override
    protected String[] getKeywords() {
        return NEGATIVE_KEYWORDS;
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}

public class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxLength;

    public TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public Label processText(String text) {
        if (text.length() > maxLength) {
            return Label.TOO_LONG;
        } else {
            return Label.OK;
        }
    }
}

public class Main {
    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer analyzer : analyzers) {
            Label label = analyzer.processText(text);
            if (label != Label.OK) {
                return label;
            }
        }
        return Label.OK;
    }

    public static void main(String[] args) {
        TextAnalyzer[] analyzers = {new SpamAnalyzer(new String[]{"spam", "bad"}),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(10)};
        String text = "This is a good text with no spam and it's not too long";
        System.out.println(checkLabels(analyzers, text));
    }
}