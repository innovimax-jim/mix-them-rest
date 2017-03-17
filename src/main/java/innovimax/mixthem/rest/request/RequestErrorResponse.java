package innovimax.mixthem.rest.request;

import innovimax.mixthem.rest.ErrorResponse;

import javax.ws.rs.core.Response.Status;

public class RequestErrorResponse extends ErrorResponse {

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

}
