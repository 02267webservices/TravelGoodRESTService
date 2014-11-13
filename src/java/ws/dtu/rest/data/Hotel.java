package ws.dtu.rest.data;

@javax.xml.bind.annotation.XmlRootElement()
public class Hotel {
    public String name;
    public String id;
    
    public Hotel(){
       
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public String toString(){
        
        return "The name is " + name + " and the id is "+ id;
    }
}
