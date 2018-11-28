import java.util.logging.Logger;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.web.context.ContextLoaderListener;


public class JerseyStarter {

	// DO NOT MODIFY THIS
	
	public void start(int portNumber, String restClassPackage, String applicationContext) throws Exception
	{
		
		
		
		ResourceConfig resourceConfig = new ResourceConfig();		
		
		// need to explicitly tell Jersey where the REST classes are found
		resourceConfig.packages(restClassPackage);  
		
		// tells Jersey to allow using Jackson library
		resourceConfig.register(JacksonFeature.class);		
		
		// spring initialization -- NOTE: need Jersey-Spring and Spring-Bridge JARs
		resourceConfig.register(RequestContextFilter.class);
		
		// Enable LoggingFilter & output entity.     
        resourceConfig.register(LoggingFilter.class);
        
        
		
		ServletContainer servletContainer = new ServletContainer(resourceConfig);
		ServletHolder sh = new ServletHolder(servletContainer);    
		
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

		// used to tell Jetty where application context is located
		context.addEventListener(new ContextLoaderListener());
		context.setInitParameter("contextConfigLocation", "classpath*:"+applicationContext);
		
		context.setContextPath("/");
        context.addServlet(sh, "/*");
        
        
        // start server with port number
		Server server = new Server(portNumber);		        
		server.setHandler(context);
		server.start();
		server.join();
	}
}
