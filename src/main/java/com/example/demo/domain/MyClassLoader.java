package com.example.demo.domain;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {
    public MyClassLoader(){
    }

    public MyClassLoader(ClassLoader parent){
        super(parent);
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        //打印日志，表示使用的是自定义的类加载器
        System.out.println("Use myclassloader findClass method.");
        //获取的fileName为: EasyTest.class
        String fileName = name.substring(name.lastIndexOf(".")+1)+".class";

        byte[] bytes = loadClassData("E:\\test\\JvmProject\\"+fileName);
        return defineClass(name, bytes, 0, bytes.length);
    }

    public byte[] loadClassData(String name) {
        //这里参数name路径为：E:\test_eclipse\JvmProject\EasyTest.class
        FileInputStream fileInput = null;
        ByteArrayOutputStream bytesOutput = null;
        try {
            fileInput = new FileInputStream(new File(name));
            bytesOutput = new ByteArrayOutputStream();
            int b = 0;
            while ((b = fileInput.read()) != -1) {
                bytesOutput.write(b);
            }
            return bytesOutput.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileInput != null){
                    fileInput.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
