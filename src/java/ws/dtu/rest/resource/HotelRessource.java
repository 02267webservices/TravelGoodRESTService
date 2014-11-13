package ws.dtu.rest.resource;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.Static;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("hotel")
public class HotelRessource {

 static String name = "SAS";   
 static int id = 1;
    
@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHotel() {
        return (name);
    }
 
@PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void getHotel(String input) {
        name = input;
    }


@Path("reset")
    @PUT
    public void reset() {
        id = 1;
        name = "SAS";
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
 
}
