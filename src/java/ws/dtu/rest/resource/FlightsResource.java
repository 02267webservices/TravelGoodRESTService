package ws.dtu.rest.resource;

import dtu.ws.group8.lameduck.types.FlightInfoListType;
import dtu.ws.group8.lameduck.types.GetFlightRequestType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/*
 * Note that this class is only a stub and does not provide a correct implementation
 * of the business logic.
 */

@Path("flights")
public class FlightsResource {
    
  /*  

    @GET
    @Produces(MediaType.TEXT_XML)
    public  FlightInfoListType findFlights(@QueryParam("from")String from, @QueryParam("to") String to,@QueryParam("date") String date) {
        GetFlightRequestType input = new GetFlightRequestType();
        input.setFlightStartAirport(from);
        input.setFlightDestinationAirport(to);

        try {
            DatatypeFactory df = DatatypeFactory.newInstance();
            XMLGregorianCalendar dateFlight = df.newXMLGregorianCalendar(date);

            input.setFlightDate(dateFlight);
        }catch (Exception ex) {
            System.out.printf("Should not reach this place!!");
        }
               
        FlightInfoListType result = getFlights(input);
        
        return result;
    }

*/
    
    
    
    
 

   

    private static FlightInfoListType getFlights(dtu.ws.group8.lameduck.types.GetFlightRequestType input) {
        dtu.ws.group8.lameduck.LameDuckService service = new dtu.ws.group8.lameduck.LameDuckService();
        dtu.ws.group8.lameduck.LameDuckWSDLPortType port = service.getLameDuckPort();
        return port.getFlights(input);
    }

}
