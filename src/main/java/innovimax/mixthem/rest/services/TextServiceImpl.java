package innovimax.mixthem.rest.services;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class TextServiceImpl implements TextService {

    @Override
    public Response addFromText(String text1, String text2) {
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    @Override
    public Response altFromText(String type, String text1, String text2) {
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    @Override
    public Response randomAltFromText(String text1, String text2, Integer seed) {
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    @Override
    public Response joinFromText(String text1, String text2, Integer col1, Integer col2) {
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    @Override
    public Response zipFromText(String type, String text1, String text2, String sep) {
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }
}
