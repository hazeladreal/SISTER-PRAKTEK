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

public class TriviaClient {

    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 12345;

        try (
            Socket socket = new Socket(serverAddress, serverPort);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String userInput;

            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                String response = in.readLine();
                System.out.println("Server: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
