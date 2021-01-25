package com.epam.jwd.task4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static Socket clientSocket;

    private static ServerSocket server;
    private static ObjectOutputStream out;
    private static ObjectInputStream in;
    private static String filename;

    public Server() throws IOException {
    }

    public static void main(String[] args) {
        try {
            try {
                server = new ServerSocket(1);
                clientSocket = server.accept();
                try {
                    in = new ObjectInputStream(clientSocket.getInputStream());
                    out = new ObjectOutputStream(clientSocket.getOutputStream());
                } finally {
                    clientSocket.close();
                    in.close();
                    out.close();
                }
            } finally {
                server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}