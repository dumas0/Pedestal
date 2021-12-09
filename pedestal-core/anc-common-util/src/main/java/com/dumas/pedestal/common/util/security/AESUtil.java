package com.dumas.pedestal.common.util.security;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.dumas.pedestal.common.util.Base64Util;
import io.netty.buffer.ByteBufUtil;

public class AESUtil{

    private static final String KEY_ALGORITHM = "AES";
    private static final String JAVA_DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";//Java默认的加密算法
    private static final String C_DEFAULT_CIPHER_ALGORITHM = "AES/ECB/NoPadding";//C默认的加密算法

    /**
     * AES 加密操作
     *
     * @param content 待加密内容
     * @param key 加密密钥
     * @return 返回Base64转码后的加密数据
     */
    public static String encryptString(String content, String key) {
        try {
            Cipher cipher = Cipher.getInstance(C_DEFAULT_CIPHER_ALGORITHM);// 创建密码器
            byte[] byteContent = content.getBytes(StandardCharsets.UTF_8);
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(key));// 初始化为加密模式的密码器
            byte[] result = cipher.doFinal(byteContent);// 加密
            return Base64Util.encodeToString(result);//通过Base64转码返回
        } catch (Exception ex) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * AES/ECB/NoPadding 加密
     * @param content   加密内容
     * @param key       加密秘钥（不用随机生成）
     * @return 密文字节组
     */
    public static byte[] encryptBytes(byte[] content, byte[] key) {
        try {
            Cipher cipher = Cipher.getInstance(C_DEFAULT_CIPHER_ALGORITHM);// 创建密码器
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKeyWithoutGenerateKey(key));// 初始化为加密模式的密码器
            byte[] result = cipher.doFinal(content);// 加密
            return result;
        } catch (Exception ex) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * AES 解密操作
     *
     * @param content
     * @param key
     * @return
     */
    public static String decryptBase64Str(String content, String key) {
        try {
            //实例化
            Cipher cipher = Cipher.getInstance(C_DEFAULT_CIPHER_ALGORITHM);
            //使用密钥初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(key));
            //执行操作
            byte[] result = cipher.doFinal(Base64Util.transformBase64(content));
            return new String(result, StandardCharsets.UTF_8);
        } catch (Exception ex) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String decryptBytes(byte[] content, byte[] key) {
        try {
            //实例化
            Cipher cipher = Cipher.getInstance(C_DEFAULT_CIPHER_ALGORITHM);
            //使用密钥初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, getSecretKeyFromBytes(key));
            //执行操作
            byte[] result = cipher.doFinal(content);
            return new String(result, StandardCharsets.UTF_8);
        } catch (Exception ex) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * AES/ECB/NoPadding 解密
     * @param content   解密内容
     * @param key       解密秘钥（非随机生成）
     * @return
     */
    public static byte[] decryptBytes2bytes(byte[] content, byte[] key) {
        try {
            //实例化
            Cipher cipher = Cipher.getInstance(C_DEFAULT_CIPHER_ALGORITHM);
            //使用密钥初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, getSecretKeyWithoutGenerateKey(key));
            //执行操作
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (Exception ex) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * 生成加密秘钥
     *
     * @return
     */
    private static SecretKeySpec getSecretKey(final String key) {
        //返回生成指定算法密钥生成器的 KeyGenerator 对象
        KeyGenerator kg = null;
        try {
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);
            //AES 要求密钥长度为 128
            kg.init(128, new SecureRandom(key.getBytes()));
            //生成一个密钥
            SecretKey secretKey = kg.generateKey();
            return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);// 转换为AES专用密钥
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * 生成加密秘钥
     *
     * @return
     */
    private static SecretKeySpec getSecretKeyFromBytes(final byte[] key) {
        //返回生成指定算法密钥生成器的 KeyGenerator 对象
        KeyGenerator kg = null;
        try {
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);
//            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            SecureRandom random = new SecureRandom();
            random.setSeed(key);
            //AES 要求密钥长度为 128
            kg.init(128, random);
            //生成一个密钥
            SecretKey secretKey = kg.generateKey();
            return new SecretKeySpec(key, KEY_ALGORITHM);// 转换为AES专用密钥
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private static SecretKeySpec getSecretKeyWithoutGenerateKey(final byte[] key) {
        // 不用生成指定算法密钥生成器的 KeyGenerator 对象
        return new SecretKeySpec(key, KEY_ALGORITHM);
    }

    public static void main(String[] args) {
        String content = "24486E5687625ABDBF17D9A2C4171A0194ED8F1E11B3D7090CB6E9106F22EE13";

        byte[] keyByte = new byte[]{0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01};
        byte[] ses = AESUtil.encryptBytes(ByteBufUtil.decodeHexDump(content), keyByte);
        System.out.println(ByteBufUtil.hexDump(ses));
        byte[] encrypedBytes = Base64Util.decode(content.getBytes());
        if (encrypedBytes.length != 32) {
            System.out.println("数据包非 32 字节");
            return;
        }
        byte[] head = new byte[16];
        System.arraycopy(encrypedBytes, 0, head, 0, 16);
        byte[] feet = new byte[16];
        System.arraycopy(encrypedBytes, 16, feet, 0, 16);

        System.out.println("head:"+AESUtil.decryptBytes(head, keyByte));
        System.out.println("feet:"+AESUtil.decryptBytes(feet, keyByte));

    }

}