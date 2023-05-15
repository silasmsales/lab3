import java.net.*;
import java.io.*;

public class TCPClient {
    public static void main(String args[]) {
        // os argumentos fornecem a mensagem e o nome de host de destino
        Socket s = null;
        try {
            int serverPort = 7896;
            s = new Socket("192.168.136.130", serverPort);
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            out.writeUTF("Hello World"); // UTF é uma codificação de string; veja a Seção 4.3
            String data = in.readUTF();
            System.out.println("Received: " + data);
        } catch (UnknownHostException e) {
            System.out.println("Sock:" + e.getMessage());
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO:" + e.getMessage());
        }
    }
}