package ws.dtu.rest.data;

@javax.xml.bind.annotation.XmlRootElement()
public class Flight {
    private String id;
    private String name;
   

    public String getNumber() {
        return id;
    }

    public void setNumber(String number) {
        this.id = number;
    }

    
     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   
    @Override
    public String toString() {
        return String.format("%s", id);
    }
    
    
}
