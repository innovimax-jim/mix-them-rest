package innovimax.mixthem.rest.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class LoggingFilter implements Filter {

	private static Logger logger = Logger.getLogger(LoggingFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
		//PatternLayout layout = new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} [%-5p] (%F:%M:%L) %m%n");
		PatternLayout layout = new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} [%-5p] Mixthem %m%n");
		ConsoleAppender appender = new ConsoleAppender(layout);
		logger.addAppender(appender);
		logger.setLevel(Level.DEBUG);
	}

    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) 
            throws IOException, ServletException {    	
        String url = ((HttpServletRequest) request).getRequestURL().toString();     
    	String host = ((HttpServletRequest) request).getRemoteHost();    	
       	logger.debug(url + "(" + host + ")");
        filterChain.doFilter(request, response);        
    }

}
