/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hazel270923;

/**
 *
 * @author FA506IC
 */
import java.io.*;
import java.net.*;

public class MyClient2 {

    public static void main(String args[]) {
        try {
            Socket client = new Socket(InetAddress.getLocalHost(), 1234);
            InputStream clientIn = client.getInputStream();
            OutputStream clientOut = client.getOutputStream();
            PrintWriter pw = new PrintWriter(clientOut, true);
            BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.println("Type a message for the server : ");
                String userInput = stdIn.readLine();

                if ("exit".equalsIgnoreCase(userInput)) {
                    break;
                }

                pw.println(userInput);

                System.out.println("Server message: ");
                System.out.println(br.readLine());
            }

            pw.close();
            br.close();
            client.close();
        } catch (ConnectException ce) {
            System.out.println("Cannot connect to the server.");
        } catch (IOException ie) {
            System.out.println("I/O Error.");
        }
    }
}
