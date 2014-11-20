package ws.dtu.rest.resource;
import dtu.ws.group8.lameduck.BookFlightFault;
import dtu.ws.group8.lameduck.CancelFlightFault;
import dtu.ws.group8.lameduck.types.CreditCardInfoType;
import dtu.ws.group8.lameduck.types.FlightInfoListType;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


@Path("flight")
public class FligthRessource { 
  static final String FLIGHT_URI = "http://localhost:8080/RestWebService/webresources/flight";
  
  /* 
  @GET
   @Produces(MediaType.TEXT_PLAIN)
   public String getFlight(@PathParam("id") String id) {
       
        return "RESPONSE 2";
    }*/
   
   @GET //The simplest GET request returns this 
   public String BookFlight(@QueryParam("bookingnumber") String number){
      boolean result = false;
               
        ///Call SOAP service
        dtu.ws.group8.lameduck.types.BookFlightRequestType input = new dtu.ws.group8.lameduck.types.BookFlightRequestType();
        input.setFlightBookingNumber(number);
        input.setCreditCardInfo(getCardInfo());
      try {
          result = bookFlight(input);
            
      } catch (BookFlightFault ex) {
          Logger.getLogger(FligthRessource.class.getName()).log(Level.SEVERE, null, ex);
      }
       return ""+result;
   }
   
   
   @DELETE
   public String CancelFlight(@QueryParam("bookingnumber") String number) {
       boolean result = false;
       
       dtu.ws.group8.lameduck.types.CancelFlightRequestType input = new dtu.ws.group8.lameduck.types.CancelFlightRequestType();
        input.setFlightBookingNumber(number);
        input.setCreditCardInfo(getCardInfo());
      try {   
          result = cancelFlight(input);
      } catch (CancelFlightFault ex) {
          Logger.getLogger(FligthRessource.class.getName()).log(Level.SEVERE, null, ex);
      }
            
       
       
       
       return ""+result;
   }
   
   
////SEEEE- this should be moved to the test section for the REST client
 private CreditCardInfoType getCardInfo() {
        CreditCardInfoType cardInfo = new CreditCardInfoType();
        cardInfo.setCardNumber("50408825");
        cardInfo.setName("Thor-Jensen Claus");
        
        try {
            DatatypeFactory df = DatatypeFactory.newInstance();
            XMLGregorianCalendar expDate = df.newXMLGregorianCalendar("2009-05-05");
            cardInfo.setExpiryDate(expDate);
        }catch (Exception ex) {
        }
        return cardInfo;
    } 

    private static boolean bookFlight(dtu.ws.group8.lameduck.types.BookFlightRequestType input) throws BookFlightFault {
        dtu.ws.group8.lameduck.LameDuckService service = new dtu.ws.group8.lameduck.LameDuckService();
        dtu.ws.group8.lameduck.LameDuckWSDLPortType port = service.getLameDuckPort();
        return port.bookFlight(input);
    }

    private static boolean cancelFlight(dtu.ws.group8.lameduck.types.CancelFlightRequestType input) throws CancelFlightFault {
        dtu.ws.group8.lameduck.LameDuckService service = new dtu.ws.group8.lameduck.LameDuckService();
        dtu.ws.group8.lameduck.LameDuckWSDLPortType port = service.getLameDuckPort();
        return port.cancelFlight(input);
    }


  

  
 
}
