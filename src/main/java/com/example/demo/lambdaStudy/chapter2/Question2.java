package com.example.demo.lambdaStudy.chapter2;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

/**
 * @author mayongbo
 * @Description
 * @date 2020/7/17 15:19
 */
public class Question2 {

    public final static ThreadLocal<DateFormatter> formatter = ThreadLocal.withInitial(() -> new DateFormatter(new SimpleDateFormat("dd-MMM-yyyy")));

    public final static ThreadLocal<DateTimeFormatter> dateformat = ThreadLocal.withInitial(() -> DateTimeFormatter.ofPattern("dd-MMM-yyyy"));

    public static void main(String[] args) {
        /*DateTimeFormatter df = dateformat.get();
        System.out.println(df.format(LocalDate.now()));*/
        long i =1;
        long j = -1;
        System.out.println(Long.toBinaryString(i << 3));
        System.out.println(Long.toBinaryString(j << 4));

    }

}
