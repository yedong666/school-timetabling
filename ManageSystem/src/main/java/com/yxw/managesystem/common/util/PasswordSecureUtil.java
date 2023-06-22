package com.yxw.managesystem.common.util;


import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 密码加密工具
 */
public class PasswordSecureUtil {
    /**
     * 密钥
     */
    private static byte[] key;

    static {
        try {
            //从文件读取密钥
            key = Files.readAllBytes(Paths.get("password-key.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    ;
    /**
     * 对称加密工具
     */
    private static SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);

    /**
     * 对密码明文加密
     * @param password
     * @return
     */
    public static String encrypt(String password){
        //加密为16进制字符串（Hex表示）
        return aes.encryptHex(password);
    }

    /**
     * 对密码密文解密
     * @param password
     * @return
     */
    public static String decrypt(String password){
        //解密为utf-8编码字符串
        return aes.decryptStr(password, CharsetUtil.CHARSET_UTF_8);
    }

    public static void main(String[] args) throws IOException {
        String encrypt = encrypt("12345678");
        System.out.println(encrypt);
        System.out.println(decrypt("043e65ecdeb7b46e9a06840edc213899"));
    }
}
