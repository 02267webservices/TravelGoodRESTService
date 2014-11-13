package ws.dtu.rest.resource;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.Static;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ws.dtu.rest.data.Flight;


@Path("flight/{id}")
public class FligthRessource {
   
    
  static final String FLIGHT_URI = "http://localhost:8080/RestWebService/webresources/flight/";

  public static Flight flight = null;

    
   public FligthRessource(){
       FligthRessource.flight = new Flight();
       FligthRessource.flight.setName("FLY1");
   } 
 
   
   @GET
   @Produces(MediaType.APPLICATION_XML)
   public Flight getStudentXML(@PathParam("id") int id) {
        flight.setNumber(id);
        return flight;
    }
   
   @GET
    public String findFlight(@QueryParam("id") int id) {
        String url = FLIGHT_URI+"123";
        return url;
    }
   
   
   
   @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response setFlight(@PathParam("id") int id, Flight std) {
        flight = std;
        flight.setNumber(id);
        return Response.ok().entity(flight).build();
    }
   
 
 
  @DELETE
    public String deleteFlight(@PathParam("id") int number) {
        return "deleted "+number;
    }
 
}
