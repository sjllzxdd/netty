package com.hundsun.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ServerHandler implements Runnable {

    private ServerSocket serverSocket;
    private List<Socket> clients = new ArrayList<>();

    public ServerHandler(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
    }
    @Override
    public void run() {
        for(;;){
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                clients.add(socket);
                ServerMessageHandler.messageHandler(socket,clients);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
