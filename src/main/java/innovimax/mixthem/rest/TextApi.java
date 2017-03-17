package innovimax.mixthem.rest;

import innovimax.mixthem.rest.services.ServiceFactory;
import innovimax.mixthem.rest.services.TextService;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/text")
@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
@Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
public class TextApi  {

    private final TextService service = ServiceFactory.getTextService();

    @POST
    @Path("/add")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    public Response addFromText(
            @FormParam("text1") String text1, 
            @FormParam("text2") String text2) {
        
        return service.addFromText(text1, text2);
    }

    @POST
    @Path("/alt-{type}")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    public Response altFromText(
            @PathParam("type") String type,
            @FormParam("text1") String text1,
            @FormParam("text2") String text2) {
     
        return service.altFromText(type, text1, text2);
    }

    @POST
    @Path("/random-alt")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    public Response randomAltFromText(
        @FormParam("text1") String text1,
        @FormParam("text2") String text2,
        @QueryParam("seed") Integer seed) {
        
        return service.randomAltFromText(text1, text2, seed);
    }

    @POST
    @Path("/join")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    public Response joinFromText(
            @FormParam("text1") String text1, 
            @FormParam("text2") String text2, 
            @QueryParam("col1") Integer col1, 
            @QueryParam("col2") Integer col2) {
        
        return service.joinFromText(text1, text2, col1, col2);
    }

    @POST
    @Path("/zip-{type}")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    public Response zipFromText(
        @PathParam("type") String type,
        @FormParam("text1") String text1,
        @FormParam("text2") String text2,
        @QueryParam("sep") String sep) {
    
        return service.zipFromText(type, text1, text2, sep);
    }
}
