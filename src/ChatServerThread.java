import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;

public class ChatServerThread extends Thread{

    private Socket socket = null;   //een thread voor 1 client
                                    //een socket wordt gemaakt , 1 luisterpoort per client

    public ChatServerThread(Socket socket){
        super("ChatServerThread"); //er wordt een thread aangemaakt met deze naam
        this.socket =socket;
    }

    public void run(){

        //endige 2 methodes.
        //hier moet ik bij het versturen zorgen dat alle clients de message krijgen.

        try (

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                BufferedReader in  = new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream()
                        )
                );
        ){ //begin van de echte try

            String inputLine;
            String outputLine;
            //eerst een ID opvragen
            out.println("geef je naam in");
            String naam = in.readLine();
            System.out.println("geef je naam in verstuurd");


            //nu kan ik de user toevoegen aan de databank
            DataBank dataBank = new DataBank(); //problemen, misschien moet dit een singleton zin

            dataBank.addClient(out,naam);
            System.out.println("user met naam: "+naam+"toegevoegd aan de lijst met users");

            while((inputLine = in.readLine()) != null) {

                System.out.println("boodschap:"+inputLine+" ontvangen, van "+naam);

                outputLine = naam + ": "+inputLine;

                ArrayList<Client> aantalUsersActief = dataBank.getAlleUsers();

                for(Client c : aantalUsersActief){
                    c.getOut().print(outputLine);
                }


            }











        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
