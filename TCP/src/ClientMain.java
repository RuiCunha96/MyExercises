import java.io.IOException;

public class ClientMain {
    //chat that supports 1 user

    public static void main(String[] args) {

        Client client1 = new Client();

            client1.send();
            client1.receive();


    }



}


/*
    // STEP1: Get the host and the port from the command-line
    String hostName = args[0];
    int portNumber = Integer.parseInt(args[1]);

    // STEP2: Open a client socket, blocking while connecting to the server
    Socket clientSocket = new Socket(hostName, portNumber);

    // STEP3: Setup input and output streams
    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

// STEP4: Read from/write to the stream
// STEP5: Close the streams
// STEP6: Close the sockets

    */

