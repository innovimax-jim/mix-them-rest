package innovimax.mixthem.rest.services;

import javax.ws.rs.core.Response;

public interface TextService {
    Response addFromText(String text1,String text2);
    Response altFromText(String type,String text1,String text2);
    Response randomAltFromText(String text1,String text2, Integer seed);
    Response joinFromText(String text1,String text2, Integer col1, Integer col2);    
    Response zipFromText(String type,String text1,String text2, String sep);
}
