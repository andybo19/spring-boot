package com.example.demo.designpatterns.template;

import java.io.*;

/**
 * @author wan yu
 * @date 2023/2/8 下午8:33
 */
public class KeeperTest {

    public static final int KB = 1024;
    public static final int DEFAULT_BUFFER_SIZE = 8 * KB;

    public static void main(String[] args) {
/*        Animal animal = new Animal();
        Animal dog = new Dog();
        Keeper keeper = new Keeper();
        keeper.feed(animal);
        keeper.feed(dog);*/
/*        List<Long> ids = new ArrayList<>();
        System.out.println(JSON.toJSONString(ids));
        String str = JSON.toJSONString(ids);
        List<Long> artworkNewIds = JSONArray.parseArray(str, Long.class);
        System.out.println(artworkNewIds);*/

/*        String userContactFilePath = "http%3A%2F%2Fgtms01.alicdn.com%2Ftfscom%2FLB14sKhHXXXXXXzXpXXXXXXXXXX.csv";
        String fileName = userContactFilePath.substring(userContactFilePath.lastIndexOf("/") + 1);
        System.out.println(fileName);*/

/*        String str = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(str);*/
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            File file = new File("/Users/mayongbo/Downloads/a.txt");
            inputStream = new FileInputStream(file);


            outputStream = new BufferedOutputStream(new FileOutputStream(new File("/Users/mayongbo/Downloads//c.txt")));
            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException ex) {

        } finally {
            safeClose(outputStream);
            safeClose(inputStream);
        }


    }

    public static void safeClose(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }

    public static void safeClose(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
            }
        }
    }
}
