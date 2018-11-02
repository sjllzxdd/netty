package com.hundsun.bio;


import java.net.Socket;
import java.util.List;

/**
 * 消息处理类
 */
public class ClientMessageHandler {


    public static void messageHandler(Socket socket){

        ThreadPoolFactory.execute(() -> {
            for(;;){
                Utils.receiveMessageHandler(socket);
            }
        });

        ThreadPoolFactory.execute(() -> {
            for(;;){
                Utils.sendMessageHandler(socket);
            }
        });

    }



}
