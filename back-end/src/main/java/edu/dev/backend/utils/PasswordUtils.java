package edu.dev.backend.utils;

import java.util.UUID;

/**
 * Create By  @林俊杰
 * 2022/3/19 17:39
 *
 * @version 1.0
 */
public class PasswordUtils {
    /**
     * 匹配密码
     * @param salt 盐
     * @param rawPass 明文
     * @param encPass 密文
     * @return
     */
    public static boolean matches(String salt, String rawPass, String encPass) {
        return new PasswordEncoder(salt).matches(encPass, rawPass);
    }

    /**
     * 明文密码加密
     * @param rawPass 明文
     * @param salt
     * @return
     */
    public static String encode(String rawPass, String salt) {
        return new PasswordEncoder(salt).encode(rawPass);
    }

    /**
     * 获取加密盐
     * @return
     */
    public static String getSalt() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
    }

    public static void main(String[] args) {
        System.out.println(PasswordUtils.matches("helloSalt", "123456", "10f7a89302c5d04a7ae6ab368bc2c174"));
    }
}
