package com.dumas.pedestal.common.util.security;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import io.netty.buffer.ByteBufUtil;

/**
 * TODO
 *
 * @author andaren
 * @version V1.0
 * @since 2020-05-03 20:17
 */
public class DESUtil {
    private static final String DES = "DES";
    private static final String C_DES = "DES/ECB/NoPadding";

    //测试
    public static void main(String args[]) {
        String sourceHex = "12345678123456781234567812345678";
        //待加密内容
        String str = sourceHex;
        //密码，长度要是8的倍数
        byte[] password = "12345678".getBytes();

        byte[] result = DESUtil.encrypt(sourceHex.getBytes(), password);
        System.out.println("加密后："+new String(result));
        System.out.println(ByteBufUtil.hexDump(result));
        //直接将如上内容解密
        try {
            byte[] decryResult = DESUtil.decrypt(result, password);
            System.out.println("解密后："+new String(decryResult));
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    /**
     * 加密
     * @param datasource byte[]
     * @param password String
     * @return byte[]
     */
    public static  byte[] encrypt(byte[] datasource, byte[] password) {
        try{
//                    SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(password);
            //创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
            SecretKey securekey = keyFactory.generateSecret(desKey);
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance(C_DES);
            //用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            //现在，获取数据并加密
            //正式执行加密操作
            return cipher.doFinal(datasource);
        }catch(Throwable e){
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 解密
     * @param src byte[]
     * @param password String
     * @return byte[]
     * @throws Exception
     */
    public static byte[] decrypt(byte[] src, byte[] password) throws Exception {
        // DES算法要求有一个可信任的随机数源
//        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        SecureRandom random = new SecureRandom();
        // 创建一个DESKeySpec对象
        DESKeySpec desKey = new DESKeySpec(password);
        // 创建一个密匙工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        // 将DESKeySpec对象转换成SecretKey对象
        SecretKey securekey = keyFactory.generateSecret(desKey);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(C_DES);
//        Cipher cipher = Cipher.getInstance(DES);
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, random);
        // 真正开始解密操作
        return cipher.doFinal(src);
    }
}
