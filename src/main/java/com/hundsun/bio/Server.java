package com.hundsun.bio;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    private static int DEFAULT_PORT = 7777;

    private static ServerSocket serverSocket;

    public static void start(){
        start(DEFAULT_PORT);
    }

    public static void start(int port){
        try {
            serverSocket = new ServerSocket(port);
            ThreadPoolFactory.execute((new ServerHandler(serverSocket)));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
