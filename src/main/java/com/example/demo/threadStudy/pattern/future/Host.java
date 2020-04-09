package com.example.demo.threadStudy.pattern.future;

/**
 * @author mayongbo
 * @date 2019/11/5 19:40
 */
public class Host {

    public Data request(final int count, final  char c){
        System.out.println("    request(" + count + ", " + c + ") BEGIN");
        final FutureData future = new FutureData();
        new Thread(){

            @Override
            public void run() {
                RealData realData = new RealData(count, c);
                future.setRealData(realData);
            }
        }.start();
        System.out.println("    request(" + count + ", " + c + ") END");
        return future;
    }

}
