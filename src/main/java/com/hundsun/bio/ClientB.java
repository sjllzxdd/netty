package com.hundsun.bio;

import java.io.IOException;
import java.net.Socket;

public class ClientB {

    private static String DEFAULT_HOST = "127.0.0.1";
    private static int DEFAULT_PORT = 7777;
    private static Socket socket;

    public static void send(){
        send(DEFAULT_HOST, DEFAULT_PORT);
    }

    public static void send(String host, int port){
        try {
            socket = new Socket(DEFAULT_HOST,DEFAULT_PORT);
            ThreadPoolFactory.execute(new ClientHandler(socket));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
