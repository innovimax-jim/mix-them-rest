package innovimax.mixthem.rest;

import innovimax.mixthem.rest.services.ServiceFactory;
import innovimax.mixthem.rest.services.FileService;

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

    private final FileService service = ServiceFactory.getFileService();

    @POST
    @Path("/add")
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    public Response addFromFile(
            @FormDataParam("file1") InputStream file1InputStream,
            @FormDataParam("file1") FormDataContentDisposition file1Detail,
            @FormDataParam("file2") InputStream file2InputStream,
            @FormDataParam("file2") FormDataContentDisposition file2Detail) {

        return service.addFromFile(file1InputStream, file1Detail, file2InputStream, file2Detail);
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
     
        return service.altFromFile(type, file1InputStream, file1Detail, file2InputStream, file2Detail);
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
        
        return service.randomAltFromFile(file1InputStream, file1Detail, file2InputStream, file2Detail, seed);
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
        
        return service.joinFromFile(file1InputStream, file1Detail, file2InputStream, file2Detail, col1, col2);
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
        
        return service.zipFromFile(type, file1InputStream, file1Detail, file2InputStream, file2Detail, sep);
    }

}
