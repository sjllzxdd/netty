package com.hundsun.bio;

import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket socket;

    public ClientHandler( Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {

        ClientMessageHandler.messageHandler(socket);

    }
}
