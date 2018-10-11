import java.io.PrintWriter;

public class Client {

    private PrintWriter outputSocket;
    private String naam;

    public Client(PrintWriter out, String naam){
        outputSocket = out;
        this.naam = naam;
    }

    public PrintWriter getOut(){
        return outputSocket;
    }


}
