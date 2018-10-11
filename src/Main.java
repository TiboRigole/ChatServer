import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Main {

    public static DataBank databank;

    public static void main(String[] args){

        databank = new DataBank();
        System.out.println("test");

        //vast poortnummer
        int portNumber = 1605;

        boolean listening = true;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {

            while (listening) {
                //dus zolang we aant lusiteren zijn voor requests

                //aanvaard een connectie en kijkt naar wat er moet staan?
                new ChatServerThread(serverSocket.accept()).start();

            }
        }
        catch(IOException ioe){
            System.err.println("couldn't listen on port "+portNumber);
            ioe.printStackTrace();
            System.out.println("error in main.java server side");
        }




        }
    }

