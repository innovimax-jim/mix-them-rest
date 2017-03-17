package innovimax.mixthem.rest.services;

import java.io.InputStream;

import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

public interface FileService {
    public Response addFromFile(InputStream file1InputStream, FormDataContentDisposition file1Detail,InputStream file2InputStream, FormDataContentDisposition file2Detail);
    public Response altFromFile(String type,InputStream file1InputStream, FormDataContentDisposition file1Detail,InputStream file2InputStream, FormDataContentDisposition file2Detail);
    public Response randomAltFromFile(InputStream file1InputStream, FormDataContentDisposition file1Detail,InputStream file2InputStream, FormDataContentDisposition file2Detail, Integer seed);
    public Response joinFromFile(InputStream file1InputStream, FormDataContentDisposition file1Detail,InputStream file2InputStream, FormDataContentDisposition file2Detail, Integer col1, Integer col2);    
    public Response zipFromFile(String type,InputStream file1InputStream, FormDataContentDisposition file1Detail,InputStream file2InputStream, FormDataContentDisposition file2Detail, String sep);
}
