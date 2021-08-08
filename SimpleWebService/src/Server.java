import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;

public class Server {


    private ServerSocket serverSocket;
    private OutputStream out;
    private BufferedReader in;
    private Socket clientSocket;
    private int serverPort = 9696;
    private LinkedList<String> header = new LinkedList<>();

    public Server() {

        try {
            serverSocket = new ServerSocket(serverPort);
            clientSocket = serverSocket.accept();

            out = clientSocket.getOutputStream();

            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void receive() {
        try {

            String line;



           /* while ((line = in.readLine()) != null) {

                header.add(line);
                System.out.println(line);
                // message = message + line + "\n";
            }*/
            header.add(in.readLine());

            messageType();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void send(byte[] message) {

        try {
            out.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void messageType() {

        String[] header0 = header.get(0).split(" ");

        switch (header0[0]) {
            case "GET":
                get(header0);
        }
    }

    private void get(String[] header0) {
        String header2Go;
        File file2Go;

        switch (header0[1]) {
            case "/image":
                file2Go = new File("Resources/POTATO.jpeg");
                header2Go = "HTTP/1.0 200 Document Follows\r\n Content-Type: image/jpeg \r\n" + "Content-Length:" + file2Go.length() +" \r\n" + "\r\n";



                send(header2Go.getBytes());


                try {
                    send(Files.readAllBytes(file2Go.toPath()));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;

            case "/olha":

                file2Go = new File("Resources/olha.html");
                header2Go = "HTTP/1.0 200 Document Follows\r\nContent-Type: text/html; charset=UTF-8\r\nContent-Length: " + file2Go.length() + " \r\n\r\n";

                try {
                    List<String> list = Files.readAllLines(file2Go.toPath());
                    for (String s : list) {
                        header2Go = header2Go + s + " \n";
                    }



                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(header2Go);

                send(header2Go.getBytes(StandardCharsets.UTF_8));

                break;
            default:

                file2Go = new File("Resources/NotFound.html");
                header2Go = "HTTP/1.0 404 Not Found\r\nContent-Type: text/html; charset=UTF-8\r\nContent-Length: " + file2Go.length() + " \r\n\r\n";

                try {
                    List<String> list = Files.readAllLines(file2Go.toPath());
                    for (String s : list) {
                        header2Go = header2Go + s + " \n";
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(header2Go);

                send(header2Go.getBytes(StandardCharsets.UTF_8));

        }


    }


}



