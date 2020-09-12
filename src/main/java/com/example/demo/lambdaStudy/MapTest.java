package com.example.demo.lambdaStudy;

import com.example.demo.lambdaStudy.entity.Student;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author mayongbo
 * @Description
 * @date 2020/8/1 10:48
 */
public class MapTest {

    private static Map<String, Comparator<Student>> map = new HashMap<>();

    static {
        map.put("age",(o1,o2) -> o1.getAge() - o2.getAge());
        map.put("name",(o1,o2) -> o1.getName().compareTo(o2.getName()));
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setAge(29);
        s1.setName("tom");
        Student s2 = new Student();
        s2.setAge(19);
        s2.setName("bobo");
        ArrayList<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        List<Student> ageList = list.stream().sorted(map.get("age")).collect(Collectors.toList());
        List<Student> nameList = list.stream().sorted(map.get("name")).collect(Collectors.toList());
        //list.stream().sorted(Comparator.comparing(Student::getAge));
        list.sort(Comparator.comparing(Student::getAge));
        List<Student> collect = list.stream().sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList());
        System.out.println("原list+++++++++++++"+list);
        System.out.println("按照age排序后list+++++++++++++"+ageList);
        System.out.println("按照name排序后list+++++++++++++"+nameList);
        System.out.println("按照collect排序后list+++++++++++++"+collect);
    }

}
