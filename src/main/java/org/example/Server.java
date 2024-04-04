package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.WeakHashMap;

public class Server {

    public static final Integer PORT = 8080;


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();


        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер стартовал");
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ) {
                    out.println("Hi Write your name");
                    String infoForClient = in.readLine();
                    list.add(infoForClient);
                    out.println("Are you child? (yes/no)");
                    infoForClient = in.readLine();
                    switch (infoForClient) {
                        case "Yes":
                            out.printf("Welcome to the kids area, %s! Let's play!", list.get(0));
                            break;
                        case "No":
                            out.printf("Welcome to the adult zone, %s! Have a good rest, or a good working day!", list.get(0));
                            break;
                        default:
                            out.printf("Whoo a youuu?!");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
