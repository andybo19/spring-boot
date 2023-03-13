package com.example.demo.util;

/**
 * @author wan yu
 * @date 2022/11/17 上午11:44
 */
public class AESDemo {

    public static void main(String[] args) throws Exception {
        //String key = CryptoUtils.generateSymmetricKey(CryptoUtils.Algorithm.AES_CBC_PKCS5);
        String key = "TBAbgPzpYqL2X2u7DkZUkA==";
        String k = "{\"fields\":[\"uid\",\"project_name\"],\"odpsProjectName\":\"dianying\",\"odpsTableName\":\"ads_gw_dream_send_project_message_d\",\"partition\":{\"ds\":\"20221122\",\"dt\":\"\"}}";
       /* System.out.println("生成的key为：" + key);
        String cipherText = CryptoUtils.encryptSymmetrically(key, key, "Hello", CryptoUtils.Algorithm.AES_CBC_PKCS5);
        System.out.println("加密后的密文为：" + cipherText);
*/
        String plainText = CryptoUtils.decryptSymmetrically(key, key, "uoP4yGDAyZSwcOTxDIgHkg==", CryptoUtils.Algorithm.AES_CBC_PKCS5);
        System.out.println("解密后的明文为：" + plainText);
    }
}
