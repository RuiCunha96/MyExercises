import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private int serverPort = 9696;
    ServerSocket serverSocket;
    Socket clientSocket;
    PrintWriter out;
    BufferedReader in;

    public Server() {
        try {
            this.serverSocket = new ServerSocket(serverPort);
            this.clientSocket = serverSocket.accept();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public String receive() {
        try {
            this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message = in.readLine();
            System.out.println("here");
            System.out.println(message);
            System.out.println("received");

            return message;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    public void send(String message) {
        try {
            this.out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.write(message);
        out.flush();
        System.out.println("sent");
       // out.close();
    }

}
