package innovimax.mixthem.rest.services;

import innovimax.mixthem.rest.ErrorResponse;

import javax.ws.rs.core.Response.Status;

public class ServiceErrorResponse extends ErrorResponse {

    public static ErrorResponse createMixingError(String message) {        
        return createError(Status.INTERNAL_SERVER_ERROR, message);        
    }

}
