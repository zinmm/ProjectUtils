package com.sunhz.projectutils.encryptionutils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5EncryptionUtils {

    /**
     * 加密
     *
     * @param string 待加密内容
     * @return
     */
    public static String stringToMD5(String string) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {
        byte[] hash;

        hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }

        return hex.toString();
    }
}
