/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.dtu.rest.data;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author emil
 */
@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)

public class MyBean
{
  
    private Map<String, String> flightlist = new HashMap<String, String>();
    private Map<String, String> hotellist = new HashMap<String, String>();

    public MyBean(){
    }
   
    
    public Map<String, String> getFligtList(){
        return this.flightlist;
    }
     public Map<String, String> getHotelList(){
        return this.hotellist;
    }
    public void addToFligthList(String para1, String para2){
        flightlist.put(para1, para2);
    } 
    public void addToHotelList(String para1, String para2){
        hotellist.put(para1, para2);
    } 
     
     @Override
    public String toString(){
        return flightlist.size() + " & " + hotellist.size();
    }
    //Constructors and getters/setters here
}