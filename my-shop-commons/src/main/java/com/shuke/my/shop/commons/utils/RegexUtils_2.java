package com.shuke.my.shop.commons.utils;

/**
 * 
 * <p>
 * 正则表达式
 * </p>
 * 
 * @author shuke
 * @version v1.0.0
 * @since 2020-03-05 22:58:50
 * @see com.shuke.my.shop.commons.utils
 *
 */
public class RegexUtils_2 {
    /**
     * 验证手机号
     */
    public static final String PHONE = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

    /**
     * 验证邮箱地址
     */
    public static final String EMAIL = "\\w+(\\.\\w)*@\\w+(\\.\\w{2,3}){1,3}";

    /**
     * 验证手机号
     * @param phone
     * @return
     */
    public static boolean checkPhone(String phone) {
        return phone.matches(PHONE);
    }

    /**
     * 验证邮箱
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        return email.matches(EMAIL);
    }
}
