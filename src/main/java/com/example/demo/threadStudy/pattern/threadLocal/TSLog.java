package com.example.demo.threadStudy.pattern.threadLocal;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author mayongbo
 * @date 2019/11/6 15:08
 */
public class TSLog {

    private PrintWriter writer;


    public TSLog(String fileName){
        try {
            writer = new PrintWriter(new FileWriter(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writer(String s){
        writer.println(s);
    }

    public void close(){
        System.out.println("==== End of log ====");
        writer.close();
    }



}
