package com.example.demo.service.netty;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class IOServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8000);
            new Thread(()->{
                while (true){
                    try {
                        // (1) 阻塞方法获取新的连接
                        Socket socket = server.accept();
                        // (2) 每一个新的连接都创建一个线程，负责读取数据
                        new Thread(()->{
                            InputStream inputStream = null;
                            try {
                                inputStream = socket.getInputStream();
                                byte[] bytes = new byte[1024];
                                int len;
                                StringBuilder sb = new StringBuilder();
                                while ((len = inputStream.read(bytes)) != -1) {
                                    //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
                                    sb.append(new String(bytes, 0, len,"UTF-8"));
                                }
                                System.out.println("get message from server: " + sb);
                                 inputStream.close();
                                 socket.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }).start();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
