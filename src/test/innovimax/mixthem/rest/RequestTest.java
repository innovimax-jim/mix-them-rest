package innovimax.mixthem.rest;

import innovimax.mixthem.rest.request.CheckFactory;
import innovimax.mixthem.rest.request.FileParamsCheck;
import innovimax.mixthem.rest.request.TextParamsCheck;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition.FormDataContentDispositionBuilder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RequestTest {

    private int test;
    private TextParamsCheck textCheck;
    private FileParamsCheck fileCheck;
    private FormDataContentDisposition emptyDetail;
    private FormDataContentDisposition filledDetail;

    @Before
    public void setUp() { 
        this.test = 1;
        this.textCheck = CheckFactory.getTextParamsCheck();
        this.fileCheck = CheckFactory.getFileParamsCheck();
        FormDataContentDispositionBuilder builder = FormDataContentDisposition.name("test");
        builder.fileName("");
        this.emptyDetail = builder.build();
        builder.fileName("test.txt");
        this.filledDetail = builder.build();        
    }

    private final boolean incTest(boolean result) {
        this.test++;
        return result;
    }

    @Test
    public final void testTextParamsPass() {        
        boolean result = true;
        result &= incTest(this.textCheck.addFromText("text1", "text2"));
        result &= incTest(this.textCheck.altFromText("char", "text1", "text2"));
        result &= incTest(this.textCheck.altFromText("line", "text1", "text2"));
        result &= incTest(this.textCheck.joinFromText("text1", "text2", null, null));        
        result &= incTest(this.textCheck.zipFromText("char", "text1", "text2", null));
        result &= incTest(this.textCheck.zipFromText("line", "text1", "text2", null));
        result &= incTest(this.textCheck.zipFromText("cell", "text1", "text2", null));
        Assert.assertTrue("Test " + this.test, result);
    }

    @Test
    public final void testTextParamsFail() {
        boolean result = true;
        result &= incTest(this.textCheck.addFromText("", "text2"));
        result &= incTest(this.textCheck.addFromText("text1", ""));
        result &= incTest(this.textCheck.altFromText("char", "", "text2"));
        result &= incTest(this.textCheck.altFromText("char", "text1", ""));
        result &= incTest(this.textCheck.altFromText("none", "text1", "text2"));
        result &= incTest(this.textCheck.randomAltFromText("", "text2", null));
        result &= incTest(this.textCheck.randomAltFromText("text1", "", null));
        result &= incTest(this.textCheck.joinFromText("", "text2", null, null));
        result &= incTest(this.textCheck.joinFromText("text1", "", null, null));
        result &= incTest(this.textCheck.zipFromText("char", "", "text2", null));
        result &= incTest(this.textCheck.zipFromText("char", "text1", "", null));
        result &= incTest(this.textCheck.zipFromText("none", "text1", "text2", null));        
        Assert.assertFalse("Test " + this.test, result);
    }

    @Test
    public final void testFileParamsPass() {        
        boolean result = true;
        result &= incTest(this.fileCheck.addFromFile(null, this.filledDetail, null, this.filledDetail));
        result &= incTest(this.fileCheck.altFromFile("char", null, this.filledDetail, null, this.filledDetail));
        result &= incTest(this.fileCheck.altFromFile("line", null, this.filledDetail, null, this.filledDetail));
        result &= incTest(this.fileCheck.joinFromFile(null, this.filledDetail, null, this.filledDetail, null, null));        
        result &= incTest(this.fileCheck.zipFromFile("char", null, this.filledDetail, null, this.filledDetail, null));
        result &= incTest(this.fileCheck.zipFromFile("line", null, this.filledDetail, null, this.filledDetail, null));
        result &= incTest(this.fileCheck.zipFromFile("cell", null, this.filledDetail, null, this.filledDetail, null));
        Assert.assertTrue("Test " + this.test, result);
    }

    @Test
    public final void testFileParamsFail() {
        boolean result = true;
        result &= incTest(this.fileCheck.addFromFile(null, this.emptyDetail, null, this.filledDetail));
        result &= incTest(this.fileCheck.addFromFile(null, this.filledDetail, null, this.emptyDetail));
        result &= incTest(this.fileCheck.altFromFile("char", null, this.emptyDetail, null, this.filledDetail));
        result &= incTest(this.fileCheck.altFromFile("char", null, this.filledDetail, null, this.emptyDetail));
        result &= incTest(this.fileCheck.altFromFile("none", null, this.filledDetail, null, this.filledDetail));
        result &= incTest(this.fileCheck.randomAltFromFile(null, this.emptyDetail, null, this.filledDetail, null));
        result &= incTest(this.fileCheck.randomAltFromFile(null, this.filledDetail, null, this.emptyDetail, null));
        result &= incTest(this.fileCheck.joinFromFile(null, this.emptyDetail, null, this.filledDetail, null, null));
        result &= incTest(this.fileCheck.joinFromFile(null, this.filledDetail, null, this.emptyDetail, null, null));
        result &= incTest(this.fileCheck.zipFromFile("char", null, this.emptyDetail, null, this.filledDetail, null));
        result &= incTest(this.fileCheck.zipFromFile("char", null, this.filledDetail, null, this.emptyDetail, null));
        result &= incTest(this.fileCheck.zipFromFile("none", null, this.filledDetail, null, this.filledDetail, null));        
        Assert.assertFalse("Test " + this.test, result);
    }

}
