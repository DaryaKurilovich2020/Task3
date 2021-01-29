package com.epam.jwd.task4;

import com.epam.jwd.task4.DAO.TextReader;
import com.epam.jwd.task4.entities.Text;
import com.epam.jwd.task4.parsers.TextParser;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static Socket clientSocket;

    private static ServerSocket server;
    private static ObjectOutputStream out;
    private static ObjectInputStream in;
    private static String filename;

    public Server() {
    }

    public static void main(String[] args) {
        try {
            try {
                server = new ServerSocket(1);
                clientSocket = server.accept();
                try {
                    in = new ObjectInputStream(clientSocket.getInputStream());
                    out = new ObjectOutputStream(clientSocket.getOutputStream());
                    BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    BufferedWriter output = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                    filename = input.readLine();
                    output.write("Hi, i got the filename");
                    output.flush();
                    TextReader reader=new TextReader(filename);
                    Text text=reader.read();
                    out.writeObject(text);
                    out.flush();

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