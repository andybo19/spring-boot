package com.example.demo.basisStudy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author mayongbo
 * @Description
 * @date 2021/2/22 10:15
 */
public class ListRemoveDemo {

    public static void main(String[] args) {
        LinkedList<Object> objects = new LinkedList<>();

        List<String> list = new ArrayList<>();
        list.add("安迪");
        list.add("zerui");
        list.add("qin");
        System.out.println("before remove list = " + list);
        /*int loopTime = 1;
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println("loopTime = " + loopTime);
            loopTime++;
            String item = iterator.next();
            System.out.println(" item = " + item);
            if("安迪".equals(item)){
                //iterator.remove();
                list.remove(item);
            }
        }*/
        for (String item : list) {
            if("zerui".equals(item)){
                list.remove(item);
            }
        }
        System.out.println("after remove list = " + list);
    }

}
