package webservice;

import java.util.logging.Logger; // Log session info
import java.util.logging.Level;  // Log levels
import java.io.IOException;      // Exceptions
import java.net.URI;
import javax.ws.rs.core.UriBuilder;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.net.httpserver.HttpServer;

public class Servidor {

    /** 
     * Server logger
     */
    private static final Logger LOGGER = Logger.getLogger(Servidor.class.getName());

    /**
     * Server application entry point
     */
    public static void main(String[] args) {

        // Specify addres and port the server will listen at
        URI endpoint = UriBuilder.fromUri("http://localhost/").port(9000).build();

        // Seach for all available procedures (Those marked with @Path in other sources)
        ResourceConfig calculator_rc = new PackagesResourceConfig("webservice");

        try 
        {
            // Create a server with specified endpoint and resources
            HttpServer server = HttpServerFactory.create(endpoint, calculator_rc);
            
            // Log server start
            LOGGER.log(Level.INFO, "Starting server normally");

            // Start the server
            server.start();
            
        } 
        catch (IOException e) 
        {
            // Not able to start server
            LOGGER.log(Level.SEVERE, "Server unable to start: ", e);
        }
    }
}
