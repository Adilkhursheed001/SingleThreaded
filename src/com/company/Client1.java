package com.company;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 {

    public void run() throws Exception{
        System.out.println("hi");
        int port = 8090;
        InetAddress address = InetAddress.getByName("localhost");
        Socket socket = new Socket(address,port);
        PrintWriter toSocket = new PrintWriter(socket.getOutputStream());
        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        toSocket.println("Hello world from socket");
        String line = fromSocket.readLine();
        System.out.println("Response from the socket is"+ line);
        toSocket.close();
        fromSocket.close();
        socket.close();
    }
    public static void main(String[] args) {
        Client1 client = new Client1();
        try{

            client.run();
        }catch(Exception ex){
            ex.getStackTrace();
        }
    }
}
