package com.example.demo.service.interview;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class BasicTest {

    public static void main(String[] args) {
        BigDecimal s1=new BigDecimal(0.01);
        BigDecimal s2=new BigDecimal(0.05);
        BigDecimal add = s1.add(s2);
        System.out.println(add);
        Set<Integer> integerSet = Sets.newHashSet(1,2,3);
        List<Integer> integers = Lists.newArrayList(4, 5, 6);
        integerSet.addAll(integers);
        System.out.println(integerSet);


    }
}
