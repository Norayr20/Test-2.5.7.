package ForTest;

public class Main {
    private static String[] spamWords = {"shit", "ass", "fuck"};
    private static int maxLength = 200;

    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer analyzer : analyzers) {
            if(analyzer.processText(text) != Label.OK){
                return analyzer.processText(text);
            }
        }
        return Label.OK;
    }

    public static void main(String[] args) {
        String text = "woxmqomxfukuck:(";
        TextAnalyzer[] textAnalyzers = {
                new ForTest.SpamAnalyzer(spamWords),
                new ForTest.NegativeTextAnalyzer(),
                new ForTest.TooLongTextAnalyzer(maxLength),
        };
        System.out.println(checkLabels(textAnalyzers,text));
    }
}