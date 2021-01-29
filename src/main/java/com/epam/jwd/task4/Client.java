package com.epam.jwd.task4;

import com.epam.jwd.task4.entities.Text;

import java.io.*;
import java.net.Socket;

public class Client {
    private static Socket clientSocket;
    private static BufferedReader consoleReader;
    private static ObjectInputStream in;
    private static ObjectOutputStream out;
    private static Text text;

    public Client() {
    }

    public static void main(String[] args) {
        try {
            try {
                clientSocket = new Socket("localhost", 1);
                consoleReader = new BufferedReader(new InputStreamReader(System.in));
                in = new ObjectInputStream(clientSocket.getInputStream());
                out = new ObjectOutputStream(clientSocket.getOutputStream());
                out.writeObject(text);
                out.flush();
            } finally {
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
