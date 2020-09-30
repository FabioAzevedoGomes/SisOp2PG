package webservice;

import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import java.util.logging.Logger; // Log session info
import java.util.logging.Level;  // Log levels
import java.util.*;
import java.lang.IllegalArgumentException;

public class Cliente {

    /**
     * Operands for remote calculation
     */
    private static int op1;
    private static int op2;
    private static String operation;

    /**
     * List of operations
     */
    private static final Map<String, String> availableOperations = new HashMap<String, String>()
    {{
        put("mult","multiplicarInt");
        put("sum","somarInt");
        
    }};

    /** 
     * Client logger
     */
    private static final Logger LOGGER = Logger.getLogger(Client.class.getName());

    /**
     * Client application entrypoint
     */
    public static void main(String[] args) 
    {

        // Check for operands and operation
        if (args.length < 3)
        {
            System.out.println("Usage: client <operand_1> <operand_2> <operation>");
            System.exit(0);
        }

        // Assign values
        op1 = Integer.parseInt(args[0]);
        op2 = Integer.parseInt(args[1]);
        operation = args[2];

        // Declare some variables
        WebResource     serviceProcedure;  // Remove service being offered
        ClientResponse  procedureResponse; // Response to the remote call
        String          jsonResponse;      // Json format of the response

        // Create default client instance
        ClientConfig config = new DefaultClientConfig();
        Client cliente = Client.create(config);
    
        // Create resource instance provided by the server
        WebResource servico = cliente.resource("http://localhost:9000/calculadora");

        try{

            // Get procedure name
            operation = availableOperations.get(operation);

            // Execute remote call based on operation
            serviceProcedure = servico.path(operation).path(op1 + "/" + op2);
                
            // Call resource GET to obtain instantiated object
            procedureResponse = serviceProcedure.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

            // Extract json answer into a string
            jsonResponse = procedureResponse.getEntity(String.class);
    
            // Print answer to screen
            System.out.println("Result: " + jsonResponse);
        }
        catch(IllegalArgumentException e)
        {
            LOGGER.log(Level.SEVERE, "Unknown operation: " + operation);
        }

    }
}
