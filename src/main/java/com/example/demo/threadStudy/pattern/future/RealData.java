package com.example.demo.threadStudy.pattern.future;

/**
 * @author mayongbo
 * @date 2019/11/5 18:45
 */
public class RealData implements Data {

    private final String content;

    public RealData(int count, char c){
        System.out.println("        making RealData(" + count + ", " + c + ") BEGIN");
        char[] buffer = new char[count];
        for (int i = 0; i < count; i++) {
            buffer[i] = c;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("realData设置内容当前线程:"+Thread.currentThread().getName());
        System.out.println("        making RealData(" + count + ", " + c + ") END");
        this.content = new String(buffer);

    }

    @Override
    public String getContent() {
        System.out.println("realData获取内容当前线程:"+Thread.currentThread().getName());
        return this.content;
    }
}
