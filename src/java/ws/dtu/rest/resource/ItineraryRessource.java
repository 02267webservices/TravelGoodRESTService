package ws.dtu.rest.resource;
import dtu.ws.group8.lameduck.BookFlightFault;
import dtu.ws.group8.lameduck.CancelFlightFault;
import dtu.ws.group8.lameduck.types.CreditCardInfoType;
import dtu.ws.group8.lameduck.types.FlightInfoListType;
import dtu.ws.group8.lameduck.types.GetFlightRequestType;
import hotelreservationservices.BookHotelFault;
import hotelreservationservices.CreditCardType;
import hotelreservationservices.HotelsType;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import ws.CancelHotelFault;


@Path("itineraries")
public class ItineraryRessource { 
    public static ArrayList<String> flights = new ArrayList<String>();
 
   @GET //The simplest GET request returns this 
   public String BookFlight(@QueryParam("bookingnumber") String number, 
   @QueryParam("cardnumber") String cardnumber,
   @QueryParam("name") String name,
   @QueryParam("expdate") String expdate){
   
   CreditCardInfoType cardInfo = getCardInfo(cardnumber,name,expdate);
       
   boolean result = false;
     //itinerary.addFlight();
      
      
        ///Call SOAP service
        dtu.ws.group8.lameduck.types.BookFlightRequestType input = new dtu.ws.group8.lameduck.types.BookFlightRequestType();
        input.setFlightBookingNumber(number);
        input.setCreditCardInfo(cardInfo);
      try {
          result = bookFlight(input);
            
      } catch (BookFlightFault ex) {
          Logger.getLogger(ItineraryRessource.class.getName()).log(Level.SEVERE, null, ex);
      }
        flights.add(number);
       return ""+result+ " You have now booked " + flights.size() + " Flights";
   }
   
   @Path("hotel")
   @PUT
   public String BookHotel(@QueryParam("bookingnumber") String number) throws BookHotelFault{
        ws.CreditCardType creditCard = new ws.CreditCardType();
        creditCard.setExpirationMonth(5);
        creditCard.setExpirationYear(9);
        creditCard.setName("Thor-Jensen Claus");
        creditCard.setNumber("50408825");
        int bookingnumber = Integer.parseInt(number);
        
        
       boolean bookingSuccess = false;
       try {
           bookingSuccess = bookHotel(bookingnumber,creditCard);
       } catch (ws.BookHotelFault ex) {
           Logger.getLogger(ItineraryRessource.class.getName()).log(Level.SEVERE, null, ex);
       }
      
        flights.add(number);
       return ""+bookingSuccess;
   }
   
   @Path("hotel")
   @DELETE
   public String cancelHote(@QueryParam("bookingnumber") String number) throws hotelreservationservices.CancelHotelFault{
       boolean cancelSuccess;
       int bookingnumber = Integer.parseInt(number);
       
        try {
            cancelSuccess = cancelHotel(bookingnumber);
            System.out.println("True if cancallation of hotel was succesful: " +cancelSuccess);
        }catch (Exception ex){
            
            System.out.println("Cancellation failed with message: " +ex.getMessage());
        } 
             
       return "";
   }
   
   /*
   @Path("hotel")
   @DELETE
   */
   
  @Path("hotels")
  @GET
  @Produces(MediaType.TEXT_XML)
   public ws.HotelsType getHotels() {
            DatatypeFactory df;
            XMLGregorianCalendar arrivalDate = null;
            XMLGregorianCalendar departureDate = null;
            
       try {
           df = DatatypeFactory.newInstance();
            arrivalDate = df.newXMLGregorianCalendar("2015-01-01");
            departureDate = df.newXMLGregorianCalendar("2015-03-01");

       } catch (DatatypeConfigurationException ex) {
           Logger.getLogger(ItineraryRessource.class.getName()).log(Level.SEVERE, null, ex);
       }
        ws.HotelsType result = getHotels("some city 1",arrivalDate,departureDate);
    return result;
   }
   
  
  
 @Path("flights")  
 @GET
 @Produces(MediaType.TEXT_XML)
    public  FlightInfoListType getFlights(@QueryParam("from")String from, @QueryParam("to") String to,@QueryParam("date") String date) {
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
  
 @Path("flight")
 @DELETE
   public String CancelFlight(@QueryParam("bookingnumber") String number) {
       boolean result = false;
          CreditCardInfoType cardInfo = getCardInfo("50408825","Thor-Jensen Claus","2009-05-05");

       dtu.ws.group8.lameduck.types.CancelFlightRequestType input = new dtu.ws.group8.lameduck.types.CancelFlightRequestType();
        input.setFlightBookingNumber(number);
        input.setCreditCardInfo(cardInfo);
      try {   
          result = cancelFlight(input);
      } catch (CancelFlightFault ex) {
          Logger.getLogger(ItineraryRessource.class.getName()).log(Level.SEVERE, null, ex);
      }
    
       return ""+result;
   }
  

   private CreditCardInfoType getCardInfo(String cardnumber, String name, String expdate) {
        CreditCardInfoType cardInfo = new CreditCardInfoType();
       // cardInfo.setCardNumber("50408825");
       // cardInfo.setName("Thor-Jensen Claus");
          cardInfo.setCardNumber(cardnumber);
          cardInfo.setName(name);
          
        try {
            DatatypeFactory df = DatatypeFactory.newInstance();
          //  XMLGregorianCalendar expDate = df.newXMLGregorianCalendar("2009-05-05");
              XMLGregorianCalendar expDate = df.newXMLGregorianCalendar(expdate);

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

   private static FlightInfoListType getFlights(dtu.ws.group8.lameduck.types.GetFlightRequestType input) {
        dtu.ws.group8.lameduck.LameDuckService service = new dtu.ws.group8.lameduck.LameDuckService();
        dtu.ws.group8.lameduck.LameDuckWSDLPortType port = service.getLameDuckPort();
        return port.getFlights(input);
    }

   private static ws.HotelsType getHotels(java.lang.String city, javax.xml.datatype.XMLGregorianCalendar arrival, javax.xml.datatype.XMLGregorianCalendar departure) {
        ws.HotelReservationService service = new ws.HotelReservationService();
        ws.HotelReservationServices port = service.getHotelReservationServicesBindingPort();
        return port.getHotels(city, arrival, departure);
    }

    private static boolean bookHotel(int bookingNumber, ws.CreditCardType creditCard) throws ws.BookHotelFault {
        ws.HotelReservationService service = new ws.HotelReservationService();
        ws.HotelReservationServices port = service.getHotelReservationServicesBindingPort();
        return port.bookHotel(bookingNumber, creditCard);
    }

    private static boolean cancelHotel(int bookingNumber) throws hotelreservationservices.CancelHotelFault {
        hotelreservationservices.HotelReservationService service = new hotelreservationservices.HotelReservationService();
        hotelreservationservices.HotelReservationServices port = service.getHotelReservationServicesBindingPort();
        return port.cancelHotel(bookingNumber);
    }
  

  
 
}
