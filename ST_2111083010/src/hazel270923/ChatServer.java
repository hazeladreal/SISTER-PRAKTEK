/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hazel270923;

/**
 *
 * @author FA506IC
 */
import java.net.*;

public class ChatServer {

    public static void main(String args[]) throws Exception {
        MulticastSocket server = new MulticastSocket(1234);
        InetAddress group = InetAddress.getByName("234.5.6.7");
        server.joinGroup(group);
        boolean infinite = true;
        while (infinite) {
            byte buf[] = new byte[1024];
            DatagramPacket data = new DatagramPacket(buf,
                    buf.length);
            server.receive(data);
            String msg = new String(data.getData()).trim();
            System.out.println(msg);
        }
        server.close();
    }
}
