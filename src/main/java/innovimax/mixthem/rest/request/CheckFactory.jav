package innovimax.mixthem.rest.request;

public class CheckFactory {

    private final static TextParamsCheck textCheck = new TextParamsCheck();
    private final static FileParamsCheck fileCheck = new FileParamsCheck();

    public static TextParamsCheck getTextParamsCheck() {
        return textCheck;
    }

	public static FileParamsCheck getFileParamsCheck() {
        return fileCheck;
    }

}
