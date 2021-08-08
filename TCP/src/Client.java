import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;


public class Client {


    private int serverPort = 9696;
    private InetAddress serverAdress;


    PrintWriter out;
    BufferedReader in;
    Socket clientSocket;

    public Client() {
      /*  System.out.println("Port?");
        this.serverPort = Integer.parseInt(input());*/
        try {
            this.serverAdress = InetAddress.getLocalHost();
            this.clientSocket = new Socket(serverAdress, serverPort);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public void send() {
        try {
            this.out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("message: ");
        String message = input();
        out.println(message);
        System.out.println("message sent");
        out.flush();
       //  out.close();

    }

    public void receive(){
        try {

            this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message = in.readLine();
            System.out.println(message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String input() {

        BufferedReader inFromConsole = new BufferedReader(new InputStreamReader(System.in));
        String messageIn = null;

        try {

            messageIn = (inFromConsole.readLine());
            inFromConsole.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return messageIn;
    }
}
