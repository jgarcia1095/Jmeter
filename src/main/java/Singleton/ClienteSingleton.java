package Singleton;


public class ClienteSingleton {

    private static volatile ClienteSingleton cliente;
    private  String id ;
    private  String firstName;
    private  String lastName;
    private  String street;
    private  String city;

    private ClienteSingleton(){

        //Prevenir instanciacion de un nuevo objeto con reflection api.
        if (cliente != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }  //private constructor.

    public static ClienteSingleton getInstance(){
        if (cliente == null) { //Check for the first time

            synchronized (ClienteSingleton.class) {   //Check for the second time.
                //if there is no instance available... create new one
                if (cliente == null) cliente = new ClienteSingleton();
            }
        }
        return cliente;
    }

    public static ClienteSingleton getCliente() {
        return cliente;
    }

    public static void setCliente(ClienteSingleton cliente) {
        ClienteSingleton.cliente = cliente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}