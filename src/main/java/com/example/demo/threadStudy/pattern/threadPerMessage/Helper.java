package com.example.demo.threadStudy.pattern.threadPerMessage;

/**
 * @author mayongbo
 * @date 2019/11/4 19:13
 */
public class Helper {

    public void handle(int count,char c){
        System.out.println("        handle(" + count + ", " + c + ") BEGIN");
        for (int i=0; i<count;i++) {
            slowLy();
            System.out.println(c);
        }
        System.out.println("");
        System.out.println("        handle(" + count + ", " + c + ") END");

    }

    private void slowLy() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
