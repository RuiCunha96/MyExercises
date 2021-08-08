import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;


public class Client {

    private PrintWriter out;
    private BufferedReader in;
    private Socket clientSocket;

    private InetAddress serverAdress;
    private int serverPort;

    public Client()  {
        this.serverPort = 9696;

        try {
            this.serverAdress = InetAddress.getLocalHost();
            this.clientSocket = new Socket(serverAdress, serverPort);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void send() {
        String message2Send = consoleIn();
        out.println(message2Send);
    }

    public void receive() {
        try {
            String messageIn = in.readLine();
            System.out.println(messageIn);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String consoleIn() {

        BufferedReader inConsole = new BufferedReader(new InputStreamReader(System.in));
        String message = null;
        try {
            message = inConsole.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return message;


    }

}
