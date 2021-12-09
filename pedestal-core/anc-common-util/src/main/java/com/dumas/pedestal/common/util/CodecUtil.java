package com.dumas.pedestal.common.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;

/**
 * @author dumas
 */
public class CodecUtil {
    public static final String ALGORITHM_MD5 = "MD5";

    private CodecUtil() {}
    public static byte[] encodeMD5(String character, String salt) {
        try {
            if (salt != null) {
                character = character + "{" + salt + "}";
            }
            MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM_MD5);
            messageDigest.update(character.getBytes("utf-8"));
            return messageDigest.digest();
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static String encodeHex(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; ++i) {
            String hex = Integer.toHexString(bytes[i] & 255);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex);
        }
        return sb.toString();
    }
    public static String encodeMD5AsHexString(String character) {
        return encodeHex(encodeMD5((String) character, (String) null));
    }

    public static String encodeUrl(String character) {
        try {
            return URLEncoder.encode(character, "utf-8");
        } catch (UnsupportedEncodingException var2) {
            var2.printStackTrace();
            return null;
        }
    }

    public static String encodeDESAsString(String character, String secretKey) {
        try {
            return encodeDESAsString(character.getBytes("utf-8"), secretKey);
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }
    public static String encodeDESAsString(byte[] character, String secretKey) {
        return new String(Base64.encodeBase64(encodeDES(character, secretKey)));
    }

    private static byte[] encodeDES(byte[] character, String salt) {
        try {
            SecretKey secretKey = getSaltSecretKey(salt);
            //加密算法：DES，加密mode：ECB，填充：PKCS5Paddin
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return cipher.doFinal(character);
        } catch (Exception var4) {
            var4.printStackTrace();
            return null;
        }
    }

    private static SecretKey getSaltSecretKey(String secretKey) {
        try {
            DESKeySpec desKey = new DESKeySpec(secretKey.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            return keyFactory.generateSecret(desKey);
        } catch (Exception var5) {
            var5.printStackTrace();
            return null;
        }
    }
}
