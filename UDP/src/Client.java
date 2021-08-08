import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Client {

    public static void main(String[] args) {

        String messageToSend = "message up";
        int portNumberServer = 9696;
        int portNumberClient = 9797;

        byte[] sendBuffer ;

        //send

        try {
            DatagramSocket   socketSend = new DatagramSocket(portNumberClient);

            sendBuffer = messageToSend.getBytes(StandardCharsets.UTF_8);

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length,InetAddress.getLocalHost(), portNumberServer);

            socketSend.send(sendPacket);

            System.out.println("sent");
            socketSend.close();


        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //receive
        byte[] recvBuffer = new byte[1024];
        int portNumberReceiver = 9797;

        try {
            DatagramSocket socketReceiver = new DatagramSocket(portNumberReceiver);
            DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);


            socketReceiver.receive(receivePacket);

            String messageReceived = new String(receivePacket.getData(), StandardCharsets.UTF_8);
            socketReceiver.close();
            System.out.println("received");

            System.out.println(messageReceived);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
