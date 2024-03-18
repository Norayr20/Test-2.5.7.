public class Main {
    public static void main(String[] args) {
        String[] spamKeywords = {"spam", "advertisement"};
        SpamAnalyzer spamAnalyzer = new SpamAnalyzer(spamKeywords);

        NegativeTextAnalyzer negativeTextAnalyzer = new NegativeTextAnalyzer();

        TooLongTextAnalyzer tooLongTextAnalyzer = new TooLongTextAnalyzer(10);

        TextAnalyzer[] analyzers = {spamAnalyzer, negativeTextAnalyzer, tooLongTextAnalyzer};

        String testText = "This is a test text :(";

        Label overallLabel = tooLongTextAnalyzer.checkLabels(analyzers, testText);
        System.out.println("Overall label for the text: " + overallLabel);
    }
}