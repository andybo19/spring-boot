package com.example.demo.file;

import java.io.*;

/**
 * @author wan yu
 * @date 2023/3/13 下午8:13
 */
public class FileOperation {

    public static final int KB = 1024;
    public static final int DEFAULT_BUFFER_SIZE = 8 * KB;

    public static void saveLocalFile(String filePath){
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            File file = new File("/Users/mayongbo/Downloads/a.txt");
            inputStream = new FileInputStream(file);


            outputStream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
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
