package innovimax.mixthem.rest.services;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

public class FileServiceImpl implements FileService {

    @Override
    public Response addFromFile(InputStream file1InputStream, FormDataContentDisposition file1Detail, InputStream file2InputStream, FormDataContentDisposition file2Detail) {
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    @Override
    public Response altFromFile(String type, InputStream file1InputStream, FormDataContentDisposition file1Detail, InputStream file2InputStream, FormDataContentDisposition file2Detail) {
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    @Override
    public Response randomAltFromFile(InputStream file1InputStream, FormDataContentDisposition file1Detail, InputStream file2InputStream, FormDataContentDisposition file2Detail,  Integer seed) {
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    @Override
    public Response joinFromFile(InputStream file1InputStream, FormDataContentDisposition file1Detail, InputStream file2InputStream, FormDataContentDisposition file2Detail,  Integer col1,  Integer col2) {
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    @Override
    public Response zipFromFile(String type, InputStream file1InputStream, FormDataContentDisposition file1Detail, InputStream file2InputStream, FormDataContentDisposition file2Detail, String sep) {
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }
}
