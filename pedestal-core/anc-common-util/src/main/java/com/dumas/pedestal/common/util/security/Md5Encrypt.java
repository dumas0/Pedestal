package com.dumas.pedestal.common.util.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Md5Encrypt {
    private static final char[] DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c',
            'd', 'e', 'f'};

    public Md5Encrypt() {
    }

    public static final String encrypt(String text, String charSet) {
        if (text == null) {
            return "";
        } else {
            MessageDigest msgDigest = null;

            try {
                msgDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException var5) {
                throw new IllegalStateException("System doesn't support MD5 algorithm.");
            }

            if (charSet != null) {
                try {
                    msgDigest.update(text.getBytes(charSet));
                } catch (UnsupportedEncodingException var4) {
                    throw new IllegalStateException("System doesn't support your  EncodingException.");
                }
            }

            byte[] bytes = msgDigest.digest();
            return new String(encodeHex(bytes));
        }
    }

    public static final String encrypt(String text) {
        return encrypt(text, "UTF-8");
    }

    private static final char[] encodeHex(byte[] data) {
        int l = data.length;
        char[] out = new char[l << 1];
        int i = 0;

        for (int var4 = 0; i < l; ++i) {
            out[var4++] = DIGITS[(240 & data[i]) >>> 4];
            out[var4++] = DIGITS[15 & data[i]];
        }

        return out;
    }


    public final static String PARAM_SPLIT = "|";

    /**
     * 获取签名原串:按字典排序参数值+key
     *
     * @param param        需要签名的参数
     * @param ignoredParam 需要忽略的参数名称
     * @param md5Key
     * @return 签名
     */
    public static String buildSignStringSorted(Map<String, String> param, String ignoredParam, String md5Key) {
        Map<String, String> sortedParamMap = new TreeMap<>();
        for (Map.Entry<String, String> entry : param.entrySet()) {
            if (entry.getKey().equals(ignoredParam)) {
                continue;
            }
            sortedParamMap.put(entry.getKey(), entry.getValue());
        }
        List<String> allList = new LinkedList<>(sortedParamMap.values());
        allList.add(md5Key);

        return join(allList.iterator(), PARAM_SPLIT);
    }


    public static String join(Iterator iterator, String separator) {
        if (iterator == null) {
            return null;
        } else {
            StringBuffer buf = new StringBuffer(256);

            while (iterator.hasNext()) {
                Object obj = iterator.next();
                if (obj != null) {
                    buf.append(obj);
                }

                if (separator != null && iterator.hasNext()) {
                    buf.append(separator);
                }
            }

            return buf.toString();
        }
    }

    public static void main(String[] args) {
        String md5key = "";
        Map<String, String> param = new HashMap<>();
        String sign = buildSignStringSorted(param, "", md5key);

        System.out.println(sign);
    }
}