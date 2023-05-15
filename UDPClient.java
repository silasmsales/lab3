import java.net.*;
import java.io.*;

public class UDPClient {
    public static void main(String args[]) {
        // args fornece o conteúdo da mensagem e o nome de host do servidor
        DatagramSocket aSocket = null;
        try {
            aSocket = new DatagramSocket();
            byte[] m = "Hello World".getBytes();
            InetAddress aHost = InetAddress.getByName("192.168.136.130");
            int serverPort = 6789;
            DatagramPacket request = new DatagramPacket(m, m.length, aHost, serverPort);
            aSocket.setSoTimeout(2000);
            aSocket.send(request);
            byte[] buffer = new byte[1000];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            aSocket.receive(reply);
            System.out.println("Reply: " + new String(reply.getData()));
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (aSocket != null)
                aSocket.close();
        }
    }
}