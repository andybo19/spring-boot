package com.example.demo.lambdaStudy.chapter3;

import com.example.demo.lambdaStudy.entity.Album;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.example.demo.lambdaStudy.entity.SampleData.*;

/**
 * @author mayongbo
 * @Description
 * @date 2020/7/17 19:40
 */
public class Question3 {

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1, 2, 3,4, 5, 6, 7, 8, 9);
        int sum1 = list.stream().mapToInt(Integer::intValue).sum();
        Integer sum2 = list.stream().reduce(Integer::sum).orElse(0);
        Integer sum3 = list.stream().reduce(0, (acc, x) -> acc + x);
        System.out.println("+++++++++++++sum1: "+sum1);
        System.out.println("+++++++++++++sum2: "+sum2);
        System.out.println("+++++++++++++sum3: "+sum3);

        List<String> bList = membersOfTheBeatles.stream().flatMap(t -> Stream.of(t.getName(),t.getNationality())).collect(Collectors.toList());
        System.out.println("+++++++++++++++++bList:" + bList);

        List<Album> albumList = Arrays.asList(aLoveSupreme, sampleShortAlbum, manyTrackAlbum);
        List<Album> maxThree = getMaxThree(albumList);
        System.out.println("+++++++++++++++++albumList:" + albumList);
        System.out.println("+++++++++++++++++maxThree:" + maxThree);

        int totalMembers = membersOfTheBeatles.stream().map(artist -> artist.getMembers().count()).reduce(0L,Long::sum).intValue();
        System.out.println("+++++++++++++++++totalMembers:" + totalMembers);

        String str = "AbfdBC";
        long count = str.chars().filter(Character::isLowerCase).count();
        System.out.println("小写字母个数: " + count);

        Optional<String> max = bList.stream().max(Comparator.comparing(Question3::countLowercaseLetters));
        System.out.println("小写字母最大长度字符串: " + max);



    }

    public static List<Album> getMaxThree(List<Album> albums){
        return albums.stream().filter(album -> album.getTrackList().size() <= 3).collect(Collectors.toList());
    }

    public static int countLowercaseLetters(String string) {
        return (int) string.chars()
                           .filter(Character::isLowerCase)
                           .count();
    }

}
