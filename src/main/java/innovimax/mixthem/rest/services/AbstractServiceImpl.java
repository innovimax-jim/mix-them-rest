package innovimax.mixthem.rest.services;

import innovimax.mixthem.MixException;
import innovimax.mixthem.Rule;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

public abstract class AbstractServiceImpl {

    protected Response getStreamResponse(Rule rule, String text1, String text2) {
        final StreamingOutput output = new ServiceOutput(rule, new StringReader(text1), new StringReader(text2));
        return Response.ok(output).build(); 
    }

    protected Response getStreamResponse(Rule rule, InputStream input1, InputStream input2) {
        final StreamingOutput output = new ServiceOutput(rule, new InputStreamReader(input1), new InputStreamReader(input2));
        return Response.ok(output).build(); 
    }
    
}
