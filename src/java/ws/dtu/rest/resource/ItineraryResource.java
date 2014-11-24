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


public class ItineraryResource {
    private List<String> flights;
   // private List<HotelInfoType> hotels;



    
    public  int getFlights() {
       
        return flights.size();
    }

public void addFlight(){
    flights.add("String1");
}
    
   

}