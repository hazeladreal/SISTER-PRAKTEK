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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TriviaServer {
    private static final int PORT = 12345;
    private static List<String> questions = new ArrayList<>();

    public static void main(String[] args) {
        populateQuestions();
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running and listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void populateQuestions() {
        questions.add("Apa ibukota Indonesia?");
        questions.add("Siapa presiden pertama Indonesia?");
        questions.add("Siapa penemu gravitasi?");
        questions.add("Apa nama benua terbesar di dunia?");
        questions.add("Siapa penulis novel '1984'?");
    }

    private static String getRandomQuestion() {
        Random random = new Random();
        int index = random.nextInt(questions.size());
        return questions.get(index);
    }

    static class ClientHandler extends Thread {
        private Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            ) {
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    if (inputLine.equals("permintaan")) {
                        String question = getRandomQuestion();
                        out.println(question);
                    } else if (inputLine.startsWith("jawaban")) {
                        String[] parts = inputLine.split("#");
                        if (parts.length == 2) {
                            int questionNumber = Integer.parseInt(parts[0].substring(7));
                            String answer = parts[1];

                            String correctAnswer = getCorrectAnswer(questionNumber);
                            if (correctAnswer != null && answer.equalsIgnoreCase(correctAnswer)) {
                                out.println("Jawaban benar!");
                            } else {
                                out.println("Jawaban salah. Jawaban yang benar: " + correctAnswer);
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String getCorrectAnswer(int questionNumber) {
            switch (questionNumber) {
                case 1:
                    return "Jakarta";
                case 2:
                    return "Soekarno";
                case 3:
                    return "Isaac Newton";
                case 4:
                    return "Asia";
                case 5:
                    return "George Orwell";
                default:
                    return null;
            }
        }
    }
}

