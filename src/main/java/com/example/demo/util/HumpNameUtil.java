package com.example.demo.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author wan yu
 * @date 2022/5/27 上午10:21
 */
public class HumpNameUtil {

    public static void main(String[] args) {
        try {
            String path = "/Users/mayongbo/Documents/humpname.txt";
            File file = new File(path);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String lineTxt;
            //List<String> list = new ArrayList<>();
            while ((lineTxt = bufferedReader.readLine()) != null) {
                //System.out.println(lineTxt);
                //list.add(lineTxt.replace(" ", ","));
                System.out.println(changeToJavaFiled(lineTxt));
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
    }

    public static String changeToJavaFiled(String field) {
        String[] fields = field.toLowerCase().split("_");
        StringBuilder sbuilder = new StringBuilder(fields[0]);
        for (int i = 1; i < fields.length; i++) {
            char[] cs = fields[i].toCharArray();
            cs[0] -= 32;
            sbuilder.append(String.valueOf(cs));
        }
        return sbuilder.toString();
    }

}
