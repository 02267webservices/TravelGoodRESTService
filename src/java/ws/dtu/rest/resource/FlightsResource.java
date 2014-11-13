package ws.dtu.rest.resource;

import java.net.URISyntaxException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ws.dtu.rest.data.Flight;

/*
 * Note that this class is only a stub and does not provide a correct implementation
 * of the business logic.
 */
@Path("flights")
public class FlightsResource {
    
     final static String FLIGHTS_URI = "http://localhost:8080/RestWebService/webresources/flights/";

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public String addFlightXML(Flight st) throws URISyntaxException {
        String url = FLIGHTS_URI;
        return url+st.getNumber();
    }

 

    @GET
    public String findFlight(@QueryParam("name") String name) {
        String url = FLIGHTS_URI+"123";
        return url;
    }


}