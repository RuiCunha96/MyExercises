import javax.sound.sampled.Line;
import java.io.IOException;
import java.net.*;

import java.nio.charset.StandardCharsets;

public class Server {

    public static void main(String[] args) {


        int portNumberServer = 9696;
        int portNumberClient = 0;


        String toSend = null;
        InetAddress clientAdress = null;

        //receive
        byte[] recvBuffer = new byte[1024];
        String messageReceived;

        try {
            DatagramSocket socketReceiver = new DatagramSocket(portNumberServer);
            DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);
            socketReceiver.receive(receivePacket);

            clientAdress = receivePacket.getAddress();
            portNumberClient = receivePacket.getPort();

            messageReceived = new String(receivePacket.getData(), StandardCharsets.UTF_8);

            toSend = messageReceived.toUpperCase();
            socketReceiver.close();

            System.out.println("received on server");

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //send


        try {
            byte[] sendBuffer = toSend.getBytes(StandardCharsets.UTF_8);
            DatagramSocket socketSend = new DatagramSocket(portNumberServer);

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAdress, portNumberClient);

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


    }
}



