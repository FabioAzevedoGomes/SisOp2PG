package webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("calculadora")
public class CalculadoraRest 
{   

    /**
     * Creates a new calculator object with the sum of received operands
     * @param op1 First operand
     * @param op2 Second operand
     * @return Instance of calculator containing the result of the operation
     */
    @Path("somarInt/{a}/{b}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Calculadora somarInt(@PathParam("a") int op1,@PathParam("b") int op2)
    {
        return  new Calculadora(op1, op2, "+");
    }

    /**
     * Creates a new calculator object with the multiplication of received operands
     * @param op1 First operand
     * @param op2 Second operand
     * @return Instance of calculator containing the result of the operation
     */
    @Path("multiplicarInt/{a}/{b}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Calculadora multiplicarInt(@PathParam("a") int op1, @PathParam("b") int op2)
    {
        return new Calculadora(op1, op2, "*");
    }
}
