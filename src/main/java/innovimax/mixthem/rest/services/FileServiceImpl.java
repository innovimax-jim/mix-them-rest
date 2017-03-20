package innovimax.mixthem.rest.services;

import innovimax.mixthem.rest.request.CheckFactory;
import innovimax.mixthem.rest.request.FileParamsCheck;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

public class FileServiceImpl implements FileService {

    private final FileParamsCheck check = CheckFactory.getFileParamsCheck();

    @Override
    public Response addFromFile(InputStream file1InputStream, FormDataContentDisposition file1Detail, InputStream file2InputStream, FormDataContentDisposition file2Detail) {
        if (!check.addFromFile(file1InputStream, file1Detail, file2InputStream, file2Detail)) {
            return check.getErrorResponse();        
        } 
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    @Override
    public Response altFromFile(String type, InputStream file1InputStream, FormDataContentDisposition file1Detail, InputStream file2InputStream, FormDataContentDisposition file2Detail) {
        if (!check.altFromFile(type, file1InputStream, file1Detail, file2InputStream, file2Detail)) {
            return check.getErrorResponse();
        } 
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    @Override
    public Response randomAltFromFile(InputStream file1InputStream, FormDataContentDisposition file1Detail, InputStream file2InputStream, FormDataContentDisposition file2Detail,  Integer seed) {
        if (!check.randomAltFromFile(file1InputStream, file1Detail, file2InputStream, file2Detail, seed)) {
            return check.getErrorResponse();
        } 
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    @Override
    public Response joinFromFile(InputStream file1InputStream, FormDataContentDisposition file1Detail, InputStream file2InputStream, FormDataContentDisposition file2Detail,  Integer col1,  Integer col2) {
        if (!check.joinFromFile(file1InputStream, file1Detail, file2InputStream, file2Detail, col1, col2)) {
            return check.getErrorResponse();
        } 
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    @Override
    public Response zipFromFile(String type, InputStream file1InputStream, FormDataContentDisposition file1Detail, InputStream file2InputStream, FormDataContentDisposition file2Detail, String sep) {
        if (!check.zipFromFile(type, file1InputStream, file1Detail, file2InputStream, file2Detail, sep)) {
            return check.getErrorResponse();
        } 
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }
}
