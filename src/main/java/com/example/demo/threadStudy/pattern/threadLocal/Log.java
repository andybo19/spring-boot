package com.example.demo.threadStudy.pattern.threadLocal;

/**
 * @author mayongbo
 * @date 2019/11/8 15:25
 */
public class Log {

    private static final ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<>();

    public static void println(String s){
        getTSLog().writer(s);
    }

    public static void close(){
        getTSLog().close();
    }


    public static TSLog getTSLog(){
        TSLog tsLog = tsLogCollection.get();
        if(tsLog == null){
            tsLog= new TSLog(Thread.currentThread().getName() + "-log.txt");
            tsLogCollection.set(tsLog);
        }
        return tsLog;
    }

}
