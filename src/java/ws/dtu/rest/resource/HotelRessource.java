package ws.dtu.rest.resource;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.Static;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;
import ws.dtu.rest.data.Hotel;


@Path("hotel")
public class HotelRessource {

//TEST Hotel 
 static String name = "SAS";   
 static int id = 1;
 Hotel hotel = new Hotel();
 
 
@Path("reset")
@PUT
    public void reset() {
    System.out.println("RESET DONE.......................................");
    name = "SAS";
    id = 1;
    hotel.setName("MERIOTT");
    hotel.setId("2");
   
    } 
 
@GET
@Produces(MediaType.TEXT_PLAIN)
public String getHotels() {
    hotel.setName("MERIOTT");

    return hotel.getName();
} 
 
 
@PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void getHotel(String input) {
        name = input;
    }

@Path("id")
    @GET()
    @Produces(MediaType.TEXT_PLAIN)
    public String getHotelId() {
        return ""+id;
    }
 
 @DELETE
 public void deleteHotel(){
     
 } 
 
 
 @XmlRootElement
public class HotelList {
   public List<Hotel> string = new ArrayList<Hotel>();
}
 
}
