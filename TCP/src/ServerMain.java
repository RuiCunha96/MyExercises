public class ServerMain {

    public static void main(String[] args) {

        Server server = new Server();


            String message = server.receive();
            server.send(message);



    }






}

/*
    // STEP1: Get parameters from command line arguments
    int portNumber = Integer.parseInt(args[0]);

    // STEP2: Bind to local port and block while waiting for client connections
    ServerSocket serverSocket = new ServerSocket(portNumber);
    Socket clientSocket = serverSocket.accept();

    // STEP3: Setup input and output streams
    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

// STEP4: Read from/write to the stream
// STEP5: Close the streams
// STEP6: Close the sockets
*/
