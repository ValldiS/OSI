package org.example;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = "";

        try (Socket clientSocket = new Socket("netology.homework", Server.PORT);
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            while (!answer.equals("Exit")) {
                System.out.println(reader.readLine());
                answer = sc.nextLine();
                writer.println(answer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
