package innovimax.mixthem.rest;

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

    protected static ErrorResponse createError(Status status, String message) {
        ErrorResponse error = new ErrorResponse();
        error.setCode(status.getStatusCode());
        error.setLabel(status.getReasonPhrase());
        error.setMessage(message);
        return error;
    }

}
