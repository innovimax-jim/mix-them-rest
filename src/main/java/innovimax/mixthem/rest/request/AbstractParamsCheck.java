package innovimax.mixthem.rest.request;

import innovimax.mixthem.Rule;
import innovimax.mixthem.rest.ErrorResponse;

import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

public abstract class AbstractParamsCheck {

    private ErrorResponse error = null;
    private Rule rule = null;

    public Response getErrorResponse() {        
        return Response.status(this.error.getCode()).entity(this.error).build();            
    }

    public Rule getRule() {
        return this.rule;
    }

    private void setRule(Rule rule) {
        this.rule = rule;
    }

    protected boolean checkTextMissing(String text) {
        if (text == null || text.trim().equals("")) {
            this.error = RequestErrorResponse.createMissingParamTextError();
            return false;
        }
        return true;
    }

    protected boolean checkFileMissing(FormDataContentDisposition fileDetail) {     
        if (fileDetail.getFileName().equals("")) {
            this.error = RequestErrorResponse.createMissingParamFileError();
            return false;
        }      
        return true;
    }

    protected boolean checkAlternateMode(String mode) {
        if (!AlternateMode.accept(mode)) {
            this.error = RequestErrorResponse.createWrongParamAltModeError();
            return false;
        }
        return true;
    }

    protected boolean checkZipMode(String mode) {
        if (!ZipMode.accept(mode)) {
            this.error = RequestErrorResponse.createWrongParamZipModeError();
            return false;
        }
        return true;
    }

    protected boolean checkAddRule() {
        setRule(Rule._ADD);
        return true;
    }

    protected boolean checkAlternateRule(String type) {
        switch (AlternateMode.findByName(type)) {
            case _CHAR: 
                setRule(Rule._ALT_CHAR);
                break;
            default:
                setRule(Rule._ALT_LINE);
        }
        return true;
    }

    protected boolean checkRandomAltRule(Integer seed) {
        setRule(Rule._RANDOM_ALT_LINE);
        //TODO set extra param seed
        return true;
    }

    protected boolean checkJoinRule(Integer col1, Integer col2) {
        setRule(Rule._JOIN);
        //TODO set extra params col1 & col2
        return true;
    }

    protected boolean checkZipRule(String type, String sep) {
        /*
        switch (ZipMode.findByName(type)) {
            case _CHAR: 
                setRule(Rule._ZIP_CHAR);
                break;
            case _CELL: 
                setRule(Rule._ZIP_CELL);
                break;                
            default:
                setRule(Rule._ZIP_LINE);
        }
        */
        //TODO set extra param sep
        return true;
    }

}
