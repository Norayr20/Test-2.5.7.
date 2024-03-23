package ForTest;

public class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxLength;
    public TooLongTextAnalyzer(int maxLength){
        this.maxLength = maxLength;
    }
    public Label processText(String text){
        StringBuilder stringBuilder = new StringBuilder(text);
        for (int i = 0; i < text.length(); i++) {
            if(stringBuilder.substring(i) == " "){
                stringBuilder.deleteCharAt(i);
            }
        }
        if(stringBuilder.length() > maxLength){
            return Label.TOO_LONG;
        }
        return Label.OK;
    }
}