package innovimax.mixthem.rest.request;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

public class FileParamsCheck extends AbstractParamsCheck {

    public boolean addFromFile(InputStream file1InputStream, FormDataContentDisposition file1Detail, InputStream file2InputStream, FormDataContentDisposition file2Detail) {
        if (checkFileMissing(file1Detail) && checkFileMissing(file2Detail) && checkAddRule()) {
            return true;        
        }
        return false;
    }

    public boolean altFromFile(String type, InputStream file1InputStream, FormDataContentDisposition file1Detail, InputStream file2InputStream, FormDataContentDisposition file2Detail) {
        if (checkAlternateMode(type) && checkFileMissing(file1Detail) && checkFileMissing(file2Detail) && checkAlternateRule(type)) {
            return true;        
        }
        return false;
    }

    public boolean randomAltFromFile(InputStream file1InputStream, FormDataContentDisposition file1Detail, InputStream file2InputStream, FormDataContentDisposition file2Detail,  Integer seed) {
        if (checkFileMissing(file1Detail) && checkFileMissing(file2Detail) && checkRandomAltRule(seed)) {
            return true;        
        }
        return false;
    }

    public boolean joinFromFile(InputStream file1InputStream, FormDataContentDisposition file1Detail, InputStream file2InputStream, FormDataContentDisposition file2Detail,  Integer col1,  Integer col2) {
        if (checkFileMissing(file1Detail) && checkFileMissing(file2Detail) && checkJoinRule(col1, col2)) {
            return true;
        }
        return false;
    }

    public boolean zipFromFile(String type, InputStream file1InputStream, FormDataContentDisposition file1Detail, InputStream file2InputStream, FormDataContentDisposition file2Detail, String sep) {
        if (checkZipMode(type) && checkFileMissing(file1Detail) && checkFileMissing(file2Detail) && checkZipRule(type, sep)) {
            return true;
        }
        return false;
    }
}
