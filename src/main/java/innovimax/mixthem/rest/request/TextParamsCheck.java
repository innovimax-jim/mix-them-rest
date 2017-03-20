package innovimax.mixthem.rest.request;

public class TextParamsCheck extends AbstractParamsCheck {

    public boolean addFromText(String text1, String text2) {
        if (checkTextMissing(text1) && checkTextMissing(text2)) {
            return true;
        }
        return false;
    }

    public boolean altFromText(String type, String text1, String text2) {
        if (checkAlternateMode(type) && checkTextMissing(text1) && checkTextMissing(text2)) {
            return true;
        }
        return false;
    }

    public boolean randomAltFromText(String text1, String text2, Integer seed) {
        if (checkTextMissing(text1) && checkTextMissing(text2)) {
            return true;
        }
        return false;
    }

    public boolean joinFromText(String text1, String text2, Integer col1, Integer col2) {
        if (checkTextMissing(text1) && checkTextMissing(text2)) {
            return true;
        }
        return false;
    }

    public boolean zipFromText(String type, String text1, String text2, String sep) {
        if (checkZipMode(type) && checkTextMissing(text1) && checkTextMissing(text2)) {
            return true;
        }
        return false;
    }
}
