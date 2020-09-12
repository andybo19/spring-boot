package com.example.demo.tomcatStudy;

import java.io.*;
import java.net.Socket;

/**
 * @author mayongbo
 * @Description
 * @date 2020/8/12 14:44
 */
public class SocketStudy {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 8989);
        OutputStream os = socket.getOutputStream();
        boolean autoflush = true;
        PrintWriter out = new PrintWriter( socket.getOutputStream(), autoflush);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

// send an HTTP request to the web server
        out.println("GET /index.jsp HTTP/1.1");
        out.println("Host: localhost:8080");
        out.println("Connection: Close");
        out.println();

// read the response
        boolean loop = true;
        StringBuffer sb = new StringBuffer(8096);
        while (loop) {
            if (in.ready()) {
                int i=0;
                while (i != -1) {
                    i = in.read();
                    sb.append((char) i);
                }
                loop = false;
            }
            Thread.sleep(50L);
        }
        System.out.println("++++++++++++++++"+sb);
    }

}
