package com.hundsun.bio;


import java.net.Socket;
import java.util.List;

/**
 * 消息处理类
 */
public class ServerMessageHandler {


    public static void messageHandler(Socket socket,List<Socket> clients){

        ThreadPoolFactory.execute(() -> {
            for(;;){
                Utils.receiveMessageHandler(socket);
            }
        });


        ThreadPoolFactory.execute(() -> {
            for(;;){
                Utils.sendMessageHandler(clients);
            }
        });


    }



}
