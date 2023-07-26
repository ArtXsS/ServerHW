package ru.netology;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final Integer PORT = 6363;
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is ready!");
            while (true) {
                try(Socket client = serverSocket.accept();
                    PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))
                ) {
                    String s = in.readLine();
                    System.out.println("The info from client : " + s);
                    out.println(client.getPort());
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
