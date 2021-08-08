public class ServerMain {

    public static void main(String[] args) {
        Server server = new Server();

        while (true) {
           String message = server.receive();
           server.send(message);
        }

    }



}
