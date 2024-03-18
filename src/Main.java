public class Main {
    public static void main(String[] args) {
        String[] spamKeywords = {"spam", "buy", "sale"};
        SpamAnalyzer spamAnalyzer = new SpamAnalyzer(spamKeywords);

        TooLongTextAnalyzer tooLongAnalyzer = new TooLongTextAnalyzer(100);

        String text1 = "This is a spam message";
        String text2 = "Check out our latest sale!";
        String text3 = "This is a normal message with normal length";

        System.out.println("Text 1: " + spamAnalyzer.processText(text1));
        System.out.println("Text 2: " + spamAnalyzer.processText(text2));
        System.out.println("Text 3: " + spamAnalyzer.processText(text3));

        System.out.println("Text 1: " + tooLongAnalyzer.processText(text1));
        System.out.println("Text 2: " + tooLongAnalyzer.processText(text2));
        System.out.println("Text 3: " + tooLongAnalyzer.processText(text3));
    }
}