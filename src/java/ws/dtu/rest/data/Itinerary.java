package ws.dtu.rest.data;

import dtu.ws.group8.lameduck.types.FlightInfoType;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Itinerary")
@XmlRootElement(name = "Itinerary")
public class Itinerary {
    @XmlElement
    public int id;
    @XmlElement
    public List<FlightInfoType> flights;
   // public Hotel[] hotels;
    
    public Itinerary(int id) {
        this.id = id;
        
    }
    
    public List<FlightInfoType> getFlights() {
        return this.flights;
    }
    
    public int getId(){
        return id;
    }
 
    
    public void setFlight(FlightInfoType fly){
        flights.add(fly);
    }
    
  
}