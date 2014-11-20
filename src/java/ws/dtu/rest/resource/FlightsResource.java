package ws.dtu.rest.resource;

import dtu.ws.group8.lameduck.types.FlightInfoListType;
import dtu.ws.group8.lameduck.types.FlightInfoType;
import dtu.ws.group8.lameduck.types.GetFlightRequestType;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/*
 * Note that this class is only a stub and does not provide a correct implementation
 * of the business logic.
 */

@Path("flights")
public class FlightsResource {
    
     final static String FLIGHTS_URI = "http://localhost:8080/RestWebService/webresources/flights";
    private List<FlightInfoType> ts;



    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public  List<FlightInfoType> findFlights() {


        GetFlightRequestType input = new GetFlightRequestType();
        input.setFlightStartAirport("Copenhagen");
        input.setFlightDestinationAirport("Berlin");

        try {
            DatatypeFactory df = DatatypeFactory.newInstance();
            XMLGregorianCalendar dateFlight = df.newXMLGregorianCalendar("2015-01-01");
            input.setFlightDate(dateFlight);
        }catch (Exception ex) {
            System.out.printf("Should not reach this place!!");
        }
               
        FlightInfoListType result = getFlights(input);
         List<FlightInfoType> flightsInfo =  result.getFlightInformation();
        
        return flightsInfo;
    }


    
    
    
    
        private static FlightInfoListType getFlights(dtu.ws.group8.lameduck.types.GetFlightRequestType input) {
        dtu.ws.group8.lameduck.LameDuckService service = new dtu.ws.group8.lameduck.LameDuckService();
        dtu.ws.group8.lameduck.LameDuckWSDLPortType port = service.getLameDuckPort();
        return port.getFlights(input);
    }

}