package com.example.demo.domain;

public class Thread1 implements Runnable {

    private int num = 50;

    @Override
    public void run() {

            for (int i = 0; i < 50; i++) {
                synchronized (this) {
                    if (num > 0) {
                        try {
                            Thread.sleep(10);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + " synchronized loop " + num);
                        num--;
                    }
                }
            }

    }

    public static void main(String[] args) {
       /* Thread1 t1 = new Thread1();
        Thread ta = new Thread(t1, "A");
        Thread tb = new Thread(t1, "B");
        ta.start();
        tb.start();*/
        System.out.println("ConCurrent类的加载器的名称:"+Thread1.class.getClassLoader().getClass().getName());
        MyClassLoader myClassLoader = new MyClassLoader();
        try {
            Class<? extends Object> testClass = myClassLoader.loadClass("com.example.demo.domain.User");
            Object obj = testClass.newInstance();
            System.out.println("加载器为"+obj.getClass().getClassLoader().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("++++++++++++++++++++++++");
        User user = new User() {
            @Override
            public String getId() {
                return "11234536";
            }
        };
        System.out.println("+++++++++++"+user.getId());
    }
}
