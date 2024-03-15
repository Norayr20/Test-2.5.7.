public class Main {
    public static void main(String[] args) {
            String[] spamKeywords = {"spam", "buy now", "click here"};
            SpamAnalyzer spamAnalyzer = new SpamAnalyzer(spamKeywords);

            NegativeTextAnalyzer negativeTextAnalyzer = new NegativeTextAnalyzer();

            TooLongTextAnalyzer tooLongTextAnalyzer = new TooLongTextAnalyzer(50);

            String text1 = "This is a great product!";
            String text2 = "Buy now and get 50% off!";
            String text3 = "I'm feeling 😦 today.";
            String text4 = "This comment is way too long, it should be shortened.";

            System.out.println("Text 1: " + spamAnalyzer.processText(text1));
            System.out.println("Text 2: " + spamAnalyzer.processText(text2));
            System.out.println("Text 3: " + negativeTextAnalyzer.processText(text3));
            System.out.println("Text 4: " + tooLongTextAnalyzer.processText(text4));
        }
    }
