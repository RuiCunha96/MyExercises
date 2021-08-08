import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;

    private PrintWriter in;
    private BufferedReader out;
    private Socket clientSocket;
    private int serverPort = 9696;

    public Server() {

        try {
            serverSocket = new ServerSocket(serverPort);
            clientSocket = serverSocket.accept();

            in = new PrintWriter(clientSocket.getOutputStream(), true);

            out = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public String receive() {
        String message = "";
        try {
            message = out.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return message.toUpperCase();
    }

    public void send(String message){
        in.println(message);

    }
}
