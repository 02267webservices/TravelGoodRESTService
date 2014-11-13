package ws.dtu.rest.data;

@javax.xml.bind.annotation.XmlRootElement()
public class Flight {
    private int id;
    private String name;
   

    public int getNumber() {
        return id;
    }

    public void setNumber(int number) {
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
