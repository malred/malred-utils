package org.malred.utils;

/**
 * 字符串操作工具类
 *
 * @author malguy-wang sir
 * @create ---
 */
public class StringUtils {

    /**
     * 首字母转小写
     *
     * @param str
     * @return
     */
    public static String lowerFirst(String str) {
        char[] chars = str.toCharArray();
        // 如果char[0]是大写
        if ('A' <= chars[0] && chars[0] <= 'Z') {
            chars[0] += 32;
        }
        return String.valueOf(chars);
    }
}
