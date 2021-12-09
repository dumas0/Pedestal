package com.dumas.pedestal.framework.mybatis.handler;

import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

/**
 * @author dumas
 * @date 2021/12/06 3:06 PM
 */
@Component
@ConditionalOnProperty(prefix = "aes", name = "encrypt.enabled", havingValue = "true")
public class AES implements InitializingBean {
    @Value("${aes.mobile.secret:80E4FEF93BE20AAA}")
    private String secret;
    static cn.hutool.crypto.symmetric.AES hutoolAES;

    /**
     * Converts String to UTF8 bytes
     *
     * @param input the input string
     * @return UTF8 bytes
     */
    private static byte[] getUTF8Bytes(String input) {
        return input.getBytes(StandardCharsets.UTF_8);
    }


    public static void main(String[] args) {
        String enStr = encrypt("19957879979");
        System.out.println(enStr);
        System.out.println(decrypt(enStr));
    }

    /**
     * 加密
     *
     * @param content
     * @return
     */
    public static String encrypt(String content) {
        if (StringUtils.isEmpty(content)) {
            return content;
        }
        return hutoolAES.encryptBase64(content);//加密
    }

    /**
     * 解密
     *
     * @param content
     * @return
     */
    public static String decrypt(String content) {
        if (StringUtils.isEmpty(content)) {
            return content;
        }
        return hutoolAES.decryptStr(content);//加密
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        SecretKeySpec key = new SecretKeySpec(getUTF8Bytes(secret), "AES");
        IvParameterSpec iv = new IvParameterSpec(getUTF8Bytes(secret));
        hutoolAES = new cn.hutool.crypto.symmetric.AES(Mode.CBC, Padding.PKCS5Padding, key, iv);
    }
}
