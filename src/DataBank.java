import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DataBank {

    private static Set<Client> clientSet = new HashSet<Client>();

    //private ArrayList<Client>

    public DataBank(){
        clientSet = new HashSet<Client>();
    }

    public void addClient(PrintWriter out, String inputLine) {
        clientSet.add(new Client(out,inputLine));
    }

    public ArrayList<Client> getAlleUsers(){
        ArrayList<Client> returnList = new ArrayList<Client>();

        for(Client c :clientSet){
            returnList.add(c);
        }

        return returnList;
    }





}
