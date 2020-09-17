package com.example.demo.algorithmStudy;

/**
 * @author mayongbo
 * @Description
 * @date 2020/9/15 9:36
 */
public class StringReplace {

    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("We Are Happy");
        String space = replaceSpace(buffer);
        System.out.println("++++++++++++++++"+space);
    }

    public static String replaceSpace(StringBuffer str) {
        String string = str.toString();
        String replace = string.replace(" ", "%20");
        return replace;
    }

}
