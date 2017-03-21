package innovimax.mixthem.rest.services;

import innovimax.mixthem.MixException;
import innovimax.mixthem.Rule;
import innovimax.mixthem.rest.ErrorResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

public class ServiceOutput implements StreamingOutput {

    final Rule rule;
    final Reader reader1;
    final Reader reader2;

    public ServiceOutput(Rule rule, Reader reader1, Reader reader2) {
        this.rule = rule;
        this.reader1 = reader1;
        this.reader2 = reader2;
    }

    @Override
    public void write(OutputStream output) throws IOException, WebApplicationException {
        try {
            getAPI().process(rule, reader1, reader2, output);    
        } catch (MixException e) {
            ErrorResponse error = ServiceErrorResponse.createMixingError(e.getMessage());
            Response response = Response.status(error.getCode()).entity(error).build();
            throw new InternalServerErrorException(response);
        }
    }

    private MixThemAPI getAPI() throws MixException {
        //TODO get API interface from MixThem release
        return new MixThemTest();        
    }

    //TODO define API interface in MixThem release
    private interface MixThemAPI {
        void process(Rule rule, java.io.Reader reader1, java.io.Reader reader2, OutputStream output) throws MixException;
    }
    private class MixThemTest implements MixThemAPI {
        @Override
        public void process(Rule rule, java.io.Reader reader1, java.io.Reader reader2, OutputStream output) throws MixException {
            if (rule == null) {
                throw new MixException("Rule not defined!", null);
            }
            if (reader1 == null) {
                throw new MixException("First reader not defined!", null);
            }
            if (reader2 == null) {
                throw new MixException("Last reader not defined!", null);
            }
            try {
                java.io.BufferedReader br1 = new java.io.BufferedReader(reader1);
                java.io.BufferedReader br2 = new java.io.BufferedReader(reader2);
                java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.OutputStreamWriter(output));
                String line = null;
                while ((line = br1.readLine()) != null) {
                    bw.write(line);
                    bw.newLine();
                } 
                while ((line = br2.readLine()) != null) {
                    bw.write(line);
                    bw.newLine();
                } 
                bw.flush();              
                br1.close();
                br2.close();
            } catch (Exception e) {
                throw new MixException(e);                
            }            
        }
    }

}
