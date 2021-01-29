package com.epam.jwd.task4;

import com.epam.jwd.task4.entities.Text;

import java.io.*;
import java.net.Socket;

public class Client {
    private static Socket clientSocket;
    private static ObjectInputStream in;
    private static ObjectOutputStream out;
    private static BufferedReader input;
    private static BufferedWriter output;

    public Client() {
    }

    public static void main(String[] args) {
        try {
            try {
                clientSocket = new Socket("localhost", 1);
                in = new ObjectInputStream(clientSocket.getInputStream());
                out = new ObjectOutputStream(clientSocket.getOutputStream());
                input=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                output=new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                output.write("source.txt");
                output.flush();
                String serverWord = input.readLine();
                System.out.println(serverWord);
                Text text=(Text) in.readObject();
                System.out.println("I got the text");

            } finally {
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e);
        }
    }
}
