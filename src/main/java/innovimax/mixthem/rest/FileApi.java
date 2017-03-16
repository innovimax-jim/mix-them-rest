package innovimax.mixthem.rest;

import java.io.InputStream;

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

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/file")
@Consumes({MediaType.MULTIPART_FORM_DATA})
@Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
public class FileApi  {

    @POST
    @Path("/add")
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    public Response addFromFile(
            @FormDataParam("file1") InputStream file1InputStream,
            @FormDataParam("file1") FormDataContentDisposition file1Detail,
            @FormDataParam("file2") InputStream file2InputStream,
            @FormDataParam("file2") FormDataContentDisposition file2Detail) {
        //TODO
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    @POST
    @Path("/alt-{type}")
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    public Response altFromFile(
            @PathParam("type") String type,
            @FormDataParam("file1") InputStream file1InputStream,
            @FormDataParam("file1") FormDataContentDisposition file1Detail,
            @FormDataParam("file2") InputStream file2InputStream,
            @FormDataParam("file2") FormDataContentDisposition file2Detail) {
        //TODO
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }
    
    @POST
    @Path("/join")
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    public Response joinFromFile(
            @FormDataParam("file1") InputStream file1InputStream,
            @FormDataParam("file1") FormDataContentDisposition file1Detail,
            @FormDataParam("file2") InputStream file2InputStream,
            @FormDataParam("file2") FormDataContentDisposition file2Detail,
            @QueryParam("col1") Integer col1,
            @QueryParam("col2") Integer col2) {
        //TODO
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }
    
    @POST
    @Path("/random-alt")
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    public Response randomAltFromFile(
            @FormDataParam("file1") InputStream file1InputStream,
            @FormDataParam("file1") FormDataContentDisposition file1Detail,
            @FormDataParam("file2") InputStream file2InputStream,
            @FormDataParam("file2") FormDataContentDisposition file2Detail,
            @QueryParam("seed") Integer seed) {
        //TODO
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }
    
    @POST
    @Path("/zip-{type}")
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    public Response zipFromFile(
            @PathParam("type") String type,
            @FormDataParam("file1") InputStream file1InputStream,
            @FormDataParam("file1") FormDataContentDisposition file1Detail,
            @FormDataParam("file2") InputStream file2InputStream,
            @FormDataParam("file2") FormDataContentDisposition file2Detail,
            @QueryParam("sep") String sep) {
        //TODO
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }

}
