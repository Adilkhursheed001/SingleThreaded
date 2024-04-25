package com.company;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class server{
    public void run()throws IOException{
        int port = 8090;
        ServerSocket socket = new ServerSocket(port);
        socket.setSoTimeout(20000);
        try{
            while(true){
                System.out.println("Connection started on port"+ port);
                Socket accpetedConnection = socket.accept();
                System.out.println("Connected to"+ accpetedConnection.getRemoteSocketAddress());
                PrintWriter toClient = new PrintWriter(accpetedConnection.getOutputStream());
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(accpetedConnection.getInputStream()));
                toClient.println("Hello World from the Server");
                toClient.close();
                fromClient.close();
                accpetedConnection.close();
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public static void main(String [] args){
        server server = new server();
        try{
            server.run();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }

    }
}