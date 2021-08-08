import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class TaskReceive implements Runnable {

    private Socket clientSocket;

    public TaskReceive(Socket clientSocket) {

        this.clientSocket = clientSocket;

    }

    @Override
    public void run() {

        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message = in.readLine();
            System.out.println(message);
            elements0(message.split(" "), clientSocket);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void elements0(String[] elements, Socket clientSocket) {

        switch (elements[0]) {
            case "GET":
                getElements1(elements[1], clientSocket);

                break;

        }

    }
    private void getElements1(String element, Socket clientSocket) {
        File file2Send;
        String header2Go;
        OutputStream out= null;

        try {
            out = clientSocket.getOutputStream();
        } catch (IOException e) {
            System.out.println("Error get elements1");
        }

        switch (element){
            case "/"://home
                file2Send = new File("Resources/Home.html");
                header2Go = "HTTP/1.0 200 Document Follows\r\nContent-Type: text/html; charset=UTF-8\r\nContent-Length: " + file2Send.length() + " \r\n\r\n";

                try {
                    out.write(header2Go.getBytes(StandardCharsets.UTF_8));
                    out.write( Files.readAllBytes(file2Send.toPath()));
                    clientSocket.close();
                    //serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                new Server();

                break;

            case "/image":
                file2Send = new File("Resources/songoku.jpg");
                header2Go = "HTTP/1.0 200 Document Follows\r\n Content-Type: image/jpg \r\n" + "Content-Length:" + file2Send.length() +" \r\n" + "\r\n";

                try {
                    out.write(header2Go.getBytes(StandardCharsets.UTF_8));
                    out.write( Files.readAllBytes(file2Send.toPath()));
                    clientSocket.close();
                    //serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                new Server();


                break;

            default://404
                file2Send = new File("Resources/Notfound.html");
                header2Go = "HTTP/1.0 404 Not Found\r\nContent-Type: text/html; charset=UTF-8\r\nContent-Length: " + file2Send.length() + " \r\n\r\n";

                try {
                    out.write(header2Go.getBytes(StandardCharsets.UTF_8));
                    out.write( Files.readAllBytes(file2Send.toPath()));

                    clientSocket.close();
                    //serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                new Server();
        }

    }
}
