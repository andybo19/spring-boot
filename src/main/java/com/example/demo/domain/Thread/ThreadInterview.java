package com.example.demo.domain.Thread;

public class ThreadInterview implements Runnable {

    private int x=1;
    private int y=1;

    public static void main(String[] args) {
        ThreadInterview interview = new ThreadInterview();
        (new Thread(interview)).start();
        (new Thread(interview)).start();
    }

    @Override
    public synchronized void run() {
        for(;;){
            x++;
            y++;
            System.out.println("x = "+x+", y = "+y);
        }

    }
}
