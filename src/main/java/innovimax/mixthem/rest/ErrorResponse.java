package innovimax.mixthem.rest;

import innovimax.mixthem.rest.request.AlternateMode;
import innovimax.mixthem.rest.request.ZipMode;

import javax.xml.bind.annotation.XmlRootElement;
import javax.ws.rs.core.Response.Status;

@XmlRootElement
public class ErrorResponse {

    private int code;
    private String label;
    private String message;

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ErrorResponse createMissingParamTextError() {        
        return createError(Status.BAD_REQUEST, "Text must no be empty!");        
    }

    public static ErrorResponse createMissingParamFileError() {        
        return createError(Status.BAD_REQUEST, "File must no be empty!");        
    }

    public static ErrorResponse createWrongParamAltModeError() {        
        return createError(Status.BAD_REQUEST, "Alternation mode is not valid. Choose a value in " + AlternateMode.printList());
    }

    public static ErrorResponse createWrongParamZipModeError() {
        return createError(Status.BAD_REQUEST, "Zipping mode not is valid. Choose a value in " + ZipMode.printList());
    }

    private static ErrorResponse createError(Status status, String message) {
        ErrorResponse error = new ErrorResponse();
        error.setCode(status.getStatusCode());
        error.setLabel(status.getReasonPhrase());
        error.setMessage(message);
        return error;
    }

}
