package com.hundsun.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * 工具类
 */
public class Utils {


    /**
     * 接收消息处理
     * @param socket
     */
    public static void receiveMessageHandler(Socket socket){
        //System.out.println("进入inputMessageHandler");
        InputStreamReader isr = null;
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            isr = new InputStreamReader(socket.getInputStream());
            br = new BufferedReader(isr);
            String content = null;
            while((content = br.readLine())!= null){
                System.out.println("接收到的数据为："+content);
            }
        }catch (Exception e){
            e.fillInStackTrace();
        }


    }

    /**
     * 客服端发送消息处理
     * @param socket
     */
    public static void sendMessageHandler(Socket socket) {
        //System.out.println("进入outputMessageHandler");
        InputStreamReader isr = null;
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            String str = strin.readLine();
            System.out.println("发送的数据为：" + str);
            pw = new PrintWriter(socket.getOutputStream(), true);
            pw.println(str);
            pw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        /**
         * 服务端批量发送消息处理
         * @param clients
         */
        public static void sendMessageHandler(List<Socket> clients){
            //System.out.println("进入outputMessageHandler");
            InputStreamReader isr = null;
            BufferedReader strin = null;

            try {
                strin = new BufferedReader(new InputStreamReader(System.in));
                String read = strin.readLine();
                /*char read = (char) System.in.read();*/
                System.out.println("发送的数据为："+read);
                for(Socket socket : clients){
                    ThreadPoolFactory.execute(() -> {
                        PrintWriter pw = null;
                        try {
                            pw = new PrintWriter(socket.getOutputStream(),true);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        pw.println(read);
                        pw.flush();
                    });

                }
            }catch (Exception e){
                e.printStackTrace();
            }


        }

    /**
     * 统一关闭资源处理
     * @param socket
     * @param isr
     * @param br
     * @param pw
     * @throws IOException
     */
    public static void closeResource(Socket socket, InputStreamReader isr, BufferedReader br, PrintWriter pw) throws IOException {

        if(pw != null){
            pw.close();
            pw = null;
        }
        if(br != null){
            br.close();
            br = null;
        }
        if(isr != null){
            isr.close();;
            isr = null;
        }


    }
}
