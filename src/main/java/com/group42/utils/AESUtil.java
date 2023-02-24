package com.group42.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

@Slf4j
public class AESUtil {

    private static final String ENCODING = "UTF-8";
    private static final String AES_ALGORITHM = "AES";
    private static final String CIPHER_CBC_PADDING = "AES/CBC/ISO10126Padding";
    private static final String IV_SEED = "SEED20227UAT1111";
    private static final String KEY = "UAT20230208KEY11";

    public static String encrypt(String content) {
        return encryptCBC(content, KEY);
    }

    public static String decrypt(String content) {
        return decryptCBC(content, KEY);
    }

    public static String encryptCBC(String content, String aesKey) {
        if (StringUtils.isBlank(content)) {
            log.info("AES_CBC encrypt: the content is null!");
            return null;
        }
        if (StringUtils.isNotBlank(aesKey) && aesKey.length() == 16) {
            try {
                byte[] bytes = aesKey.getBytes(ENCODING);
                SecretKeySpec keySpec = new SecretKeySpec(bytes, AES_ALGORITHM);
                Cipher cipher = Cipher.getInstance(CIPHER_CBC_PADDING);
                IvParameterSpec iv = new IvParameterSpec(IV_SEED.getBytes(ENCODING));
                cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);
                byte[] encrypted = cipher.doFinal(content.getBytes(ENCODING));
                return Base64.encodeBase64String(encrypted);
            } catch (Exception e) {
                log.info("AES_CBC encrypt exception:" + e.getMessage());
                throw new RuntimeException(e);
            }

        } else {
            log.info("AES_CBC encrypt: the aesKey is null or error!");
            return null;
        }
    }

    public static String decryptCBC(String content, String aesKey) {
        if (StringUtils.isBlank(content)) {
            log.info("AES_CBC decrypt: the content is null!");
            return null;
        }
        if (StringUtils.isNotBlank(aesKey) && aesKey.length() == 16) {
            try {
                byte[] bytes = aesKey.getBytes(ENCODING);
                SecretKeySpec keySpec = new SecretKeySpec(bytes, AES_ALGORITHM);
                IvParameterSpec iv = new IvParameterSpec(IV_SEED.getBytes(ENCODING));
                Cipher cipher = Cipher.getInstance(CIPHER_CBC_PADDING);
                cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
                byte[] decodeBase64 = Base64.decodeBase64(content);
                byte[] decrypted = cipher.doFinal(decodeBase64);
                return new String(decrypted, ENCODING);
            } catch (Exception e) {
                log.info("AES_CBC decrypt exception:" + e.getMessage());
                return null;
            }
        } else {
            log.info("AES_CBC decrypt: the aesKey is null or error!");
            return null;
        }
    }


    public static void main(String[] args) {
        String password = "123";
        String cbcResult = encrypt(password);
        System.out.println("password: " + password + ", encrypt: " + cbcResult);
        String cbcDecrypt = decrypt("5gb8WEBlcW8xDhQqhshY1A==");
        System.out.println("aes decrypt: " + cbcDecrypt);
    }
}