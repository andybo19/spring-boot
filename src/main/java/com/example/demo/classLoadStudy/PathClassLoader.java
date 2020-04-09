package com.example.demo.classLoadStudy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author mayongbo
 * @Description
 * @date 2020/4/9 16:54
 */
public class PathClassLoader extends ClassLoader {
    //如果要符合双亲委派规范，则重写findClass方法（用户自定义类加载逻辑）；要破坏的话，重写loadClass方法(双亲委派的具体逻辑实现)。

    private String classPath;

    public PathClassLoader(String classPath){
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getData(name);
        if(classData == null){
            throw new ClassNotFoundException(name);
        }else{
            return defineClass(name,classData,0,classData.length);
        }
    }

    private byte[] getData(String className) {
        String path = classPath + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
        try {
            FileInputStream is = new FileInputStream(path);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int num = 0;
            while ((num = is.read(buffer)) != -1){
                stream.write(buffer);
            }
            return stream.toByteArray();

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        PathClassLoader classLoader = new PathClassLoader("D:\\ideaproject\\spring-boot\\target\\classes");
        Class<?> c = classLoader.loadClass("com.example.demo.classLoadStudy.TestClassLoad");
        System.out.println(c.newInstance());
    }

}
