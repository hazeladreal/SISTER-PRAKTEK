/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hazel041023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author FA506IC
 */

public class ChatClient {
 private static final String serverAddress = "localhost"; // Ganti dengan alamat server yang sesuai
    private static final int serverPort = 12345;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(serverAddress, serverPort);
            System.out.println("Connected to the server.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String message;

            // Input nama pengguna
            System.out.print("Masukkan nama pengguna: ");
            String username = scanner.nextLine();
            out.println(username);

            // Mulai membaca dan mengirim pesan
            while (true) {
                System.out.print("Pesan: ");
                message = scanner.nextLine();
                out.println(message);

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }

                String serverResponse = in.readLine();
                System.out.println("Server: " + serverResponse);
            }

            socket.close();
            System.out.println("Disconnected from the server.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}