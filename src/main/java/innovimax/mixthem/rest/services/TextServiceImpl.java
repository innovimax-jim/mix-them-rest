package innovimax.mixthem.rest.services;

import innovimax.mixthem.Rule;
import innovimax.mixthem.rest.request.CheckFactory;
import innovimax.mixthem.rest.request.TextParamsCheck;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class TextServiceImpl extends AbstractServiceImpl implements TextService {

    private final TextParamsCheck check = CheckFactory.getTextParamsCheck();

    @Override
    public Response addFromText(String text1, String text2) {
        if (!check.addFromText(text1, text2)) {
            return check.getErrorResponse();
        }   
        return getStreamResponse(check.getRule(), text1, text2);
    }

    @Override
    public Response altFromText(String type, String text1, String text2) {
        if (!check.altFromText(type, text1, text2)) {
            return check.getErrorResponse();        
        } 
        return getStreamResponse(check.getRule(), text1, text2);
    }

    @Override
    public Response randomAltFromText(String text1, String text2, Integer seed) {
        if (!check.randomAltFromText(text1, text2, seed)) {
            return check.getErrorResponse();
        } 
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    @Override
    public Response joinFromText(String text1, String text2, Integer col1, Integer col2) {
        if (!check.joinFromText(text1, text2, col1, col2)) {
            return check.getErrorResponse();
        } 
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    @Override
    public Response zipFromText(String type, String text1, String text2, String sep) {
        if (!check.zipFromText(type, text1, text2, sep)) {
            return check.getErrorResponse();
        } 
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }
}
