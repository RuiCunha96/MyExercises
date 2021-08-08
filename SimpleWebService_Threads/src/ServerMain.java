import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {


    private static final int port = 9696;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            while(true) {

                try {

                    Socket  clientSocket = serverSocket.accept();
                    Thread thread = new Thread(new TaskReceive(clientSocket));
                    thread.start();
                } catch (IOException e) {
                    System.out.println("nao apanhou");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
